<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
		<nav class="navbar bg-dark navbar-expand-lg border-bottom border-bottom-dark"  data-bs-theme="dark">
				 <div class="container-fluid">
		    <a class="navbar-brand" href="#">Navbar</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active"  href="/bankbook/list">금융상품</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Dropdown
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="#">Action</a></li>
		            <li><a class="dropdown-item" href="#">Another action</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item" href="#">Something else here</a></li>
		          </ul>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link disabled">Disabled</a>
		        </li>
		      </ul>
		      <nav>
		      	<c:if test="${not empty sessionScope.member}">
			      	<ul class="navbar-nav me-auto mb-2 mb-lg-0" >
				      	<li class="nav-item me-3 text-white"><a class="nav-link active" aria-current="page" href="/member/logout">로그아웃</a></li>
				      	<li class="nav-item me-3 text-white"><a class="nav-link active" aria-current="page" href="/member/mypage">마이페이지</a></li>
			      	</ul>
			     </c:if>
			     	<c:if test="${empty sessionScope.member}">
			      	<ul class="navbar-nav me-auto mb-2 mb-lg-0" >
				      	<li class="nav-item me-3 text-white"><a class="nav-link active" aria-current="page" href="/member/login">로그인</a></li>
				      	<li class="nav-item me-3 text-white"><a class="nav-link active" aria-current="page" href="/member/join">회원가입</a></li>
			      	</ul>
			     </c:if>
		      </nav>
		      <!-- <form class="d-flex" role="search">
		        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Search</button>
		      </form> -->
		    </div>
		  </div>
	</header>