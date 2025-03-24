<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apothecary</title>

  <script type="text/javascript" src="js/jquery/jquery-3.4.1.js"></script>
  <script type="text/javascript" src="js/includes.js"></script>
  <script type="text/javascript" src="js/calendar_modal.js"></script>     <!-- AngularJs File -->
    <script type="text/javascript" src="resources/js/angular_v1.6.0.js"></script>
    <script type="text/javascript" src="resources/js/ang_http_post_data.js"></script>

</head>
<body>
<p>Welcome to the apothecary</p>
<!-- <a href="views/customerreg.jsp">Register</a> -->

<a href = "${pageContext.request.contextPath}/CustomerController?action=LIST">CustomerList</a> 
<a href = "${pageContext.request.contextPath}/StudioController?action=LIST">Studio List</a> 

</body>
</html>