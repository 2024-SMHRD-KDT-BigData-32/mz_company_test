<%@page import="com.smhrd.entity.Board"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="resources/assetsBoard/css/main.css" />
		<link rel="stylesheet" href="resources/assetsBoard/css/board.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
</head>
<body>		
			<!-- Q17. 게시글 목록 조회 기능 -->
			<!-- Q18. 게시글 목록 세부페이지 기능(제목을 클릭하면 세부페이지 BoardDetail.jsp로 이동)-->
			
			<%List<Board> list = (List<Board>)request.getAttribute("list"); %>
			<div id="board">
				<table id = "list">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>시간</td>
					</tr>
					<%-- <%for(Board bd : list){ %>
						<tr>
							<td><%=bd.getIdx() %></td>						
							<td><%=bd.getTitle() %></td>						
							<td><%=bd.getWriter() %></td>						
							<td><%=bd.getB_date() %></td>						
						</tr>
					<%} %> --%>
					<c:forEach items="${list }" var='bd' varStatus="s">
						<tr>
							<td>${s.count }</td>
							<td><a href="boardContent?idx=${bd.idx }">${bd.title }</a></td>
							<td>${bd.writer }</td>
							<td>${bd.b_date }</td>
							
							<c:if test="${loginMember.email eq 'admin' }">
								<td><a href="deleteBoard?idx=${bd.idx }">삭제</a></td>
							</c:if>
							
						</tr>
					</c:forEach>
				</table>
				
				<a href="goMain"><button id="writer">홈으로가기</button></a>
				<a href="goBoardWrite"><button id="writer">작성하러가기</button></a>
			</div>


			<!-- Scripts -->
			<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="resources/assets/js/skel.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="resources/assets/js/main.js"></script>
</body>
</html>