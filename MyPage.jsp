<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<h2>마이 페이지</h2> <hr>
	${user.name}님의 정보입니다.
	<form></form>
	<input type="button" class="btn btn-primary" value="회원정보 수정" onclick="location.href='memberUpdate.do?stu_id=${user.stu_id}'">
	<br><br><div id="wrap" align="center"><br>
		<h1>내가 쓴 글</h1>
		<table class="table table-bordered">
			<tr>
				<td colspan="5" style="border: white; text-align: right">
			<%-- 	<a href="BoardServlet?command=board_write_form">게시글 등록</a></td> --%>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>점수</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="list" items="${myList}">
				<tr>
					<td>${list.num}</td>
					<td><a class="nav-link" href="BoardServlet?command=board_view&num=${list.num}">
							${list.title} </a></td>
					<td>${list.name}</td>
					<td>${list.score}</td>
					<td>${list.readcount}</td>
					<td><fmt:formatDate value="${list.writedate }" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>