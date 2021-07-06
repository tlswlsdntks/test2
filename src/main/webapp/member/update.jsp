<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<h1>회원정보 수정 화면</h1>

	<form action="/member/update.do" method="post">
		아이디: <input name="id" value="${dto.id}" readonly><br>
		비밀번호: <input name="password" type="password" value="${dto.password}"><br>
		이름: <input name="name" value="${dto.name}"><br>
		생년월일: <input name="birth" type="date" value="${dto.birth}"><br>
		<input type="submit" value="수정">
		<input type="reset" value="초기화">
	</form>
	
	<br>
	
	<a href="/member/list.do">회원 목록</a><br>

</body>
</html>