<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




	<section class="container mt-5">
	
	<h1 class="mb-5 text-center" >상품 댓글 목록</h1>
	
	<!-- 표현식 -->

	<table class="table table-dark table-hover">
		<thead>
			<th>작성자</th>
			<th>작성일</th>
			<th>댓글내용</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="n">
				<tr>
					<td>${n.id}</a></td>
					<td>${n.createDate} </td>
					<td>${n.comments}</td>
				</tr>
			</c:forEach>
			
		</tbody>
		
	</table>
		<nav aria-label="...">
		  <ul class="pagination">
		  <c:if test="${pager.pre}">
		    <li class="page-item ">
		      <a class="page-link move" href="#" data-num="${pager.page-1}" aria-label="Previous"></a>
		    <span aria-hidden="true">&laquo;</span>
		    </li>
			</c:if>
		   <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
		    <li class="page-item"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
		   </c:forEach>
		   
		    <li class="page-item  ${pager.next?'':'disabled' }">
		    	<a class="page-link move" href="#" data-num="${pager.page+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
		    </li>
		 
		  </ul>
		</nav>
		

	</section>
<%-- 	<c:forEach begin="1" step="2" end="10" var="num">
		<h1>${num}</h1>
	</c:forEach> --%>
	
	
	<script src="/resources/js/list.js"></script>

</body>
