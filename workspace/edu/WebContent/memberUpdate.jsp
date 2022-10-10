<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	String error = "";
	if(request.getAttribute("message") != null) {
		error = (String)request.getAttribute("message");
	}
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<h2>수정 정보 검색</h2>
	<form action="memberSearch.do" method="post">
		ID: <input type="text" name="id" placeholder="ID를 입력해주세요"/>
		<input type="hidden" name="job" value="update"/>
	<button type="submit">검색</button>
	</form>
	
	<% if(member != null) { %>
		<h2> 회원 정보 수정 </h2>
		<form action = "memberUpdate.do" method="post">
			ID: <input type="text" name="id" value = <%=member.getId()%> /> <br>
			PWD: <input type="password" name="pwd" value = <%=member.getPwd() %> /> <br>
			NAME: <input type="text" name="name" value = <%=member.getName() %> /> <br>
			EMAIL: <input type="text" name="email" value = <%=member.getEmail() %> /> <br>
			<button type="submit">수정</button>
		</form>
		
	<% } else { %>
		<h3> <%= error %> </h3>
	<% } %>
	
</body>

	
</html>