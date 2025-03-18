<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "${pageContext.request.contextPath}/EmployeeController" method="GET">
<input type="submit" value="EmployeeList">
</form>

<a href = "${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a> 
</body>
</html>