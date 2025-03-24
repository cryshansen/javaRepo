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
        <h1>Studio Addition Form</h1>
        <hr/>
		
		<div class = "row">
			<div class = "col-md-4">
        <form action="${pageContext.request.contextPath}/StudioController" method="post">
		<div class="form-group">
              <input type="text" name="studioName" placeholder="Enter Studio Name"  value="${studio.studioName}"/>
        </div>
		
		<div class="form-group">
           <input type="text" name="studioDescription" placeholder="Enter Studio Description"  value="${studio.studioDescription}" />
         </div>  			
		<div class="form-group">
           <input type="text" name="studioSizeSq" placeholder="Enter Studio Size Sq"  value="${studio.studioSizeSq}" />
		</div>
		<div class="form-group">
           <input type="text" name="studioAvailability" placeholder="Enter Studio Availability"  value="${studio.studioAvailability}" />
		</div>
		<div class="form-group">
           <input type="text" name="studioAccessories" placeholder="Enter Studio Accessories"  value="${studio.studioAccessories}" />
		</div>
		<div class="form-group">
           <input type="text" name="studioCharge" placeholder="Enter Studio Charge dollars"  value="${studio.studioCharge}" />
           </div>
					
			<input type = "hidden" name = "studioId"  value = "${studio.studioId}"/>
			  	<button type = "submit" class = "btn btn-primary">Save</button>				
		</form>
		</div>
		</div>
		<a href = "${pageContext.request.contextPath}/StudioController?action=LIST">Back to List</a>
		</div>
</body>
</html>