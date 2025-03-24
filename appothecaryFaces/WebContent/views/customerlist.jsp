<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Directory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "container">
		
		<h1>Customer Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/customerreg.jsp'">Customer Registration</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Customer Name</th>
				<th>Customer First Name</th>
				<th>Customer Last Name</th>
				<th>City</th>
				<th>Province</th>
				<th>Phone</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${list}" var="customer">
			
				<tr>
					<td>${customer.customerName}</td>
					<td>${customer.contactFirstName}</td>
					<td>${customer.contactLastName}</td>
					<td>${customer.city}</td>
					<td>${customer.province}</td>
					<td>${customer.phone}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/CustomerController?action=EDIT&id=${customer.customerNumber}">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/CustomerController?action=DELETE&id=${customer.customerNumber}">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>