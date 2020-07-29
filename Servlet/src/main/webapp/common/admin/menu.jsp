<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

	<a class="sidebar-brand d-flex align-items-center justify-content-center" href='<c:url value = "/trang-chu" />'>
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			SB Admin <sup>2</sup>
		</div>
	</a>

	<hr class="sidebar-divider my-0">
	<li class="nav-item active">
		<a class="nav-link" href='<c:url value = "/admin-home" />'> 
			<i class="fas fa-fw fa-tachometer-alt"></i> 
			<span>Trang chủ</span>
		</a>
	</li>

	<hr class="sidebar-divider">

	<div class="sidebar-heading">Danh mục</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Cài
				đặt tài khoản</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="buttons.html">Quản lí người dùng</a>
				<a class="collapse-item" href="cards.html">Tài khoản quản trị</a> <a
					class="collapse-item" href="cards.html">Đăng nhập</a>
			</div>
		</div></li>
	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Utilities:</h6>
				<a class="collapse-item" href="utilities-color.html">Colors</a> <a
					class="collapse-item" href="utilities-border.html">Borders</a> <a
					class="collapse-item" href="utilities-animation.html">Animations</a>
				<a class="collapse-item" href="utilities-other.html">Other</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Quản trị bài viết</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>Bài viết</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href='<c:url value = "/admin-news?action=list&curentPage=1&visiblePage=3&sortBy=id&sortName=desc" />'>Danh sách bài viết</a>
			</div>
		</div></li>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseCategory"
		aria-expanded="true" aria-controls="collapseCategory"> <i
			class="fas fa-fw fa-folder"></i> <span>Thể loại</span>
	</a>
		<div id="collapseCategory" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="<c:url value = '/admin-category?action=list' />">Danh sách thể loại</a> <a
					class="collapse-item" href="login.html">Thêm thể loại</a>
			</div>
		</div></li>
</ul>

