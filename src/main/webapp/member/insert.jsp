<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 화면</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>회원 가입</h1>

	<form action="/member/insert.do" method="post">
		<label for="id">아이디: </label><input name="id" id="id" required>
		<button type="button" onclick="location.href='/member/idcheck.do'" value="id">아이디 중복확인</button><br>
		<label for="password">비밀번호: </label><input name="password" id="password" type="password"><br>
		<label for="name">이름: </label><input name="name" id="name"><br>
		<label for="birth">생년월일: </label><input name="birth" id="birth" type="date"><br>
		<input type="submit" value="가입">
		<input type="reset" value="초기화">
	</form>
	
	<hr>
	
	<a href="/member/list.do">회원 목록</a><br>
	

</body>
</html>