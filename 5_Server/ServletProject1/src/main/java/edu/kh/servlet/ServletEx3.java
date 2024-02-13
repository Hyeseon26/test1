package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpServletRequest  : 클라이언트 정보 + 전달된 값(input)
		// HttpServletResponse : 서버가 클라이언트에게 응답할 때 필요한 도구, 방법을 가지고 있는 객체

		String inputId = req.getParameter("inputId");
		String inputPw1 = req.getParameter("inputPw1");
		String inputPw2 = req.getParameter("inputPw2");
		String inputName = req.getParameter("inputName");
		String inputEmail = req.getParameter("inputEmail");

		String[] color = req.getParameterValues("color");

		// Dynamic Web Project(동젝 웹 프로젝트)
		// - 요청에 따라 응답 화면(HTML)을 실시간으로 만드는 것(동적)


		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");

		out.print("<head>");
		out.print("<title>" + inputName + "님의 정보</title>");
		out.print("</head>");

		out.print("<body>");

		if(inputPw1.equals(inputPw2)) {
			out.print("<ul>");

			out.print("<li>아이디 : " + inputId + "</li>");
			out.print("<li>이름 : " + inputName + "</li>");
			out.print("<li>이메일 : " + inputEmail + "</li>");

			out.print("<li>좋아하는 색 : ");
			if(color != null) {
				for(String i : color) {
					out.print("<span>" + i + "</span> ");
				}
			}else {
				out.print("<span>없습니다.</span>");
			}

			out.print("</li>");
			out.print("</ul>");

		}else {
			out.print("<h1>비밀번호가 일치하지 않습니다.</h1>");
		}

		out.print("</body>");

		out.print("</html>");











	}

}
