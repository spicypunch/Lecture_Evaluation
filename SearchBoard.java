package com.jm.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.dao.BoardDAO;
import com.jm.dto.BoardVO;

public class SearchBoard implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String url = "/board/SearchResult.jsp";
		String option = request.getParameter("option");
		String search = request.getParameter("search");
		System.out.println(option+" "+search);
		BoardDAO bDao = BoardDAO.getInstance();

		List<BoardVO> myList = bDao.searchBoardsbyName(option, search);

		request.setAttribute("myList", myList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
