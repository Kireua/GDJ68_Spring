<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 페이지</h1>
	
	<h1>${dto.studNum }</h1>
	<h1>${dto.name }</h1>
	<h1>${dto.korean }</h1>
	<h1>${dto.english }</h1>
	<h1>${dto.math }</h1>
	
	<table class="table-dark">
	  <thead>
	    <tr>
	      <th scope="col" class="table-dark">#</th>
	      <th scope="col" class="table-dark">First</th>
	      <th scope="col" class="table-dark">Last</th>
	      <th scope="col" class="table-dark">Handle</th>
	    </tr>
	  </thead>
	  <tbody class="table-dark">
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Otto</td>
	      <td>@mdo</td>
	    </tr>
	    <tr class="table-dark">
	      <th scope="row">2</th>
	      <td>Jacob</td>
	      <td>Thornton</td>
	      <td>@fat</td>
	    </tr>
	    <tr class="table-dark">
	      <th scope="row">3</th>
	      <td colspan="2">Larry the Bird</td>
	      <td>@twitter</td>
	    </tr>
	  </tbody>
	</table>
	
	<a href="./update?studNum=${dto.studNum}">수정</a>
	<a href="./delete?studNum=${dto.studNum}">삭제</a>
	
</body>
</html>