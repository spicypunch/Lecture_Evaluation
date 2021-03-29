<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--<%@include file="../header.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<h2>로그인</h2> <hr>
	<form action="login.do" method="post" name="frm">
		<table class= "table-bordered">
		
			<tr>
				<td><label class="body">학 &nbsp; 번</label></td>
				<td><input type="text" name="stu_id" value="${stu_id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<input type="submit" class="btn btn-primary btn-sm" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
				<input type="reset" class="btn btn-secondary btn-sm" value="초기화">&nbsp;&nbsp;
				<input type="button" class="btn btn-primary btn-sm" value="첫 화면" onclick="location.href='http://localhost:8181/Lecture_Evaluation/'">

				</td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
			
		</table>
	</form>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>