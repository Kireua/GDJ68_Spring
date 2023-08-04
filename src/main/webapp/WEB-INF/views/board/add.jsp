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
	<h1 class="mb-5 text-center">${board } 추가</h1>
	
	<form class="mb-5 text-center form-control" action="./add" method="post" id="frm" enctype="multipart/form-data">
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">제목</span><input id="subject" type="text" name="subject"></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">내용</span><textarea class="input-group" rows="" cols="" name="contents"></textarea></div><br>
		<div class="input-group text-center"><span class="input-group-text" id="basic-addon2">작성자</span><input  type="text" name="name"  value="${member.id }"></div><br>
		
		
		<div id="fileList" class="mb-3"></div>
		<div class="mb-3">
			<button id="fileBtn" type="button">File추가</button>
		</div>
		
		
		<button id="btn" type="button">등록</button>

	</form>

	<script src="../resources/js/file.js"></script>
	<script>
		const btn = document.getElementById("btn");
		const subject = document.getElementById("subject");
		const frm = document.getElementById("frm");

		btn.addEventListener("click", function(){
			console.log(subject.value=="");
			console.log(subject.value.length == 0);
			if(subject.value==""){
				alert('제목은 필수 입니다.');
				subject.focus();
			}else {
				frm.submit();
			}
		});

	</script>

</body>
</html>