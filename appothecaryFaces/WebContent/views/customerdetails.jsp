<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controller.CustomerController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
</head>
<body>
<p>Go Shopping! </p>
<p>customerName</p>

<jsp:useBean id="customer" class="entity.Customer" />
<jsp:setProperty property="*" name="customer" />

<%
  /* CustomerController custCon = new CustomerController();
 	
  int status = custCon..registerEmployee(customer);
  if (status > 0) {
   out.print("You are successfully registered");
  } */
 %>
</body>
</html>