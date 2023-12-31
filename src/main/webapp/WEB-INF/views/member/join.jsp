<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/bootStrap.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

<section class="container mt-5">	
	<h1 class="my-4">회원가입 페이지</h1>
	
	<form action="./join" method="post" enctype="multipart/form-data" id="frm">
	<div class="mb-3">
	  	<label for="id" class="form-label">ID</label>
	  	<input type="text" name="id" class="form-control" id="id"  placeholder="ID를 입력하세요">
		<button type="button" id="btn2" class="btn btn-primary">중복확인</button>
		<div id="idResult"></div>
	</div>
	
	<div class="mb-3">
		<label for="pw" class="form-label">PASSWORD</label>
		<input type="password" name="pw" class="form-control" id="pw"  placeholder="PW를 입력하세요">
		<div id="pwResult"></div>
	</div>

	<div class="mb-3">
		<label for="pw" class="form-label">PASSWORD</label>
		<input type="password" name="pw2" class="form-control" id="pw2" placeholder="PW를 입력하세요">
		<div id="pw2Result"></div>
	</div>	
	
	<div class="mb-3">
	  	<label for="name" class="form-label">Name</label>
	  	<input type="text" name="name" class="form-control" id="name" placeholder="Name을 입력하세요">
	 	<div id="nameResult"></div>
	</div>
	
	<div class="mb-3">
	  	<label for="email" class="form-label">Email</label>
	  	<input type="email" name="email" class="form-control" id="email" placeholder="Email를 입력하세요">
	  	<div id="emailResult"></div>
	</div>
	
	<div class="mb-3">
	  	<label for="birth" class="form-label">Birth</label>
	  	<input type="date" name="birth" class="form-control" id="birth" placeholder="생년월일을 입력하세요">
	  	<div id="birthResult"></div>
	</div>
	
	<div class="mb-3">
	  	<label for="pic" class="form-label">사진첨부</label>
	  	<input type="file" name="pic" class="form-control" id="pic" placeholder="사진 첨부">
	</div>

	
	<div class="mb-3">
		<button type="button" id="btn" class="btn btn-primary">회원가입</button>
	</div>
	
	</form>
	
	<script src="../resources/js/member.js"></script>
	
</section>
</body>
</html>