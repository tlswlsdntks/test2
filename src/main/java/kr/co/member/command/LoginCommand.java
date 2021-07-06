package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.member.domain.CommandAction;
import kr.co.member.domain.LoginDTO;
import kr.co.member.persistence.MemberDAO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDTO login = new MemberDAO().login(request.getParameter("id"), request.getParameter("password"));
		request.getSession().setAttribute("login", login);

		if (request.getSession(false).getAttribute("login") == null)
			return new CommandAction(false, "/member/loginui.do");

		return new CommandAction(false, "/member/read.do?id=" + request.getParameter("id"));
	}

}
