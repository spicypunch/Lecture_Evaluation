package com.jm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.dao.MemberDAO;
import com.jm.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int stu_id = Integer.parseInt(request.getParameter("stu_id"));
	MemberDAO mDao = MemberDAO.getInstance();
	
	MemberVO mVo = mDao.getMember(stu_id);
	request.setAttribute("mVo", mVo);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("member/MemberUpdate.jsp");
	dispatcher.forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int stu_id = Integer.parseInt(request.getParameter("stu_id"));
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone_num = request.getParameter("phone_num");
		
		MemberVO mVo = new MemberVO();
		mVo.setStu_id(stu_id);;
		mVo.setPwd(pwd);
		mVo.setName(name);
		mVo.setEmail(email);
		mVo.setPhone_num(phone_num);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);
		
		response.sendRedirect("login.do");
	}

}
