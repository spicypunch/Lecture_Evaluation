<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/board.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>강의평가 등록</h1>
		<form name="frm" action="BoardServlet" method="post">
			<input type="hidden" name="command" value="board_write">
			<table class="table table-bordered">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" value="${user.name}" readonly></td>
				</tr>
				<tr>
					<th>학번</th>
					<td><input type="text" name="stu_id" value="${user.stu_id}" readonly></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
				<tr>
					<th>점수</th>
					<td><select name="score">
							<option value="0.5">0.5</option>
							<option value="1.0">1.0</option>
							<option value="1.5">1.5</option>
							<option value="2.0">2.0</option>
							<option value="2.5">2.5</option>
							<option value="3.0">3.0</option>
							<option value="3.5">3.5</option>
							<option value="4.0">4.0</option>
							<option value="4.5">4.5</option>
							<option value="5.0">5.0</option>
					</select></td>
				</tr>
			</table>
			<br> <input type="submit" class="btn btn-primary" value="등록" onclick="return boardCheck()">
			<input type="reset"	class="btn btn-primary" value="다시 작성"> <input type="button" class="btn btn-primary" value="게시글 목록"
				onclick="location.href='BoardServlet?command=board_list'">
		</form>
	</div>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>