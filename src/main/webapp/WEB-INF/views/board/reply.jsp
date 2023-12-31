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
	<h1 class="mb-5 text-center">${board } Reply Page</h1>
	
	<form class="mb-5 text-center form-control" action="./reply" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${num }">
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">제목</span><input  type="text" name="subject"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">내용</span><textarea class="input-group" rows="" cols="" name="contents"></textarea></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">작성자</span><input  type="text" name="name"  value="${member.id }"></div><br>
		
		
		
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