<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${requestScope.status}</h4>
	<h4>
		<a href="<spring:url value='/vendor/add_part?vid=${param.vid}'/>">Add Part</a>
	</h4>
	<h4>
		<a href="<spring:url value='/vendor/list'/>">Back To Vendor List</a>
	</h4>

</body>
</html>