package com.smhrd.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import com.smhrd.entity.Chatting;
import com.smhrd.mapper.ChattingMapper;

@RestController
@RequestMapping("/chat")
public class ChattingController {

	private static final Logger logger = LoggerFactory.getLogger(ChattingController.class);
	
	@Autowired
	private ChattingMapper mapper;
	
	// 채팅방 글 불러오기
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
    public List<Chatting> getChatFiles(@RequestParam("croom_idx") Integer croom_idx) {
        // MyBatis Mapper로 파일 데이터 조회
        Map<String, Object> params = new HashMap<>();
        params.put("croom_idx", croom_idx);
        List<Chatting> files = mapper.findFilesByCroomIdx(params);
        return files;
    }
	
	
	@GetMapping("/fileDownload")
	public ResponseEntity<Resource> downloadFile(@RequestParam("file_url") String file_url) throws IOException {
		String basePath = "C:/Users/smhrd/git/mz_company_test/MZ/src/main/webapp/";
        String relativePath = "resources/workFile/";
        String fullPath = basePath + relativePath + file_url;
        File file = new File(fullPath);

        if (!file.exists() || !file.canRead()) {
            System.out.println("File not found: " + fullPath);
            return ResponseEntity.notFound().build();
        }

	    // 파일 리소스 생성
	    Resource resource = new FileSystemResource(file);

	    // HTTP 헤더 설정
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
	    headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file.toPath()));

	    // 파일 스트림 반환
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .body(resource);
	}
	
	
	// 채팅 글 저장
	@PostMapping("/message")
	public ResponseEntity<String> messageSave(@RequestBody Chatting chatMessage) {
		try {
			logger.info("일정 추가: {}", chatMessage);
			int result = mapper.messageSave(chatMessage);
			logger.info("일정 추가 결과: {}", result);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 추가 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// file 업로드
	@PostMapping("/fileUpload")
	public ResponseEntity<?> uploadChatFile(
	        @RequestParam("file") MultipartFile file,
	        @RequestParam("croom_idx") Integer croom_idx,
	        @RequestParam("chatter") String chatter
	) {
	    try {
	        // 원하는 실제 저장 위치로 경로 수정
	        String uploadDir = Paths.get("C:", "Users", "smhrd", "git", "mz_company_test", "MZ", "src", "main", "webapp", "resources", "workFile").toString();
//	        String uploadDir = Paths.get(System.getProperty("user.dir"), "src", "main", "webapp", "resources", "workFile").toString();
	        System.out.println("파일 저장 경로: " + uploadDir);
	        
	        
//	        String uploadDir = "C:\\Users\\smhrd\\git\\mz_company_test\\MZ\\src\\main\\webapp\\resources\\workFile";
//	        String filePath = uploadDir + File.separator + file.getOriginalFilename();
//	        file.transferTo(new File(filePath));

	        File dir = new File(uploadDir);
	        if (!dir.exists()) {
	            boolean result = dir.mkdirs();
	            System.out.println("폴더 생성 결과: " + result);
	        }

	        // 파일 이름 안전하게 처리 (한글, 특수문자 이슈 예방)
	        String originalFilename = file.getOriginalFilename().replaceAll("[<>:\"/\\\\|?*]", "_");

//	        String decodedFileName = new String(originalFilename.getBytes("ISO-8859-1"), "UTF-8");
	        
	        String filePath = Paths.get(uploadDir, originalFilename).toString();

	        // 실제 파일 저장
	        file.transferTo(new File(filePath));

	        // DB에는 상대 경로로 저장 (프론트 접근 가능하도록)
	        String file_url = "/resources/workFile/" + originalFilename;

	        Chatting chat = new Chatting();    
	        chat.setCroom_idx(croom_idx);
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
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("업로드 실패");
	    }
	
	}
}
