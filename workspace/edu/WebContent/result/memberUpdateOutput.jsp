<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 결과</title>
</head>
<body>
	<h1>
		<%=id %>님, 회원 수정이 완료되었습니다.
	</h1>
	로그인 완료되었습니다.
	<a href="/edu/index.jsp"> 첫 화면으로 이동</a>
</body>
</html>