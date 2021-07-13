<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Would U like coffee?</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>


	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/coffeec">GET COFFEE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		
		<c:choose>
			<c:when test="${empty sessionScope.principal}"> <!-- 세션이 없을떄 -->
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/coffeec/user/loginForm">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/coffeec/user/joinForm">회원가입</a></li>
					<li class="nav-item"><a class="nav-link" href="/coffeec/board/recomend">커피 추천 받기</a></li>
					<li class="nav-item"><a class="nav-link" href="/coffeec/searchCoffee">커피 검색</a></li>
				</ul>
			</c:when>
			<c:otherwise>		<!-- 세션이 있을떄 -->
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/coffeec/user/userForm">마이페이지</a></li>
					<li class="nav-item"><a class="nav-link" href="/coffeec/board/recomend">커피 추천 받기</a></li>
					<li class="nav-item"><a class="nav-link" href="/coffeec/searchCoffee">커피 검색</a></li>
					<li class="nav-item"><a class="nav-link" href="/coffeec/user/logout">로그아웃</a></li>
				</ul>
			</c:otherwise>
		</c:choose>		
		
			
			
		</div>
	</nav>
	<br/>