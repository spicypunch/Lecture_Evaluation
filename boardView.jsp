<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/board.js">
</script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
<form name="frm">
	<div id="wrap" align="center">
		<h1>상세보기</h1>
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${board.content}</pre></td>
			</tr>
			<tr>
				<th>점수</th>
				<td>${board.score}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writedate}" /></td>
				<th>조회수</th>
				<td>${board.readcount}</td>
		</table>
		<br> <br> 
		
		<input type="hidden" name="board" value ="<c:out value="${board.name}"/>">
		<input type="hidden" name="user" value ="<c:out value="${user.name}"/>">
		<input type="hidden" name="num" value ="<c:out value="${board.num}"/>">
		<input type="button" class="btn btn-primary" value="게시글 수정" onclick="writerupdate()">
		<input type="button" class="btn btn-secondary" value="게시글 삭제" onclick="writerdelete()">
		<input type="button" class="btn btn-primary" value="게시글 목록" onclick="location.href='BoardServlet?command=board_list'"> 
		<input type="button" class="btn btn-primary" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write_form'">
	</div>
	</form>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>