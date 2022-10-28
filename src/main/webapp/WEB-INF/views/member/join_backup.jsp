<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/util.js"></script>
<script defer src="/js/memberAdd.js"></script>
</head>
<body>
	<form action="./add" id="joinForm" method="post">
		<section class="col-lg-6 container-fluid mt-4"
			style="text-align: center;">
			<h1>회원 가입</h1>
			<br>
			<div class="row">
				<div class="row mb-3">
					<label for="inputUserName" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<input type="text" name="id" class="form-control" id="inputId"
							placeholder="ID 입력">
						<div id="inputIdResult"></div>
						<div>
							<font id="id_feedback" size="3"></font>
						</div>
					</div>
				</div>
				<div class="row mb-3">
					<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control"
							id="inputPw" placeholder="Password 입력">
						<div id="inputPwResult"></div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="pw" class="form-control"
							id="inputPwCheck" placeholder="Password 입력">
						<div id="inputPwCheckResult"></div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputName" class="col-sm-2 col-form-label">Name</label>
					<div class="col-sm-10">
						<input type="text" name="name" class="form-control" id="inputName"
							placeholder="이름 입력">
						<div id="inputNameResult"></div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="email" required name="email" class="form-control"
							id="inputEmail" placeholder="Email 입력">
						<div id="inputEmailResult"></div>
					</div>
				</div>
				<!-- <div class="row mb-3">
					<label for="inputPhone" class="col-sm-2 col-form-label">Phone</label>
					<div class="col-sm-10">
						<input type="text" name="phone" class="form-control"
							id="inputPhone" placeholder="전화번호 입력">
						<div></div>
					</div>
				</div> -->

				<div class="row mb-3">
					<label for="files" class="col-sm-2 col-form-label">Photo</label>
					<div class="col-sm-10">
						<input type="file" name="photo" class="form-control" id="files"
							placeholder="전화번호 입력">
					</div>
				</div>
				<div class="mb-3" style="text-align: center;">
					<a href="../" class="btn btn-outline-dark log">home</a>
					<button type="button" id="joinButton" class="btn btn-outline-dark">Sign
						in</button>
				</div>
			</div>
		</section>
	</form>
	<!-- 약관 test-->
	<div style="text-align: center;">
		<div>
			ALL <input type="checkbox" id="all">
		</div>
		<br>
		<div>
			동의1 <input type="checkbox" class="check" name="" id="">
			<div>약관1</div>
		</div>
		<br>
		<div>
			동의2 <input type="checkbox" class="check" name="" id="">
			<div>약관2</div>
		</div>
		<br>
		<div>
			동의3 <input type="checkbox" class="check" name="" id="">
			<div>약관3</div>
		</div>
	</div>

</body>
</html>