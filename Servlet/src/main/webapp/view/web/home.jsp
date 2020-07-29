<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<c:if test="${not empty MODEL}">
					<c:forEach items="${MODEL}" var="i">
						<div class="post-preview">
							<a href="<c:url value='/news?action=view&id=${i.id}' />">
								<h2 class="post-title">${i.title}</h2>
								<h3 class="post-subtitle">${i.shortDescription}</h3>
							</a>
							<p class="post-meta">
								Posted by <a href="#">${i.createBy}</a> on ${i.modifyDate}
							</p>
						</div>
						<hr>
					</c:forEach>
				</c:if>
				<!-- Pager -->
				<div class="clearfix">
					<a class="btn btn-primary float-right" href="#">Older Posts
						&rarr;</a>
				</div>
			</div>

		</div>
	</div>

	<hr>
</body>
</html>