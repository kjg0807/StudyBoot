<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Qna List Page</h1>
	<table>
		<tr>
			<td>Num</td>
			<td>Title</td>
			<td>Writer</td>
			<td>Contents</td>
			<td>Hit</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.num }</td>
				<td>${list.title }</td>
				<td>${list.writer }</td>
				<td>${list.contents }</td>
				<td>${list.hit }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>