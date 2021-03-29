package com.jm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.dao.BoardDAO;
import com.jm.dto.BoardVO;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		
		bVo.setTitle(request.getParameter("title"));
		bVo.setScore(Double.parseDouble(request.getParameter("score")));
		bVo.setContent(request.getParameter("content"));
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		
		System.out.println(request.getParameter("title")+" "+request.getParameter("content")+" "+Double.parseDouble(request.getParameter("score"))+" "+Integer.parseInt(request.getParameter("num")));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		
		new BoardListAction().execute(request, response);
		
	}

}
