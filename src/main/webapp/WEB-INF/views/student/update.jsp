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
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">학생이름</span><input type="text" name="name" value="${dto.name }"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">국어점수</span><input type="text" name="korean" value="${dto.korean }"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">영어점수</span><input type="text" name="english" value="${dto.english }"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">수학점수</span><input type="text" name="math" value="${dto.math }"></div><br>
		
		
		
		
		<p>
	<!-- 	<select name="bookSale">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>
		
		<button type="submit">수정</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
	</form>
</body>
</html>