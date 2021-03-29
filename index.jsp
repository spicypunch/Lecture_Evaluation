<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="mainheader.jsp"%>
<!doctype html>
<html>
<head>
<title>강의평가 웹 사이트</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<a class="navbar-brand" href="index.jsp">강의평가 웹 사이트</a>
	<div>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="./login.do">로그인</a></li>
			<li class="nav-item active"><a class="nav-link" href="./join.do">회원가입</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="./BoardServlet?command=board_list">강의평가</a></li>
			<%-- <li class="nav-item dropdown">
			<a	class="nav-link dropdown-toggle" id="dropdown"
				data-toggle="dropdown"> 회원 관리 </a>

				<div class="dropdown-menu" aria-labelledby="dropdown">

					<a class="dropdown-item" href="./login.do">로그인</a> 
					<a class="dropdown-item" href="#">회원가입</a>
					<a class="dropdown-item" href="#">강의평가</a>

				</div></li>--%>
		</ul>
		<%-- <form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="내용을 입력하세요." aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
		</form>--%>
	</div>
	<script src="./js/jquery-3.5.1.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>