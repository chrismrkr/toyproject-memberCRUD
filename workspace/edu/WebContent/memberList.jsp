<%@page import="com.dev.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberVO> memberList = (ArrayList<MemberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<% if(memberList != null) { %>
	<table border="1"></table>
		<tr><th>ID</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr> <br>
		<% for(MemberVO member: memberList) { %>
				<tr>
					<td><%=member.getId() %></td>
					<td><%=member.getPwd() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getEmail() %></td>
				</tr>
				<br>
		<% }  %>
		<br>
	</table> 
	
	<% } else 
	{ %>
		<h3>등록된 회원 정보가 없습니다.</h3>
	<% } %>
	<a href="/edu/index.jsp">첫 화면으로 이동</a>
</body>
</html>