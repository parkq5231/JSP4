package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;

public class Logout implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO
		HttpSession session = request.getSession();
//		String mid = (String) session.getAttribute("mid");
//		request.setAttribute("mid", mid);
		session.invalidate(); // session자체를 깨버리는 것
//		return "views/member/logout.jsp"; 
		return "main.do";	// 처음 main페이지 보여준다는 의미
	}

}
