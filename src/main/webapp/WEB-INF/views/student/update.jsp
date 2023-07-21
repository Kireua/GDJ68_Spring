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
	<h1>update</h1>
	<form class="mb-5 text-center form-control" action="./update" method="post">
		<input type="hidden" name="studNum" value="${dto.studNum }">
			<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">학생이름</th>
	      <th scope="col">국어점수</th>
	      <th scope="col">영어점수</th>
	      <th scope="col">수학점수</th>
	    </tr>
	  </thead>
	  <tbody >
	    <tr>
	      <td><input type="text" name="name" value="${dto.name }"></td>
	      <td ><input type="text" name="korean" value="${dto.korean }"></td>
	      <td ><input type="text" name="english" value="${dto.english }"></td>
	      <td ><input type="text" name="math" value="${dto.math }"></td>
	    </tr>
	  </tbody>
	</table>	
		
		<button type="submit">수정</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
	</form>
</body>
</html>