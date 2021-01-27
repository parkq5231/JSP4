package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberJoin implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입시 DB에 저장 메소드
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmName(request.getParameter("mName"));

		int n = dao.insert(vo);//위의 vo값을 매개변수로 넘겨주는거
		String viewPage = null;
		request.setAttribute("vo", vo);

		if (n != 0) {
			viewPage = "views/member/memberJoinSuccess.jsp";
		} else {
			viewPage = "views/member/memberJoinFail.jsp";
		}
		return viewPage;
	}

}
