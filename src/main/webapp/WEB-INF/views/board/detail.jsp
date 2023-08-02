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
	
	<table class="table table-dark table-hover">
		<thead>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</thead>
		<tbody>
				<tr>
					<td>${dto.num}</a></td>
					<td>${dto.subject}</td>
					<td>${dto.name}</td>
					<td>${dto.createDate}</td>
					<td>${dto.hit} </td>
				</tr>
		</tbody>
		</table>
	
	<c:if test="${board eq '공지' }">
		<c:forEach items="${dto.noticeFileDTOs}" var="f">
			<img alt="" src="../resources/upload/notice/${f.fileName }">
		</c:forEach>
	</c:if> 
	<c:if test="${board eq 'Q&A' }">
		<c:forEach items="${dto.qnAFileDTOs}" var="f">
			<img alt="" src="../resources/upload/qna/${f.fileName }">
		</c:forEach>
	</c:if> 
	<a href="./update?num=${dto.num}">수정</a>
	<a href="./delete?num=${dto.num}">삭제</a>
	<button id="del" class="btn btn-outline-primary" data-delete-name="num" data-delete-num="${dto.num}">삭제</button>
	<c:if test="${board ne '공지' }">
	<a href="./reply?num=${dto.num}">답글달기</a>
	</c:if>
<%-- 	<c:if test="${dto.bookSale eq 1}">
		<h1> 판매중 </h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0 }">
		<h1> 판매종료</h1>
	</c:if> --%>

	<script src="../resources/js/delete.js"></script>
</body>
</html>