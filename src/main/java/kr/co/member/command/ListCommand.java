package kr.co.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.member.domain.CommandAction;
import kr.co.member.domain.MemberDTO;
import kr.co.member.persistence.MemberDAO;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<MemberDTO> list = new MemberDAO().list();
		request.setAttribute("list", list);
		return new CommandAction(false, "/member/list.jsp");
	}

}
