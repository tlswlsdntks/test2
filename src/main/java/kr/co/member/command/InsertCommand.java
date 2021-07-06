package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.member.domain.CommandAction;
import kr.co.member.domain.MemberDTO;
import kr.co.member.persistence.MemberDAO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		new MemberDAO().insert(new MemberDTO(request.getParameter("id"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("birth")));

		return new CommandAction(true, "/member/list.do");

	}

}
