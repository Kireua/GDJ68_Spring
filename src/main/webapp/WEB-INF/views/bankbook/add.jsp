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
	
	<form class="mb-5 text-center form-control" action="./add" method="post" enctype="multipart/form-data">
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">상품명</span><input  type="text" name="bookName"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">상세설명</span><textarea class="input-group" rows="" cols="" name="bookContents"></textarea></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2"> 이자율</span><input  type="text" name="bookRate"></div><br>
		
		<p>
			<div class="input-group text-center me-5"><span class="input-group-text" id="basic-addon2">판매가능</span><input class="ms-4 " type="radio" name="bookSale" checked value="1"></div><br>
			<div class="input-group text-center me-5"><span class="input-group-text" id="basic-addon2">판매가능</span><input class=" ms-4 " type="radio" name="bookSale" value="0"></div><br>
		</p>
		
		
		<p>
	<!-- 	<select name="bookSale">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>
		<div class="mb-3">
			<label for="pic" class="form-label">사진첨부</label>
			<input type="file" name="photos" class="form-control" id="pic" placeholder="사진 첨부">
		</div>
		
		<div class="mb-3">
			<label for="pic" class="form-label">사진첨부</label>
			<input type="file" name="photos" class="form-control" id="pic" placeholder="사진 첨부">
		</div>
		
		<div class="mb-3">
			<label for="pic" class="form-label">사진첨부</label>
			<input type="file" name="photos" class="form-control" id="pic" placeholder="사진 첨부">
		</div>
		
		<button type="submit">등록</button>
		<input type="submit" value="add">
		<input type="reset" value="add">
		<input type="button" value="add">
	</form>


</body>
</html>