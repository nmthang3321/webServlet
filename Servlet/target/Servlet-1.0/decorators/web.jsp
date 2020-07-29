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

  <title>nmthang - webServlet </title>

  <!-- Bootstrap core CSS -->
  <link href='<c:url value = "/template/web/vendor/bootstrap/css/bootstrap.min.css" />' rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href='<c:url value = "/template/web/css/small-business.css" />' rel="stylesheet">
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
 
  <script src='<c:url value = "/template/web/vendor/jquery/jquery.min.js" />'></script>
  <script src='<c:url value = "/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>
</body>
</html>