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
			<h1>회원가입 완료!</h1>
			<h1>${vo.mName}님 ${vo.mId}로 회원가입이 성공했습니다</h1>
			<div>
				<button type="button" onclick="location.href='loginForm.do'">로그인</button>
			</div>
		</div>
	</div>
</body>
</html>