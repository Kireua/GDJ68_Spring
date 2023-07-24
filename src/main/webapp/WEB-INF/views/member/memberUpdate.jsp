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
	
	<form action="./memberUpdate" method="post">
	
	<div class="mb-3">
	  <label for="pw" class="form-label">PASSWORD</label>
	  <input type="password" name="pw" value="${sessionScope.member.pw}" class="form-control" id="pw" placeholder="PW를 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="name" class="form-label">Name</label>
	  <input type="text" name="name" value="${sessionScope.member.name}" class="form-control" id="name" placeholder="Name을 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="email" class="form-label">Email</label>
	  <input type="email" name="email" value="${sessionScope.member.email}" class="form-control" id="email" placeholder="Email를 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="birth" class="form-label">Birth</label>
	  <input type="date" name="birth" value="${sessionScope.member.birth}" class="form-control" id="birth" placeholder="생년월일을 입력하세요">
	</div>
	
	<div class="mb-3">
		<button class="btn btn-primary">회원수정</button>
	</div>
	
	</form>
	
	
</section>
</body>
</html>