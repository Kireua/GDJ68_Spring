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
	<br><br>
	<h1>상세 페이지</h1>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col" >학생번호</th>
	      <th scope="col" >학생이름</th>
	      <th scope="col">국어점수</th>
	      <th scope="col">영어점수</th>
	      <th scope="col">수학점수</th>
	      <th scope="col">총점</th>
	      <th scope="col">평균</th>
	    </tr>
	  </thead>
	  <tbody >
	    <tr>
	      <th >${dto.studNum }</th>
	      <td>${dto.name }</td>
	      <td >${dto.korean }</td>
	      <td >${dto.english }</td>
	      <td >${dto.math }</td>
	      <td >${dto.total }</td>
	      <td >${dto.average }</td>
	    </tr>
	  </tbody>
	</table>
	
	<a href="./update?studNum=${dto.studNum}">수정</a>
	<a href="./delete?studNum=${dto.studNum}">삭제</a>
	
</body>
</html>