package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsConfigurator;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class Login implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 과정을 처리한다.
		MemberDao dao = new MemberDao(); //
		MemberVo vo = new MemberVo(); // 한개의 record도 찾아와야 하기 때문에 필요함
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));

		vo = dao.select(vo);// 로그인 채크하기 dao 호출 //DB에 보내서 일치하는지 확인

		String viewPage = null;

		if (vo.getmAuth() != null) {
			//세션 호출 후 이용방법?
			HttpSession session = request.getSession(); // 세션객체 호출
			session.setAttribute("mid", vo.getmId()); // 세션에 아이디 담음
			session.setAttribute("mauth", vo.getmAuth());// 세션에 권한을 담음
			request.setAttribute("vo", vo);
			viewPage = "views/member/loginSuccess.jsp";
		} else {
			viewPage = "views/member/loginFail.jsp";
		}
		return viewPage;
	}
}
