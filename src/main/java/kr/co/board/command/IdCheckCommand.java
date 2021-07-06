package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.member.command.Command;
import kr.co.member.domain.CommandAction;
import kr.co.member.domain.MemberDTO;
import kr.co.member.persistence.MemberDAO;

public class IdCheckCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDTO dto = new MemberDAO().idCheck(request.getParameter("id"));
		
		// System.out.println(request.getParameter("id"));
		
		request.setAttribute("dto", dto);
		return new CommandAction(false, "/member/idcheck.jsp");
	}

}
