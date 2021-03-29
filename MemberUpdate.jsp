<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
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
	<h2>회원 수정</h2>
	<hr>

	<form action="memberUpdate.do" method="post" name="frm">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="number" name="stu_id" size="20"
					value="${user.stu_id}" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="pwdcheck" size="20"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"
					value="${user.name}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"
					value="${user.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone_num" size="20"
					value="${user.phone_num}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="수정"
					onclick="return joinCheck()"> &nbsp;&nbsp;&nbsp;&nbsp; <input
					type="reset" class="btn btn-secondary" value="취소"></td>
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