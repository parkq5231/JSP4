package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberIdCheck implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 아이디 중복 체크
		MemberDao dao = new MemberDao();
		String id = request.getParameter("mid");
		boolean bool = dao.isidCheck(id);
		// 아이디가 존재할 때 true이니 비교할 조건문 작성
		String message = null;
		if (bool) {
			message = id + "사용 가능한 아이디입니다.";
		} else {
			message = id + "중복된 아이디입니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		//request.set이니까 msg를 return에 실어서 보낸다고 생각
		return "views/member/idCheck.jsp";
	}

}
