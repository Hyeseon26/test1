package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;

// 닉네임 중복 검사 (ajax)

@WebServlet("/member/nicknameDupCheck")
public class NicknameDupCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기(data 속성의 값)
		String memberNickname = req.getParameter("memberNickname");
	
		try {
			MemberService service = new MemberService();
			
			// 닉네임 중복 검사 Service 호출 후 결과 반환 받기
			int result = service.nicknameDupCheck(memberNickname);
			
			// 동기식    	-> forward 또는 redirect로 응답 (화면 전환)
			// 비동기식  	-> 응답용 스트림을 이용해 데이터 전달 (데이터가 현재 화면 추가)

			resp.getWriter().print(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
