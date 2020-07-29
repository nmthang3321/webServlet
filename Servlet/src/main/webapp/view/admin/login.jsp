<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Đăng nhập</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span>
						<span><i class="fab fa-google-plus-square"></i></span>
						<span><i class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<form action="<c:url value='/dang-nhap' />" id="loginSubmit" method="POST">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" name="userName" placeholder="Tên đăng nhập">
							
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" name="password" placeholder="Mật khẩu">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Lưu tài khoản
						</div>
						<div class="form-group">
							<input type="submit" value="Login" class="btn float-right login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Bạn chưa tạo tài khoản?<a href="<c:url value='/dang-ki?action=register' />">Đăng ký</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Quên mật khẩu?</a>
					</div>
				</div>
				<c:if test="${not empty message and not empty alert}">
					<div class="alert alert-${alert}" role="alert">${message}</div>			
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>