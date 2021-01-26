package co.micol.minipro.common;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public String run(HttpServletRequest request, HttpServletResponse response) throws SQLException;
	//전달인자로 받음
	//throws 예외처리
}
