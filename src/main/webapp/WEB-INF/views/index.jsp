<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<body>
	<div style="text-align: center;">
		<h1>Index page</h1>
		<img src="/images/111.jpg" style="width: 50%; height: 50%;" id="id1">
		<br>
		<br> <a href="./qna/list" class="btn btn-outline-dark">QNA</a>
	</div>
</body>
</html>