<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>${vo.mName}님 다시 가입해주세요..</h1>
			<div>
				<button type="button" onclick="location.href='loginForm.do'">로그인</button><br>
				<button type="button" onclick="location.href='memberJoinForm.do'">회원가입</button>
			</div>
		</div>
	</div>
</body>
</html>