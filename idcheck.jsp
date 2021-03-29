<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h2>학번 중복확인</h2> <hr>
	<form action="idCheck.do" method="get" name="frm">학번 
	<input type="text" name="stu_id" value="${stu_id}"> 
	<%--중복확인 했을 시 글 안나오는 거 해결 하셈 시발 --%>
	<input type="button" value="중복 확인"> <br>
	
	<c:choose>
	<c:when test="${result == 0}">
		<script type="text/javascript">
			opener.document.frm.stu_id.value = "";
		</script>
		학번은 8자리입니다.
	</c:when>
	
	<c:when test="${result == 1}">
		<script type="text/javascript">
			opener.document.frm.stu_id.value = "";
		</script>
			${stu_id}는 이미 사용중입니다.
	</c:when>
	
	<c:when test="${result == -1}"> 
		${stu_id}는 사용 가능합니다.
	</c:when>	
	</c:choose>
	
	<input type="button" class="btn btn-primary" value="사용" onclick="idok()">
	</form>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>