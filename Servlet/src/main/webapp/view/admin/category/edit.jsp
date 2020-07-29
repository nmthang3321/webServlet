<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api" />
<c:url var="NewURL" value="/admin-news" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Replace Textareas by Class Name</title>
</head>
<body>
	<form id="formSubmit">
		<div class="form-group">
			<label>Tên bài viết</label>
			<textarea onkeyup="this.style.height='auto';this.style.height=(this.scrollHeight)+'px'"
			cols="120" rows="1" name="title" id="title">${MODEL.resultById.title}</textarea>
		</div>

		<div class="form-group">
			<label>Thể loại</label> 
			<select class="form-control" id="exampleFormControlSelect1" name="categoryId" id="categoryId">
			<c:if test="${not empty CATEGORY}">
				<c:forEach items="${CATEGORY}" var="i">
				<c:choose>
					<c:when test="${i.categoryType == MODEL.resultById.categoryModel.categoryType}">
						<option value="${i.id}" selected>${i.categoryType}</option>
					</c:when>
					<c:otherwise>
						<option value="${i.id}">${i.categoryType}</option>
					</c:otherwise>	
				</c:choose>				
				</c:forEach>
			</c:if>
			</select>
		</div>

		<div class="form-group">
			<label>Mô tả ngắn</label>
			<textarea onkeyup="this.style.height='auto';this.style.height=(this.scrollHeight)+'px'"
			cols="120" rows="1" name="shortDescription" id="shortDescription">${MODEL.resultById.shortDescription}</textarea>
		</div>
		<div class="form-group">
			<label>Chỉnh sửa bài viết</label>
			<textarea class="ckeditor" id = "content" name = "content" cols="80" rows="10">${MODEL.resultById.content}</textarea>
		</div>
 		<c:choose>
			<c:when test="${empty MODEL.resultById.id}">
				<button type="button" class="btn btn-success" id="submit">Thêm bài viết</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-success" id="submit">Cập nhật bài viết</button>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="id" id="id" value="${MODEL.resultById.id}">
	</form>
<script>
	var edit = '';
	var id = ${MODEL.id};
	$(document).ready(function(){
		$('#submit').click(function(e){
			edit = CKEDITOR.instances['content'].getData();
			e.preventDefault();
	        var data = {};
	        var formData = $('#formSubmit').serializeArray();
	        $.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
 	        data["content"] = edit;
 	        if (id != 0){
 	        	updateNew(data);	
 	        } else{
 	        	addNew(data);
 	        }	         
		})
	})
	
	function updateNew(data){
		$.ajax({
			url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
				window.location.href = "${NewURL}?action=list&curentPage=1&visiblePage=3&sortBy=id&sortName=desc";
				alert("Đã cập nhật bài viết!");
            },
            error: function (error) {
				window.location.href = "${NewURL}?action=update?id=" + id;
				alert("Lỗi cập nhật bài viết, hãy thử lại!");
            }
		})
	}
	
    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
				window.location.href = "${NewURL}?action=list&curentPage=1&visiblePage=3&sortBy=id&sortName=desc";
				alert("Thêm bài viết thành công!");
            },
            error: function (error) {
				window.location.href = "${NewURL}?action=edit";
				alert("Lỗi thêm bài viết, hãy thử lại!");
            }
        })
        
    }
</script>
</body>
</html>