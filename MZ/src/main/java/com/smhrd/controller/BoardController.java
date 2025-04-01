package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper mapper;

	@GetMapping("/goMain")
	public String goMain() {
		return "Main";
	}

	// BoardMain.jsp로 이동
	@GetMapping("/boardMain")
	public String boardMain(Model model) {

		// BoardMapper 인터페이스에 showBoard()

		// BoardMapper.xml 파일에 id값이 showBoard인 select 문 만들기
		List<Board> list = mapper.showBoard();
		model.addAttribute("list", list);
		return "BoardMain";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("idx") int idx) {
		mapper.deleteBoard(idx);
		return "redirect:/boardMain";
	}

	@GetMapping("/goBoardWrite")
	public String goBoardWrite() {
		return "BoardWrite";
	}

	// 게시글 작성(파일 업로드) 메서드
	@PostMapping("/boardInsert")
	public String boardInsert(Board board, HttpServletRequest request) {

		// 파일 업로드를 위한 설정

		// 업로드를 하기 위한 변수 설정
		MultipartRequest multi = null;

		// 1. 요청 객체 request
		// 2. 이미지를 저장할 폴더의 경로
		// String savePath =
		// request.getServletContext().getRealPath("resources/upload");
		String savePath = request.getRealPath("resources/upload");

		// 3. 허용 가능한 파일의 크기
		int fileMaxSize = 1024 * 1024 * 10; // 10MB
		
		// 4. 파일 이름에 대한 인코딩
		String enc = "UTF-8";
		
		// 5. 이름이 중복되지 않도록 하는 객체
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();

		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, enc, dfrp);
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String content = multi.getParameter("content");
			String filename = multi.getFilesystemName("filename"); 
			
			board = new Board(title, writer, filename, content);
			System.out.println(board.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 데이터베이스에 board객체 저장하기
		int cnt = mapper.boardInsert(board);
		
		// 데이터베이스에 잘 저장되었다면 콘솔 창으로 [업로드 완료] [업로드 실패] 출력
		if (cnt > 0) {
			System.out.println("[업로드 완료]");
		} else {
			System.out.println("[업로드 실패]");
		}
		return "redirect:/boardMain";
	}
	
	@GetMapping("/boardContent")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		
		// idx 값에 해당하는 게시글 DB에서 가져오기
		
	    Board board = mapper.boardContent(idx);
	    model.addAttribute("board", board);
	    
		return "BoardDetail";
	}
}
