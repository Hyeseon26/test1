package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 요청/응답 클래스 + bean 등록
@RequestMapping("/member") // 공통된 주소 앞부분 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리
public class MemberController {
	
	// 로그인 	: /member/login
	// 로그아웃	: /member/logout
	
	// 로그인 (/member/login), POST 방식 처리
	// @RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		
		// 파라미터 전달 방법 1 : HttpServletRequest를 이용하는 방법
		// -> Controller 메소드에 매개변수로 HttpServletRequest 작성
		
		String inputEmail = req.getParameter("inputEmail");
		
		System.out.println("inputEmail : " + inputEmail);
		
		// ** redirect 방법! **
		
		// "redirect:요청주소"
		return "redirect:/";
	}
	
	// @PostMapping
	// -> @RequestMapping의 자식으로
	//    POST 방식 요청을 연결하는 어노테이션
	@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
						/*@RequestParam("inputPw")*/ String inputPw) {
		
		// 파라미터 전달 방법 2 : @RequestParam 어노테이션 이용
		
		// @RequestParam 어노테이션
		
		// - request 객체를 이용한 파라미터 전달 어노테이션
		// - 매개변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 주입됨.
		
		// ** 파라미터의 name 속성 값과
		//    매개 변수명이 같으면 @RequestParam 생략 가능!! **
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// 메인 페이지 리다이렉트(재요청)
		return "redirect:/";
	}

}
