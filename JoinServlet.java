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

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int stu_id = Integer.parseInt(request.getParameter("stu_id"));
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone_num = request.getParameter("phone_num");
		System.out.println(stu_id + " " + pwd + " " + name + " " + email + " " + phone_num);
		MemberVO mVo = new MemberVO();
		mVo.setStu_id(stu_id);
		mVo.setPwd(pwd);
		mVo.setName(name);
		mVo.setEmail(email);
		mVo.setPhone_num(phone_num);

		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(mVo);

		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("stu_id", mVo.getStu_id());
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("message", "회원 가입에 실패했습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
			dispatcher.forward(request, response);
		}
	}
}