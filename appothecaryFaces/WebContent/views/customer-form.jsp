<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class = "container">
        <h1>Customer Register Form</h1>
        <hr/>
		
		<div class = "row">
			<div class = "col-md-4">
        <form action="${pageContext.request.contextPath}/CustomerController" method="post">
            	<div class="form-group">
            		<input type="text" class = "form-control" name="customerName" placeholder = "Customer Name" value="${customer.customerName}"/>
				</div>
                <div class="form-group">
                    <input type="text" class = "form-control" name="contactFirstName" placeholder = "Contact First Name" value="${customer.contactFirstName}" />
                </div>
                <div class = "form-group">
						<input type = "text" class = "form-control" name = "name" placeholder = "Enter Contact Last Name" value = "${customer.contactLastName}"/>
				</div>
               	<div class="form-group">
                   <input type="text" name="phone" placeholder="Enter Phone" value="${customer.phone}" />
                </div>
               
                <div class="form-group">
                    <input type="text" name="username" placeholder="Enter username"  value="${customer.username}"/>
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="Enter Password"  value="${customer.password}" />
                </div>
                <div class="form-group">
                   <input type="text" name="addressLine1" placeholder="Enter Address" value="${customer.addressLine1}"/>
               </div>
                <div class="form-group">
                    <input type="text" name="addressLine2" placeholder="Enter Address"  value="${customer.addressLine2}" />
                   </div> 
                <div class="form-group">
                    <input type="text" name="city" placeholder="Enter City"  value="${customer.city}"/>
                </div>
                <div class="form-group">
                    <input type="text" name="province" placeholder="Enter Province"  value="${customer.province}"/>
               </div>
               
                <div class="form-group">
                    <input type="text" name="country" placeholder="Enter Country"  value="${customer.country}" />
                   </div> 
                <div class="form-group">
                    <input type="text" name="postalCode" placeholder="Enter Postal Code"  value="${customer.postalCode}"/>
                </div>              
               	<input type = "hidden" name = "customerNumber"  value = "${customer.customerNumber}"/>
			  	<button type = "submit" class = "btn btn-primary">Save</button>
			  </form>
			  </div>
			  </div>
			  <a href = "${pageContext.request.contextPath}/CustomerController?action=LIST">Back to List</a>
</div>
</body>
</html>