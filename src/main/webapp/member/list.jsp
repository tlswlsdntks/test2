<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 화면</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
a.readName {
	color: blue;
}
</style>

</head>
<body>

	<h1>회원 목록</h1>
	
	<hr>
	
	<jsp:include page="/member/loginSource.jsp"/>

	<hr>

	<table border="1">
		<thead>
			<tr>
				<th width="100px">ID</th>
				<th width="100px">NAME</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.id}</td>
					<td><a class="readName" href="/member/read.do?id=${dto.id}">${dto.name}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<hr>
	
	<a href="/member/insertui.do">회원 가입</a><br>

</body>
</html>