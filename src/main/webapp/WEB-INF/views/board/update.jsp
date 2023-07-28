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
	<h1>update</h1>
	<form class="mb-5 text-center form-control" action="./update" method="post">
		<table class="table table-dark table-hover">
		<thead>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>내용</th>
		</thead>
		<tbody>
				<tr>
					<td><input type="hidden" name="noticeNum" value="${dto.noticeNum }">${dto.noticeNum}</td>
					<td><input type="text" name="subject" value="${dto.subject}"></td>
					<td>${dto.name}</td>
					<td><input type="text" name="createDate" value="${dto.createDate}"></td>
					<td><textarea rows="" cols="" name="contents">${dto.contents}</textarea></td>
				</tr>
		</tbody>
		</table>
		
		<button type="submit">수정</button>

	</form>
</body>
</html>