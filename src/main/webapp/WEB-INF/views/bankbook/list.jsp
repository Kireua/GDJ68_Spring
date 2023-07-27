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
	<h1 class="mb-5 text-center" >BankBook List</h1>
	<!-- 표현식 -->
	
	<table class="table table-dark table-hover">
		<thead>
			<th>상품명</th><th>이자율</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="i">
				<tr>
					<td><a class="nav-link active" href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
					<td>${d.bookRate} ${i.index}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
		<nav aria-label="...">
		  <ul class="pagination">
		  	<c:if test="${pager.pre}">
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.page-1 }">Previous</a>
		    </li>
		     </c:if>
		   <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
		    <li class="page-item " aria-current="page">
		      <a class="page-link" href="./list?page=${i }">${i}</a>
		    </li>
		   </c:forEach>
		   <c:if test="${pager.next}">
		    <li class="page-item">
		      <a class="page-link"  href="./list?page=${pager.page+1}">Next</a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
		<form action="./list">
			<div class="input-group mb-3">
				<select name="kind" class="form-select" aria-label="Default select example">
					<option value="name">상품명</option>
					<option value="contents">내용</option>
				</select>
				<input type="text" name="keyword" class="form-control" aria-label="Amount (to the nearest dollar)">
				<div class="col-auto">
					<button type="submit" class="btn btn-primary">검색</button>
				</div>
			</div>
		</form>
		<br><br>
	<a class="btn btn-outline-secondary" href="./add" >상품등록</a>
	</section>
<%-- 	<c:forEach begin="1" step="2" end="10" var="num">
		<h1>${num}</h1>
	</c:forEach> --%>
	
	


</body>
</html>