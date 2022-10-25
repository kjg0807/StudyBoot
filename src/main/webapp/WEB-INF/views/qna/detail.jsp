<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>

<body>
	<section class="container-fluid col-lg-10 mt-5"
		style="text-align: center;">
		<h1 style="text-align: center;">Qna Detail Page</h1>
		<div>
			<table class="table table-hover">
				<tr>
					<td>Num</td>
					<td>Title</td>
					<td>Writer</td>
					<td>Contents</td>
					<td>Hit</td>
					<td>Date</td>
					<td>Picture</td>
					<td>Picture Link</td>
				</tr>
				<tr>
					<td>${detail.num }</td>
					<td>${detail.title }</td>
					<td>${detail.writer }</td>
					<td>${detail.contents }</td>
					<td>${detail.hit }</td>
					<td>${detail.regDate }</td>
					<c:forEach items="${detail.qnaFileVOs }" var="dto">
						<td>
							<img style="width: 250px; height: 200px;"
								src="/file/qna/${dto.fileName }">
							<%-- src="/file/qna/${dto.fileName }" --%>
						</td>
						<td>
							<a class="btn btn-outline-dark" href="/fileDown/qna?fileNum=${dto.fileNum }">Picture Download</a>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
		<div style="text-align: center;">
			<a href="/" class="btn btn-outline-dark">Home</a> <a href="./list"
				class="btn btn-outline-dark">List Page</a>
		</div>
	</section>
</body>
</html>