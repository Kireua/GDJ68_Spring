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
	<h1 class="mb-5 text-center">add</h1>
	
	<form class="mb-5 text-center form-control" action="./add" method="post">
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">학생이름</span><input  type="text" name="name"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">국어점수</span><input  type="text" name="korean"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">영어점수</span><input  type="text" name="english"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">수학점수</span><input  type="text" name="math"></div><br>
		
		
		
		<p>
	<!-- 	<select name="bookSale">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>
		
		<button type="submit">등록</button>
		<input type="submit" value="add">
		<input type="reset" value="add">
		<input type="button" value="add">
	</form>


</body>
</html>