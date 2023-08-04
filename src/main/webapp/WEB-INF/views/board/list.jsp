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
	<section class="container mt-5">
	
	<h1 class="mb-5 text-center" >${board } List</h1>
	
	<!-- 표현식 -->

	<table class="table table-dark table-hover">
		<thead>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="n">
				<tr>
					
					<td>${n.num}</a></td>
					
					<td><a class="nav-link active" href="./detail?num=${n.num}"><c:catch>
					<c:forEach begin="1" end="${n.depth }">--</c:forEach>
					</c:catch>${n.subject} </td>
					<td>${n.name} </td>
					<td>${n.createDate}</td>
					<td>${n.hit} </td>
				</tr>
			</c:forEach>
			
		</tbody>
		
	</table>
	<nav aria-label="...">
		  <ul class="pagination">
		  <c:if test="${pager.pre}">
		    <li class="page-item ">
		      <a class="page-link move" href="#" data-num="${pager.startNum-1}" aria-label="Previous"></a>
		    <span aria-hidden="true">&laquo;</span>
		    </li>
			</c:if>
		   <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
		    <li class="page-item"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
		   </c:forEach>
		   
		    <li class="page-item  ${pager.next?'':'disabled' }">
		      <a class="page-link move" href="#" data-num="${pager.lastNum+1}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span></a>
		    </li>
		 
		  </ul>
		</nav>
		 <form action="./list" method="get" id="frm">
		 <input type="hidden" value="${pager.page}" id="page" name="page">
			<div class="input-group mb-3">
				<select name="kind"  id="k"  class="form-select" data-kind="${pager.kind}" aria-label="Default select example">
					<option class="kind" value="name">작성자</option>
					<option class="kind" value="contents">내용</option>
					<option class="kind" value="subject">Subject</option>
				</select>
				<input type="text" name="keyword" value="${pager.keyword }" class="form-control" aria-label="Amount (to the nearest dollar)">
				<div class="col-auto">
					<button type="submit" class="btn btn-primary">검색</button>
				</div>
			</div>
		</form>
		
		<br><br>
	<a class="btn btn-outline-secondary" href="./add" >공지추가</a>
	</section>
<%-- 	<c:forEach begin="1" step="2" end="10" var="num">
		<h1>${num}</h1>
	</c:forEach> --%>
	
	
	<script src="/resources/js/list.js"></script>

</body>
</html>