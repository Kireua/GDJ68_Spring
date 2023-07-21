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
	<h1 class="mb-5 text-center" >Student List</h1>
	<!-- 표현식 -->

	<table class="table table-dark table-hover">
		<thead>
			<th>학생명</th><th>점수</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="i">
				<tr>
					<td><a class="nav-link active" href="./detail?studNum=${d.studNum}">${d.name}</a></td>
					<td>${d.total}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
		<a class="btn btn-outline-secondary" href="./add" >학생등록</a>
	</section>
</body>
</html>