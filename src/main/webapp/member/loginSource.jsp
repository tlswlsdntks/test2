<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:choose>
	<c:when test="${empty login}">
		<a style="text-decoration: none" href="/member/loginui.do">로그인</a>
	</c:when>

	<c:otherwise>
	${login.name}님, 반갑습니다!
			<a style="text-decoration: none" href="/member/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>
