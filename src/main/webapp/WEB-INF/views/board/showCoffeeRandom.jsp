<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<%@ include file="../layout/header.jsp"%>
<body>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>설명</th>
				<th>사진</th>
				<th>좋아요</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.explain}</td>
					<td>${list.img}</td>
					<td>${list.likes}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>


<%@ include file="../layout/footer.jsp"%>
</html>