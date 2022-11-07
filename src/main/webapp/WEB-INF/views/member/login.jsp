<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<body>
	<div>
		<%-- <h3>${param.error }</h3>
		<h3>${param.message }</h3> --%>
	</div>
	<!-- http://192.168.1.37:81/member/login -->
	<form action="./login" method="post">
		<br>
		<!-- SecurityConfig 에서 CSRF 주석시 사용 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<h1 style="text-align: center;">로그인</h1>
		<section class="col-lg-6 container-fluid mt-4">
			<div class="row">
				<span style="color: red; text-align: center;">${msg }</span>
				<div class="mb-3">
					<label> 아이디 </label>
					<input type="text" id="id" class="form-control" name="id" placeholder="ID Input" value="1"
						value="${cookie.userId.value }" onfocus="this.placeholder=''" onblur="this.placeholder='ID Input'"
						autocomplete="off">
				</div>
				<div class="mb-3">
					<label>비밀번호</label>
					<input type="password" id="pwd" class="form-control" name="pwd" placeholder="Password Input" value="1"
						onfocus="this.placeholder=''" onblur="this.placeholder='Password Input'" autocomplete="off">
					<div></div>
				</div>
				<div class="mb-3 form-check" style="margin-left: 35px;">
					<label>아이디 기억하기</label>
					<input type="checkbox" id="rememberId" class="form-check-input" name="rememberId">
					<div></div>
				</div>
				<div class="mb-3 form-check" style="margin-left: 35px;">
					<label>로그인 정보 기억하기</label>
					<input type="checkbox" id="rememberMe" class="form-check-input" name="rememberMe">
					<div></div>
				</div>
				<div class="mb-3" style="text-align: center;">
					<a href="../" class="btn btn-outline-dark log">home</a>
					<button type="submit" id="but" class="btn btn-outline-dark log">로그인</button>
				</div>
			</div>
		</section>
	</form>
</body>
<script>
	//history.replaceState(), null, location.pathname;
</script>
</html>