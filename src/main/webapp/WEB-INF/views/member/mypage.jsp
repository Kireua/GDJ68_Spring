<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/bootStrap.jsp"></c:import>
<title>마이페이지</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<section class="container mt-5">	
	<h1 class="my-4">마이 페이지</h1>
		<p>
			<img alt="" class="d-block w-20"  src="../resources/upload/member/${member.memberFileDTO.fileName }">
		</p>
	<form action="./mypage" method="post">
	
	<div class="mb-3">
	  <label for="id" class="form-label">ID</label>
	  <input type="text" name="id" class="form-control" id="id"  value="${sessionScope.member.id }">
	</div>
	
	<div class="mb-3">
	  <label for="name" class="form-label">Name</label>
	  <input type="text" name="name" class="form-control" id="name" value="${sessionScope.member.name }">
	</div>
	
	<div class="mb-3">
	  <label for="name" class="form-label">birth</label>
	  <input type="text" name="name" class="form-control" id="birth" value="${sessionScope.member.birth }">
	</div>
	</form>
	
	<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	
	<div id="productList">

	</div>
	</section>
	<script>
		const productList = document.getElementById('productList');
		
		getList(1);

		productList.addEventListener('click',function(event){
			if(event.target.classList.contains('move')){
				let page = event.target.getAttribute('data-num');
				console.log('before');
				getList(page);
				console.log('after');
			}
		})

		function getList(page){
			
			fetch("../bankAccount/list?page="+page,{
				method:"get"
			})
			.then((response)=>{return response.text()})
			.then((r)=>{
				console.log('ajax실행중')
				productList.innerHTML=r;
				console.log(r);
			});
		}

	</script>
</body>
</html>