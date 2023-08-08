<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/bootStrap.jsp"></c:import>
<title>상품가입</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	
	<section class="container mt-5">	
	<h1 class="my-4">상품댓글 페이지</h1>
	
	<form action="./add" id="frm" method="post">	
	<input type="hidden" name="bookNum" value="${dto.bookNum }">
	<input type="hidden" name="id" value="${member.id }">
	
	<div class="input-group text-center">
	<span class="input-group-text" id="basic-addon2">상세설명</span>
	<textarea class="input-group" rows="" cols="" name="comments"></textarea>
	</div><br>
	
	
	<div class="mb-3">
		<button type="button" id="btn" class="btn btn-primary">댓글추가</button>
	</div>
	
	</form>

</section>
	<script type="text/javascript">
		const btn = document.getElementById("btn");
		const comments = document.getElementById("comments");
		
		btn.addEventListener("click",function () {
			
			frm.submit();
			
		})
	</script>
</body>
</html>