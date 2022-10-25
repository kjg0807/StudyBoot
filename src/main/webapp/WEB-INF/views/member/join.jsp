<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<body>
	<form action="../member/join" method="POST" id="frm" name="myform">
		<br>
		<h1 style="text-align: center;">회원 가입</h1>
		<section class="col-lg-6 container-fluid mt-4">
				<!-- id -->
				<div class="mb-3">
					<label class="form-label">아이디</label>
					<input type="text" class="form-control" name="id"
						placeholder="아이디 입력" onfocus="this.placeholder=''"
						onblur="this.placeholder='아이디 입력'" id="id">
				</div>

				<!-- password 1 -->
				<div class="mb-3">
					<label class="form-label">비밀번호</label>
					<input type="password" class="form-control" name="pwd"
						placeholder="비밀번호 입력" id="pwd" onfocus="this.placeholder=''"
						onblur="this.placeholder='비밀번호 입력'" autocomplete="off">
					<!-- pwd를 입력할 때마다 (1글자씩) 메세지를 출력 : pwd - 최소 6글자 이상 -->
					<div id="pwdText" style="display: none; color: #dc3545;">6글자
						이상 16글자 이하로 입력해야 합니다.</div>
				</div>
				<!-- name -->
				<div class="mb-3">
					<label class="form-label">이름</label>
					<input type="text" class="form-control" name="name"
						placeholder="이름 입력" onfocus="this.placeholder=''"
						onblur="this.placeholder='이름 입력'" id="name">
				</div>
				<!-- email -->
				<div class="mb-7">
					<label class="form-label">이메일</label>
					<div>
						<input name="email" id="email" type="text" placeholder="이메일 입력"
							class="form-control" onfocus="this.placeholder=''"
							onblur="this.placeholder='이메일 입력'">
					</div>
					<br>
					<div style="text-align: center;">
						<button type="submit" id="btn1" class="btn btn-outline-dark">회원
							가입</button>
						<button type="reset" class="btn btn-outline-dark">초기화</button>
						<a href="../" class="btn btn-outline-dark log">home</a>
					</div>
				</div>
		</section>
		<br>
		<br>
	</form>
</body>
</html>