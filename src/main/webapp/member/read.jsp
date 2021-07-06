<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<h1>회원 상세정보</h1>

	<form action="/member/list.do" method="post">
		아이디: <input name="id" value="${dto.id}"><br>
		이름: <input name="name" value="${dto.name}"><br>
		생년월일: <input name="birth" value="${fn:substring(dto.birth,0,10)}"><br>
	</form>
	
	<hr>
	
	<a href="/member/insertui.do">회원 가입</a><br>
	<a href="/member/list.do">회원 목록</a><br>
	<a href="/member/updateui.do?id=${dto.id}">회원 수정</a><br>
	<a href="/member/delete.do?id=${dto.id}">회원 삭제</a><br>

</body>
</html>