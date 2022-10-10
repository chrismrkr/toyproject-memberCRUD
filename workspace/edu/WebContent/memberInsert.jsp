<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%
	String error = (String)request.getAttribute("error");
	if(error == null) {
		error = "";
	}
%>

<head>
<meta charset="UTF-8">
<title>회원 생성</title>
</head>

<h1>
	<%=error%>
</h1>

<form action="memberInsert.do" method="post">

	id: <input type="text" name="id" placeholder="id를 입력하세요."><br />
	password: <input type="password" name="pwd" placeholder="패스워드를 입력하세요."><br />
	name: <input type="text" name="name" placeholder="이름을 입력하세요."><br />
	email: <input type="text" name="email" placeholder="email를 입력하세요."><br />

	<button type="submit">생성</button>
</form>
<body>

</body>
</html>