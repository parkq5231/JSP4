<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<script type="text/javascript">
function formCheck(){

	if(frm.mPassword.value != frm.mPassword1.value){
		alert("패스워드가 다릅니다.");
		frm.mPassword.value = null;
		frm.mPassword1.value = null;
		frm.mPassword.focus();
		return false;
	}
	return true;
}
function idCheck(str){
	var url= "idCheck.do?mid="+str;
	var name="아이디 중복 체크";
	var option="width=400,height=150,top=100 left=100";
	if(str==""){
		alert("아이디를 입력해주세요.");
		frm.mId.focus();	
	}else{
	window.open(url,name,option);		
	}
}

</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
		<!-- onsubmit의 return은 괜히 들어간게 아님 function실행 후 그 결과를 return 해서 action을 할지 안할지 정하는거 -->
		<form id="frm" name="frm" onsubmit="return formCheck()" action = "memberJoin.do" method="post">
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="350"><input type="text" id='mId' name='mId' size='30' required="required">
						<button type="button" onclick="idCheck(mId.value)" >중복체크</button></td>
				</tr>
				<tr>
					<th width="100">패스워드</th>
					<td width="350">
					<input type="password" id="mPassword" name="mPassword" size="30" required="required"></td>
				</tr>
				<tr>
					<th width="100">패스워드확인</th>
					<td width="350">
					<input type="password" id="mPassword1" name="mPassword1"size="30" required="required"></td>
				</tr>
				<tr>
					<th width="100">이 름</th>
					<td width="350">
					<input type="text" id="mName" name="mName" size="30" required="required"></td>
				</tr>
			</table>
			<br>
		<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소">
		</form>
		</div>
	</div>
</body>
</html>