<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<style>
a:hover {
	color: red;
}

a {
	text-decoration: none;
	color: black;
}
</style>
<body>
	<section class="container-fluid col-lg-10 mt-5" style="text-align: center;">
		<h1 style="text-align: center;">Qna List Page</h1>
		<div>
			<table class="table table-hover">
				<tr>
					<td>Num</td>
					<td>Title</td>
					<td>Writer</td>
					<td>Contents</td>
					<td>Hit</td>
					<td>Date</td>
				</tr>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.num }</td>
						<td>
							<a href="./detail?num=${list.num}">${list.title}</a>
						</td>
						<td>${list.writer }</td>
						<td>${list.contents }</td>
						<td>${list.hit }</td>
						<td>${list.regDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="text-align: center;">
			<a href="./write" class="btn btn-outline-dark">Write Page</a>
			<a href="/" class="btn btn-outline-dark">Home</a>
		</div>
	</section>
	<br>
	<br>
</body>
</html>