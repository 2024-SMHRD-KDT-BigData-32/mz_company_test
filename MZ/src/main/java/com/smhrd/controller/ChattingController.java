package com.smhrd.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder; // URLDecoder 임포트 추가
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext; // ServletContext 임포트 추가
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Chatting;
import com.smhrd.mapper.ChattingMapper;

@RestController
@RequestMapping("/chat")
public class ChattingController {

	private static final Logger logger = LoggerFactory.getLogger(ChattingController.class);

	@Autowired
	private ChattingMapper mapper;

	@Autowired
	private ServletContext servletContext; // ServletContext 객체 주입

	@GetMapping("/history/{prj_idx}")
	public ResponseEntity<Map<String, Object>> chatList(@PathVariable("prj_idx") int prj_idx) {
		try {
			List<Chatting> chatList = mapper.chatList(prj_idx);
			Map<String, Object> response = new HashMap<>();
			response.put("success", true);
			response.put("messages", chatList);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("채팅 목록 조회 실패: {}", e.getMessage());
			Map<String, Object> error = new HashMap<>();
			error.put("success", false);
			error.put("message", "채팅 목록 조회 실패");
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/files")
	@ResponseBody
	public List<Chatting> getChatFiles(@RequestParam("croom_idx") Integer prj_idx) {
		// MyBatis Mapper로 파일 데이터 조회
		Map<String, Object> params = new HashMap<>();
		params.put("prj_idx", prj_idx);
		List<Chatting> files = mapper.findFilesByPrjIdx(params);
		return files;
	}


	@GetMapping("/fileDownload")
	public ResponseEntity<Resource> downloadFile(
	        @RequestParam("file_url") String file_url
	) throws IOException {
	    logger.info("다운로드 요청 URL (인코딩됨): {}", file_url); // 로그 추가

	    String decodedFileUrl = URLDecoder.decode(file_url, "UTF-8"); // URL 디코딩
	    logger.info("다운로드 요청 URL (디코딩됨): {}", decodedFileUrl); // 로그 추가

	    // 파일 저장 경로를 기준으로 파일 이름 추출
	    String filename = decodedFileUrl.substring(decodedFileUrl.lastIndexOf('/') + 1);
	    String uploadDir = servletContext.getRealPath("/resources/workFile");
	    String fullPath = Paths.get(uploadDir, filename).toString();
	    logger.info("실제 파일 경로: {}", fullPath); // 로그 추가

	    File file = new File(fullPath);

	    logger.info("파일 존재 여부: {}", file.exists()); // 로그 추가
	    logger.info("파일 읽기 가능 여부: {}", file.canRead()); // 로그 추가

	    if (!file.exists() || !file.canRead()) {
	        logger.error("파일을 찾을 수 없거나 읽을 수 없습니다: {}", fullPath);
	        return ResponseEntity.notFound().build();
	    }

	    // 파일 리소스 생성
	    Resource resource = new FileSystemResource(file);

	    // HTTP 헤더 설정
	    HttpHeaders headers = new HttpHeaders();

	    String encodedFilename = URLEncoder.encode(file.getName(), StandardCharsets.UTF_8).replaceAll("\\+", "%20");
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFilename);

	    headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file.toPath()));

	    // 파일 스트림 반환
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .body(resource);
	}


	// 채팅 글 저장
	@PostMapping("/message")
	public ResponseEntity<String> messageSave(@RequestBody Chatting chatMessage, @RequestParam("prj_idx") int prj_idx) {
		try {
			logger.info("채팅 메시지 저장 요청 (prj_idx: {}): {}", prj_idx, chatMessage);
			chatMessage.setCroom_idx(prj_idx); // CROOM_IDX 필드에 PRJ_IDX 값 저장
			int result = mapper.messageSave(chatMessage);
			logger.info("채팅 메시지 저장 결과: {}", result);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("채팅 메시지 저장 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// file 업로드
	@PostMapping("/fileUpload")
	public ResponseEntity<?> uploadChatFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("prj_idx") Integer prj_idx,
			@RequestParam("chatter") String chatter
	) {
		try {
			// 실제 저장 위치 (webapp 폴더 기준 상대 경로)
			String uploadDir = servletContext.getRealPath("/resources/workFile");
			System.out.println("파일 저장 경로: " + uploadDir);

			File dir = new File(uploadDir);
			if (!dir.exists()) {
				boolean result = dir.mkdirs();
				System.out.println("폴더 생성 결과: " + result);
				if (!result) {
					logger.error("업로드 디렉토리 생성 실패: {}", uploadDir);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("업로드 디렉토리 생성 실패");
				}
			}

			// 파일 이름 안전하게 처리 (한글, 특수문자 이슈 예방)
			String originalFilename = file.getOriginalFilename().replaceAll("[<>:\"/\\\\|?*]", "_");
			String filePath = Paths.get(uploadDir, originalFilename).toString();

			// 실제 파일 저장
			file.transferTo(new File(filePath));

			// DB에는 상대 경로로 저장 (프로젝트 접근 가능하도록)
			String file_url = "/resources/workFile/" + originalFilename;

			Chatting chat = new Chatting();
			chat.setCroom_idx(prj_idx); // CROOM_IDX 필드에 PRJ_IDX 값 저장
			chat.setChatter(chatter);
			chat.setChat_file(originalFilename);
			chat.setFile_url(file_url);
			chat.setMessageType(Chatting.MessageType.TALK);
			chat.setCreated_at(new Timestamp(System.currentTimeMillis()));

			mapper.insertChatFile(chat);

			System.out.println("파일 저장 경로: " + uploadDir);
			System.out.println("최종 파일 경로: " + filePath);
			System.out.println("보내주는 값이 뭘까?"+ ResponseEntity.ok(file_url));
			return ResponseEntity.ok(file_url);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("업로드 실패: " + e.getMessage());
		}

	}
}