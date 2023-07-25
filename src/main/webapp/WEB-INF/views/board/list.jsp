<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
	<h1 class="mb-5 text-center" >공지사항 게시판</h1>
	<!-- 표현식 -->

	<table class="table table-dark table-hover">
		<thead>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="n">
				<tr>
					<td>${n.no}</a></td>
					<td><a class="nav-link active" href="./detail?no=${n.no}">${n.subject} </td>
					<td>${n.name} </td>
					<td>${n.createDate}</td>
					<td>${n.hit} </td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	<a class="btn btn-outline-secondary" href="./add" >공지추가</a>
	</section>
<%-- 	<c:forEach begin="1" step="2" end="10" var="num">
		<h1>${num}</h1>
	</c:forEach> --%>
	
	


</body>
</html>