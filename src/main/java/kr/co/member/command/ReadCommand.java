package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.member.domain.CommandAction;
import kr.co.member.domain.MemberDTO;
import kr.co.member.persistence.MemberDAO;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDTO dto = new MemberDAO().read(request.getParameter("id"));
		request.setAttribute("dto", dto);
		return new CommandAction(false, "/member/read.jsp");
	}

}
