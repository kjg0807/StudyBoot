<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<script defer src="/js/test.js"></script>
<body>
	<div style="text-align: center;">
		<h1>Index page</h1>
		<h4>
			<spring:message code="hi" var="h"></spring:message>
			<spring:message code="test" text="code가 없을 때 출력"></spring:message>
		</h4>
		<img src="/images/111.jpg" style="width: 50%; height: 50%;" id="id1">
		<br>
		<br>
		<a href="./qna/list" class="btn btn-outline-dark">QNA List</a>
		<c:choose>
			<c:when test="${member == null }">
				<a href="./member/login" class="btn btn-outline-dark">login</a>
				<a href="./member/join" class="btn btn-outline-dark">Sign Up</a>
			</c:when>
			<c:otherwise>
				<%-- <h3>ID:${member.id } 이름: ${member.name }님안녕하세요!</h3> --%>
				<h3>
					<spring:message code="welName" arguments="${member.name }"></spring:message>
				</h3>
				<h4>
					<spring:message code="welID" arguments="${member.id}, ${member.name }" argumentSeparator=","></spring:message>
				</h4>
				<h4>등급: ${member.roleVO.roleName }</h4>
				<a href="./member/logout" class="btn btn-outline-dark">logout</a>
			</c:otherwise>
		</c:choose>
		<br>
		<br>
		<img src="/file/qna/2f8760fc-7064-41a4-bc3a-c3445f875c2d_aa.JPG" style="width: 50%; height: 50%;">
		<img src="/file/notice/복숭아꽃.jpg" style="width: 50%; height: 50%;">
		<br>
		<br>
		<a href="/fileDown/qna?fileNum=2" class="btn btn-outline-dark">Qna Download</a>
		<a href="/fileDown/notice?fileNum=2" class="btn btn-outline-dark">Notice Download</a>
		<br>
		<br>
	</div>
	<div style="text-align: center;">
		<button id="btn" class="btn btn-outline-dark">Click</button>

		<button id="btn1" class="but btn btn-outline-dark">Btn1</button>
		<button id="btn2" class="but btn btn-outline-dark">Btn2</button>
		<button id="btn3" class="but btn btn-outline-dark">Btn3</button>
	</div>
	<br>
	<h1>${h }</h1>
	<br>
</body>
</html>