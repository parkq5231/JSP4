package co.micol.minipro;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Service> map = new HashMap<String,Service>();
	//String 요청명,	Service = 실행할 Command
	//요청에 따른 명령 K,V로 표현한 것		ex) /list.do ->new Action() 실행은 init에서 하는 듯
	
	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainService());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();	//최상위 경로
		String uri =request.getRequestURI();
		String path = uri.substring(contextPath.length());		//실제 요청한 경로 확인	//uri에서 contextPath뺀다는 의미임
		
		Service service = map.get(path);
		String viewPage = service.run(request, response);
				
	}

}
