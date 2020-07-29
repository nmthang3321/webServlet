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
	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<c:if test="${not empty NEWS}">
					<div class="post-preview">
						<p class="post-meta">Thể loại: ${NEWS.categoryModel.categoryType}</p>
						<a href="post.html">
							<h2 class="post-title">${NEWS.title}</h2>
							<h3 class="post-subtitle">${NEWS.shortDescription}</h3>
						</a>
						<p class="post-meta">${NEWS.content}</p>
					</div>
					<hr>
				</c:if>
				<!-- Pager -->
				<div class="clearfix">
					<a class="btn btn-primary float-right" href="#">Older Posts
						&rarr;</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>