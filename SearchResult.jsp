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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>강의평가 목록</h1>
		<form method="post" action ="BoardServlet?command=search_board" name = "frm">
		<table class="table table-bordered">
				<fieldset>
					<legend></legend>
					<label>분류</label> 
					<select name="option">
						<option value="title">제목</option>
						<option value="content">제목+내용</option>
						<option value="writerId">작성자</option>
					</select> 
					<label>검색어</label> 
						<input type="text" name="search" value=""/> 
						<input type="submit" value="검색" class="btn btn-primary btn-sm">
				</fieldset>
			</form>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>점수</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="mylist" items="${myList}">
				<tr>
					<td>${mylist.num}</td>
					<td><a class="nav-link"
						href="BoardServlet?command=board_view&num=${mylist.num}">
							${mylist.title} </a></td>
					<td>${mylist.name}</td>
					<td>${mylist.score}</td>
					<td>${mylist.readcount}</td>
					<td><fmt:formatDate value="${mylist.writedate }" /></td>
				</tr>
			</c:forEach>
		</table>
		</form>
		<input type="button" class="btn btn-primary" value="게시글 등록"
			onclick="location.href = 'BoardServlet?command=board_write_form'">
			<input type="button" class="btn btn-primary" value="전체 게시글 보기"
			onclick="location.href = 'BoardServlet?command=board_list'">
	</div>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>