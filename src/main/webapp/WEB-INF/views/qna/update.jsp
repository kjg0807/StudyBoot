<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/update.js"></script>
<body>
	<form action="../member/update" method="post" id="frm">
		<br>
		<h1 style="text-align: center;">정보 수정</h1>
		<section class="col-lg-6 container-fluid mt-4">
			<div class="row">
				<%-- <input type="hidden" name="num" id="num" value="${list.num}"> --%>
				<div class="mb-3">
					<label for="formGroupExampleInput2" class="form-label">작성자</label>
					<input type="text" name="writer" class="form-control" value="${list.writer}" disabled>
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput" class="form-label">제목</label>
					<input type="text" class="form-control" name="title" value="${list.title }">
				</div>
				<div class="mb-3">
					<label for="formGroupExampleInput2" class="form-label">글 내용</label>
					<textarea name="contents" id="contents" class="form-control" cols="20" rows="5">${list.contents }</textarea>
				</div>
				<div class="mb-3">
					<c:choose>
						<c:when test="${dto.fileName == null }">
							<c:forEach items="${list.qnaFileVOs }" var="dto">
								<c:if test="${dto.fileNum != null }">
									<img id="img1a" style="width: 350px; height: 300px;" src="/file/qna/${dto.fileName }">
									<button type="button" id="picDel" data-fileNum="${dto.fileNum}" class="btn btn-outline-dark">Delete</button>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<label for="formGroupExampleInput" class="form-label">파일이 존재하지 않음</label>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="mb-3" id="File">
					<div class="mb-3">
						<br>
						<button type="button" id="fileAdd" class="btn btn-outline-dark">File Add</button>
						<button type="button" id="fileDel" class="btn btn-outline-dark" style="display: none;">File
							Delete</button>
						<br>
					</div>
				</div>
				<div>
					<button type="button" id="btn" class="btn btn-outline-dark">정보 수정</button>
					<button type="reset" class="btn btn-outline-dark">초기화</button>
					<a href="./list" class="btn btn-outline-dark">list</a>
					<a href="/" class="btn btn-outline-dark">Home</a>
				</div>
			</div>
		</section>
		<br>
		<br>
	</form>
</body>
</html>