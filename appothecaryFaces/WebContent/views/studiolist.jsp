<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>

	<div class = "container">
		
		<h1>Studio Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/studio-form.jsp'">Studio Addition</button>
		</p>
	
		<h1>Studio Rental Rates:</h1>
		<p>Starting at $90 for 2 consecutive hours (minimum rental), $45 for each additional hour. Discounts for half day, full day, and weekend rentals. Arrive and Leave on time. All set-up and clean-up needs to be done during rented time.  Studio must be returned to original condition when you studio session time is up. Eg: moving of various items, garbage removed, various cleanup. </p>
		<p>100% payment is required to book the space and booking is on a first-come first-served basis. Deposit can be paid by e-mail money transfer (preferred), cash, or credit card.  You have up to 72 hours before your rental period to cancel or make changes (if possible) to your reservation. There will not be any reimbursement if you cancel or make changes less than 72 hours before the beginning of your rental period.</p>
		
		<p>Limited Memberships also available.</p>
		
		<h3>Membership [*Currently Closed*]</h3>
		<p>(limit 5)</p>
		<ul>
			<li>$300/month (1 year contract)</li>
			<li>12hr studio time per month</li>
			<li>Use of props/backdrops/lighting equipment</li>
			<li>25% off additional monthly hours</li>
			<li>Additional Membership Benefits</li>
			<li>Priority Studio Booking</li>
			<li>Personal building & studio entrance code</li>
			<li>Locked storage access</li>
		</ul>
		<!-- <button>BOOK NOW!</button> -->
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Studio Name</th>
				<th>Description</th>
				<th>Size</th>
				<th>Availability</th>
				<th>Accessories</th>
				<th>Charge</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${list}" var="studio">
									
				<tr>
					
					<td>${studio.studioName}</td>
					<td>${studio.studioDescription}</td>
					<td>${studio.studioSizeSq}</td>
					<td>${studio.studioAvailability}</td>
					<td>${studio.studioAccessories}</td>
					<td>${studio.studioCharge}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/StudioController?action=EDIT&id=${studio.studioId}">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/StudioController?action=DELETE&id=${studio.studioId}">Delete</a> 
					| 
						<a href = "${pageContext.request.contextPath}/StudioController?action=BOOK&id=${studio.studioId}">Bookings</a> 
					
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>