<%@ page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회</title>
</head>
<body>
	<h1>검색 결과</h1>
	
	<h4> <!-- 검색 결과 있으면 출력하고, 없으면 에러 메세지 띄워라 -->
		<%if(member != null) { %>
			<%=member.getId()%> / <%=member.getName()%> / <%=member.getEmail()%>
		<% } else { %>
			<h3> <%=message %> </h3>
		<% } %>
		
	</h4>
	
	<a href="/edu/index.jsp">첫 화면으로 이동</a>
</body>
</html>