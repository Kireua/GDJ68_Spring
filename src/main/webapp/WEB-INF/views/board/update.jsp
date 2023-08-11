<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/bootStrap.jsp"></c:import>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<h1>update</h1>
	<form class="mb-5 text-center form-control" action="./update" method="post" enctype="multipart/form-data">
		<table class="table table-dark table-hover">
		<thead>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			
		</thead>
		<tbody>
				<tr>
					<td><input type="hidden" name="num" value="${dto.num }">${dto.num}</td>
					<td><input type="text" name="subject" value="${dto.subject}"></td>
					<td>${dto.name}</td>
					<td><input type="text" name="createDate" value="${dto.createDate}"></td>
					
				</tr>
		</tbody>
		</table>
		<table class="table table-dark table-hover">
			<thead>
				<th>내용</th>
			</thead>
			<tbody>
				<td><textarea rows="" cols="" name="contents" id="contents">${dto.contents}</textarea></td>
			</tbody>
		</table>
		<div id="fileList" class="mb-3">
		<div class="mb-3">
			<button id="fileBtn" type="button">File추가</button>
		</div>
		</div>
		<div>
		<c:forEach items="${dto.noticeFileDTOs}" var="f">
			<div class="alert alert-danger" role="alert">
				${f.originalName}
			</div>
			<span class="deletes" data-delete-num="${f.fileNum}">X</span>
		</c:forEach>
		</div>
		<button type="submit">수정</button>

	</form>

	<script src="../resources/js/file.js"></script>
	<script>
		
		$("#contents").summernote({
			height: 300
		});

	</script>
</body>
</html>