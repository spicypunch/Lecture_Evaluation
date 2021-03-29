package com.jm.controller;

import com.jm.controller.action.Action;
import com.jm.controller.action.BoardDeleteAction;
import com.jm.controller.action.BoardListAction;
import com.jm.controller.action.BoardUpdateAction;
import com.jm.controller.action.BoardUpdateFormAction;
import com.jm.controller.action.BoardViewAction;
import com.jm.controller.action.BoardWriteAction;
import com.jm.controller.action.BoardWriteFormAction;
import com.jm.controller.action.MyBoardAction;
import com.jm.controller.action.SearchBoard;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println(command);
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if (command.equals("my_board")) {
			action = new MyBoardAction();
		} else if (command.equals("search_board")) {
			action = new SearchBoard();
		}
		return action;
	}
}