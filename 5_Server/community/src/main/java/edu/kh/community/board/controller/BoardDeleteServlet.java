package edu.kh.community.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.board.model.service.BoardService;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int boardNo = Integer.parseInt(req.getParameter("no"));
			int type = Integer.parseInt(req.getParameter("type"));

			int result = new BoardService().deleteBoard(boardNo);

			HttpSession session = req.getSession();
			String path = null;
			String message = null;

			if(result > 0) { // 성공
				message = "게시글이 삭제되었습니다.";
				path = "list?type=" + type; // 해당 게시판 목록 1페이지
				
			}else {
				message = "게시글 삭제가 실패했습니다.";
				
				// path = "detail?no=" + boardNo + "&type=" + type; 
				path = req.getHeader("referer");
				// 상세 페이지 == 이전 요청 페이지 주소 == referer
			}

			session.setAttribute("message", message);
			resp.sendRedirect(path);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
