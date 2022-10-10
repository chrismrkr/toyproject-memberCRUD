<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 검색</title>
</head>
<body>
	<h1>ID를 입력해주세요.</h1>



	<form action="memberSearch.do" method="post">
		ID: <input type="text" name="id" placeholder="ID를 입력해주세요" />
		<input type="hidden" name="job" value="search"/>
		<button type="submit">검색</button>
	</form>
</body>
</html>