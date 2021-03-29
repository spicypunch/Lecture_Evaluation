<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<table class= "table-bordered" align="right">
		<c:if test="${empty user}">
			<tr>
				<td>현재 로그아웃 상태입니다.</td>
			</tr>
		</c:if>
		<c:if test="${!empty user}">
			<tr>
				<td>${user.name}님접속중 <br> <span> <a class="nav-link"
						href="logout.do">로그아웃</a>
				</span>
				</td>
				<td><a class="nav-link" href="./BoardServlet?command=my_board&name=${user.stu_id}">마이 페이지</a></td>
			</tr>
		</c:if>
	</table>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>