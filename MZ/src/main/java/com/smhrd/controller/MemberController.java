package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Member;
import com.smhrd.mapper.MemberMapper;


// Controller(POJO)를 찾기 위해서는
// 1. servlet-context.xml 파일에서 어떤 패키지에서 찾을건지 명시하기
// 2. @Controller 달아주기
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	

	
	@Autowired
	private MemberMapper mapper;

	@PostMapping("/joinMember")
	public String joinMember(Member member, Model model) {	// email, pw, tel, address
		System.out.println(member.toString());
		mapper.join(member);
		model.addAttribute("joinEmail", member.getEmail());
		
		return "JoinSuccess";
	}
	
	@PostMapping("/loginMember")
	public String loginMember(Member member, HttpSession session) { // email, pw
		
		System.out.println(member.toString());
		member = mapper.login(member);
		session.setAttribute("loginMember", member);
		return "Main";
	}
	
	@GetMapping("/memberLogout")
	public String memberLogout(HttpSession session) {
		
		//session.removeAttribute("loginMember");
		session.invalidate();
		
		return "Main";
	}
	
	@GetMapping("/goUpdateMember")
	public String goUpdateMember() {  
		return "UpdateMember";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(Member member, HttpSession session) {	// 세션에서 email을 가져와서 사용하면 추가적 Member 객체에 값을 
												// 할당하는 과정을 거쳐야 하기 때문에 updateMmeber.jsp에서 email도 같이 보내준다.
		System.out.println(member.toString());
		mapper.update(member);
		session.setAttribute("loginMember", member);
		
		return "Main";
	}
	
	// 페이지 이동 + 테입블에서 전체 회원 조회
	@GetMapping("/showMember")
	public String showMember(Model model) {
		
		List<Member> list = mapper.showMember();
		model.addAttribute("list", list);
		return "ShowMember";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(@RequestParam("email") String email) {	// deleteMember?email=??&pw=??
		
		mapper.deleteMember(email);
		
		// return "showMember"하면 멤버 목록을 DB에 요청하는 과정이 생략된다.
		// query string 방식
		return "redirect:/showMember";
		// 값을 하나만 받아올 때는 path variable 방식도 가능하다.
	}
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	
	@GetMapping("/") // Get 방식으로 '/'라고 요청이 들어오면 아래의 메서드를 실행.
	public String main() {
		return "Main";	// /WEB-INF/views/Main.jsp
	}
	
	@GetMapping("/emailCheck")
	public @ResponseBody int emailCheck(@RequestParam("inputE") String inputE) {
		
		Member member = mapper.emailCheck(inputE);
		
		if(member == null) {
			return 1;
		} else {
			return 0;
		}
	}
}
