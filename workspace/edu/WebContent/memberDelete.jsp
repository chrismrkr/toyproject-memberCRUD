<%@page import="com.dev.vo.MemberVO"%>
<%@page import="com.dev.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	String message = (String)request.getAttribute("message");
%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
</head>
<body>
	<h1>삭제 정보 검색</h1>
	<form action="memberSearch.do" method="post">
		ID: <input type="text" name="id" placeholder="ID를 입력해주세요."/> <br>
		<input type="hidden" name="job" value="delete"/> <br>
		<button type="submit">검색</button>
	</form> 
	
	<% if(message != null) {%>
		<%=message%>
	<% } %>
	
	<% if(member != null) { %>
		<h1>검색 정보 결과</h1>
		<%=member.getId()%> / <%=member.getPwd()%> / <%=member.getName()%> / <%=member.getEmail() %>
		<form action = "memberDelete.do" method="post">
			<input type="hidden" name="id" value= <%=member.getId()%> > <br>
			<button type="submit">삭제</button>
		</form> 
	<% } %>
	

</body>
</html>