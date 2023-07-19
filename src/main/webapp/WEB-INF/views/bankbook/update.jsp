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
		<input type="hidden" name="bookNum" value="${dto.bookNum }">
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">상품명</span><input type="text" name="bookName" value="${dto.bookName }"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">내용</span><textarea rows="" cols="" name="bookContents">${dto.bookContents}</textarea></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2"> 이자율</span><input type="text" name="bookRate" value="${dto.bookRate }"></div><br>
		
		<p  class="form-check">
			<div class="input-group text-center me-5"><span class="input-group-text" id="basic-addon2">판매가능</span><input class=" ms-4" type="radio" name="bookSale" checked value="1"></div><br>
			<div class="input-group text-center me-5"><span class="input-group-text" id="basic-addon2">판매중지</span><input class=" ms-4" type="radio" name="bookSale" value="0"></div><br>
		</p>
		
		
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