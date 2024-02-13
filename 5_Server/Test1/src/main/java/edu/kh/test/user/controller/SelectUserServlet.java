package edu.kh.test.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;


@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userNo = Integer.parseInt(req.getParameter("userNo"));

		UserDAO dao = new UserDAO();

		UserDTO user = dao.selectUser(userNo);

		if(user != null) {

			req.setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(req, resp);

		}else {

			req.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(req, resp);

		}

	}
}


