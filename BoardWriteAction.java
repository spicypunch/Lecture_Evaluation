package com.jm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.dao.BoardDAO;
import com.jm.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO bVo = new BoardVO();
		
		bVo.setTitle(request.getParameter("title"));
		bVo.setName(request.getParameter("name"));
		bVo.setContent(request.getParameter("content"));
		bVo.setScore(Double.parseDouble(request.getParameter("score")));
		bVo.setStu_id(Integer.parseInt(request.getParameter("stu_id")));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		
		new BoardListAction().execute(request, response);
	}
}