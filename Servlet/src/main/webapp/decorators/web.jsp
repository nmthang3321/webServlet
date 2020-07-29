<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Clean Blog - Start Bootstrap Theme</title>

  <!-- Bootstrap core CSS -->
  <link href="<c:url value = '/template/web/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="<c:url value = '/template/web/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="<c:url value = '/template/web/css/clean-blog.min.css' />" rel="stylesheet">
</head>

<body>
  <!-- Bootstrap core JavaScript -->
  <header>
  	<%@include file="/common/web/header.jsp" %>
  </header>
  
  <dec:body/>
  
  <footer>
  	<%@include file="/common/web/footer.jsp" %>
  </footer>
 
  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value = '/template/web/vendor/jquery/jquery.min.js' />"></script>
  <script src="<c:url value = '/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

  <!-- Custom scripts for this template -->
  <script src="<c:url value = '/template/web/js/clean-blog.min.js' />"></script>
</body>
</html>