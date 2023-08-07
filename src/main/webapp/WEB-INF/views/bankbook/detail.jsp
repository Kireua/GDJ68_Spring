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
	<h1>detail</h1>

	<!-- Getter, Setter 의 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
	<h1>${requestScope.dto.bookName}</h1>
	<h1>${dto.bookRate}</h1>
	
	<c:choose>
		<c:when test="${dto.bookSale eq 1}">
			<h1>판매중</h1>
		</c:when>
		<c:otherwise>
			<h1>판매종료</h1>
		</c:otherwise>
	</c:choose>
	
	<c:forEach items="${dto.bankFileDTOs}" var="f">
		<img alt="" src="../resources/upload/bankBook/${f.fileName }">
	</c:forEach>

	
	<a href="./update?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete?bookNum=${dto.bookNum}">삭제</a>
	<button id="update">수정</button>
	<button id="del" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
	<a class="btn btn-primary" href="../bankAccount/add?bookNum=${dto.bookNum}">상품가입</a>
	<button class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#accountModal">상품가입</button>
	<!-- Modal -->
	<div class="modal fade" id="accountModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호를 입력하세요</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="mb-3">
					<label for="pw" class="form-label"></label>
					<input type="password" name="accountPw" class="form-control" id="pw" placeholder="PW를 입력하세요">
				</div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">취소</button>
			<button type="button" id="add" class="btn btn-primary" data-add-num="${dto.bookNum}">상품가입</button>
			</div>
		</div>
		</div>
	</div>
<%-- 	<c:if test="${dto.bookSale eq 1}">
		<h1> 판매중 </h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0 }">
		<h1> 판매종료</h1>
	</c:if> --%>

	<script src="../resources/js/delete.js"></script>

	<script>
		const add = document.getElementById("add");
		
		add.addEventListener("click", function(){
			let bookNum=add.getAttribute('data-add-num');
			let pw = document.getElementById('pw').value;
			// ajax1(bookNum,pw);
			ajax2(bookNum,pw);


		});

		function ajax2(bookNum, pw){
			fetch("../bankAccount/add",{
				method:"post",
				body:"bookNum="+bookNum+"&accountPw="+pw,
				headers:{
					"Content-type":"application/x-www-form-urlencoded"

				}
			})
			.then((response)=>{
				return response.text();
			})
			//리턴 response.text() 를 닮을 변수 r 
			.then((r)=>{
				if(r>0){
					alert('가입완료');
				}else {
					alert('가입실패');
				}
				location.href="../";
			})

		}

		function ajax1(bookNum, pw){
			//1. xml http 만들어주기
			let xhttp = new XMLHttpRequest();

						//2. 요청정보 open('method','url')
			xhttp.open("POST", "../bankAccount/add");

			//요청 header 정보
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			//요청 발생(post일 경우 파라미터 작성 key=값&key2=값)
			xhttp.send('bookNum='+bookNum+"&accountPw="+pw);

			xhttp.onreadystatechange=function(){
				if(this.readyState==4 && this.status==200){
					let r = this.responseText.trim();
					console.log(r);
					if(r>0){
						alert('가입이 성공되었습니다.');
					}
					else {
						alert('가입 실패');
					}
					document.getElementById('close').click();
					location.href="../";
					console.log(this.responseText);
				}
			}
		}
	</script>

	</body>
</html>