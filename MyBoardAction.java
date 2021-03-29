package com.jm.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.dao.BoardDAO;
import com.jm.dto.BoardVO;

public class MyBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/board/MyPage.jsp";

		String name = request.getParameter("name");
		System.out.println(name);
		BoardDAO bDao = BoardDAO.getInstance();

		List<BoardVO> myList = bDao.selectMyBoards(name);
		
		request.setAttribute("myList", myList);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
