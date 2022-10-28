<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
</head>
<script defer src="/js/write.js"></script>
<body>
	<section class="container-fluid col-lg-6 mt-5">
		<h1>Qna Write Page</h1>
		<form action="./write" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">작성자</label>
				<input type="text" name="writer" class="form-control" placeholder="작성자를 입력하세요.">
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">제목</label>
				<input type="text" class="form-control" name="title" placeholder="제목을 입력하세요.">
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">글 내용</label>
				<textarea name="contents" id="contents" class="form-control" placeholder="내용을 입력하세요."></textarea>
			</div>

			<div class="mb-3" id="File">
				<div class="mb-3">
					<button type="button" id="fileAdd" class="btn btn-outline-dark">File Add</button>
					<button type="button" id="fileDel" class="btn btn-outline-dark" style="display: none;">File
						Delete</button>
					<br>
				</div>
			</div>

			<!-- <div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">파일1</label>
				<input type="file" class="form-control" name="files" id="files">
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">파일2</label>
				<input type="file" class="form-control" name="files" id="files1">
			</div> -->
			<div style="text-align: center;">
				<button type="submit" class="btn btn-outline-dark">Write Complete</button>
				<a href="./list" class="btn btn-outline-dark">list</a>
				<a href="/" class="btn btn-outline-dark">Home</a>
			</div>
		</form>
	</section>
</body>
<script>
	$('#contents').summernote({
		tabsize : 4,
		height : 250
	});
</script>
</html>