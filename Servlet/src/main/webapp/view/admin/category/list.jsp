<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/api" var="APIurl"/>
<c:url value="/admin-news" var="NewURL"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style type="text/css">
.table-fit {
    width: 1px;
}
</style>
</head>
<body>
	<form action="<c:url value='/admin-category' />" id="formSubmit" method="GET">
		<buton class="btn material-icons" role="button" id ="delete">delete</buton>
		<a href="<c:url value='/admin-news?action=edit' />" class="btn material-icons" role="button">add_circle</a>
		<div class="container table-responsive-xl">
			<table class="table table-bordered table-fit">
				<thead>
					<tr>
						<th style="width:2px" class="text-center">ID</th>
						<th style="width:100px" class="text-center">Tên thể loại</th>
						<th style="width:150px" class="text-center">Thao tác <input type="checkbox" id="checkAll" value=""> </th>
					</tr>
				</thead>
				<c:if test="${not empty CATEGORY}">
					<c:forEach items="${CATEGORY}" var="i">
						<tbody>
							<tr>
								<td >${i.id}</td>
								<td>${i.categoryType}</td>
								<td><a href="<c:url value='/admin-news?action=update&id=${i.id}' />" class="btn material-icons" role="button">border_color</a>
								<input type="checkbox" value="${i.id}" id="${i.id}"></td>
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
		$(document).ready(function(){
			$('#checkAll').change(function() {
				var check = $('#checkAll:checkbox:checked').is(':checked');
				if (check){
					$('tbody input[type=checkbox]').prop('checked', true);
				} else{
					$('tbody input[type=checkbox]').prop('checked', false);
				}
			});
			
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
		   
			$("#delete").click(function() {
				var data = {};
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
			           return $(this).val();
			       }).get();
				data['ids'] = ids;
				if (data['ids'].length > 0){
					deleteNew(data);	
				}else{
					alert("Chưa chọn bài viết");
				}
				
			});
			
			function deleteNew(data) {
			       $.ajax({
			           url: '${APIurl}',
			           type: 'DELETE',
			           contentType: 'application/json',
			           data: JSON.stringify(data),
			           success: function (result) {
			               window.location.href = "${NewURL}?action=list&curentPage=1&visiblePage=3&sortBy=id&sortName=desc";
			               alert("Xóa bài viết thành công");
			           },
			           error: function (error) {
			           	window.location.href = "${NewURL}?action=list&curentPage=1&visiblePage=3&sortBy=id&sortName=desc";
			           	alert("Xóa bài viết không thành công, hãy thử lại");
			           }
			       });
			   }
		})
	</script>
</body>
</html>