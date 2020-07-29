<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="index.html">Start Bootstrap</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/trang-chu" />">Trang chủ</a></li>
				<c:choose>
					<c:when test="${not empty USERMODEL}">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/trang-chu?action=logout' />">Thoát</a></li>
						<li class="nav-item"><a class="nav-link">Xin chào
								${USERMODEL.userName}</a></li>
						<c:if test="${USERMODEL.role.code == 'admin'}">
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/admin-news" />">Quản trị</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/dang-nhap?action=login' />">Đăng nhập</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/dang-ki?action=register' />">Đăng kí</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="contact.html">Thông
						tin</a></li>
			</ul>
			l
		</div>
	</div>
</nav>

<!-- Page Header -->
<header class="masthead"
	style="background-image: url('<c:url value="/template/web/img/home-bg.jpg" />')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>Clean Blog</h1>
					<span class="subheading">A Blog Theme by Start Bootstrap</span>
				</div>
			</div>
		</div>
	</div>
</header>