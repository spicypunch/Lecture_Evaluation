package com.jm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jm.dao.MemberDAO;
import com.jm.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null) {
			url = "index.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		int stu_id = Integer.parseInt(request.getParameter("stu_id"));
		String pwd = request.getParameter("pwd");
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(stu_id, pwd);
		
		if (result == 1) {
			MemberVO mVo = mDao.getMember(stu_id);
			HttpSession session = request.getSession();
			session.setAttribute("user", mVo);
			request.setAttribute("message", "ȸ�� ���Կ� �����߽��ϴ�.");
			url = "index.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�.");
		} else if(result == -1) {
			request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}