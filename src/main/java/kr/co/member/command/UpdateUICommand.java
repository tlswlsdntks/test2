package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.member.domain.CommandAction;
import kr.co.member.domain.LoginDTO;
import kr.co.member.domain.MemberDTO;
import kr.co.member.persistence.MemberDAO;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession(false) == null)
			return new CommandAction(true, "/member/loginui.do");
		else if (request.getSession(false).getAttribute("login") == null)
			return new CommandAction(true, "/member/loginui.do");
		else if (!((LoginDTO) request.getSession(false).getAttribute("login")).getId()
				.equals(request.getParameter("id")))
			return new CommandAction(true, "/member/loginui.do");

		MemberDTO dto = new MemberDAO().updateui(request.getParameter("id"));
		request.setAttribute("dto", dto);
		return new CommandAction(false, "/member/update.jsp");
	}

}
