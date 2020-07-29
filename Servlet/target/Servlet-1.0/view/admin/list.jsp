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
	<form action="<c:url value='/admin' />" id="formSubmit" method="GET">
		<div class="container table-responsive-xl">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên bài viết</th>
						<th>Thể loại</th>
						<th>Mô tả ngắn</th>
					</tr>
				</thead>
				<c:if test="${not empty MODEL.listResult}">
					<c:forEach items="${MODEL.listResult}" var="i">
						<tbody>
							<tr>
								<td>${i.id}</td>
								<td>${i.title}</td>
								<td>${i.categoryId}</td>
								<td>${i.shortDescription}</td>
							</tr>
						</tbody>
					</c:forEach>
				</c:if>
			</table>
			<nav aria-label="Page navigation">
				<ul class="pagination" id="pagination"></ul>
			</nav>
		</div>
		<input type="hidden" value="" id="action" name="action" /> 
		<input type="hidden" value="" id="curentPage" name="curentPage" /> 
		<input type="hidden" value="" id="sortBy" name="sortBy" /> 
		<input type="hidden" value="" id="sortName" name="sortName" /> 
		<input type="hidden" value="" id="visiblePage" name="visiblePage" /> 
	</form>
	<script type="text/javascript">
	   $(function () {
		   var curentPage = ${MODEL.curentPage};
		   var visiblePage = ${MODEL.visiblePage};
		   var totalPage = ${MODEL.totalPage};
	       window.pagObj = $('#pagination').twbsPagination({
	           totalPages: totalPage,
	           visiblePages: visiblePage,
	           startPage: curentPage,
	           onPageClick: function (event, page) {
	        	   if (curentPage != page){
	        		   curentPage = page;
		               $('#action').val('list');
		               $('#curentPage').val(curentPage);
		               $('#sortBy').val("id");
		               $('#sortName').val("desc");
		               $('#visiblePage').val(visiblePage);
		               $('#formSubmit').submit();
	        	   }
	           }
	       })
	   });
	</script>
</body>
</html>