package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.IdCheckCommand;
import kr.co.member.command.Command;
import kr.co.member.command.DeleteCommand;
import kr.co.member.command.InsertCommand;
import kr.co.member.command.InsertUICommand;
import kr.co.member.command.ListCommand;
import kr.co.member.command.LoginCommand;
import kr.co.member.command.LoginUICommand;
import kr.co.member.command.LogoutCommand;
import kr.co.member.command.ReadCommand;
import kr.co.member.command.UpdateCommand;
import kr.co.member.command.UpdateUICommand;
import kr.co.member.domain.CommandAction;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Command> map = new HashMap<String, Command>();
		map.put("/member/insertui.do", new InsertUICommand());
		map.put("/member/insert.do", new InsertCommand());
		map.put("/member/list.do", new ListCommand());
		map.put("/member/read.do", new ReadCommand());
		map.put("/member/updateui.do", new UpdateUICommand());
		map.put("/member/update.do", new UpdateCommand());
		map.put("/member/delete.do", new DeleteCommand());
		map.put("/member/loginui.do", new LoginUICommand());
		map.put("/member/login.do", new LoginCommand());
		map.put("/member/logout.do", new LogoutCommand());
		map.put("/member/idcheck.do", new IdCheckCommand());

		Command com = map.get(request.getRequestURI().substring(request.getContextPath().length()).toLowerCase());
		if (com != null) {

			CommandAction action = com.execute(request, response);
			if (action.isReDirect())
				response.sendRedirect(action.getWhere());
			else
				request.getRequestDispatcher(action.getWhere()).forward(request, response);

		} else
			request.getRequestDispatcher("/notservice.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
