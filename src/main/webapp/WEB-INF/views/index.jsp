<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

	<div class="container">
	
		<div class="card m-2" style="width: 50%" align="center">
			<h3 class="card-title">오늘의 커피</h3>
			<img class="card-img-top" src="coffeeImg/1.jpg" alt="Card image">
			<div class="card-body">
				<h4 class="card-title">스타벅스 아이스 카페라떼</h4>
				<a href="/coffees/1" class="btn btn-primary">상세 보기</a>
			</div>
	
		</div>
	
		<div>
			<a href="/recomend" class="btn btn-primary">커피 추천 받기</a>
		</div>
		
	
	</div>



<%@ include file="layout/footer.jsp"%>
