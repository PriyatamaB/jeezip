<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h3 align="center">${requestScope.status}</h3>
<body>
	<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Phone No</th>
			<th>Reg Amount</th>
			<th>Reg Date</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="v" items="${requestScope.vendor_list}">
			<td>${v.name}</td>
			<td>${v.email}</td>
			<td>${v.city}</td>
			<td>${v.phoneNo}</td>
			<td>${v.regAmount}</td>
			<td><fmt:formatDate value="${v.regDate}" pattern="dd-MM-yyyy" /></td>
			<td><a href="<spring:url value='/vendor/update?vid=${v.id}'/>">Update</a></td>
			<td><a href="<spring:url value='/vendor/add_part?vid=${v.id}'/>">Add
					Part</a></td>
			<tr>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<a href="<spring:url value='/vendor/register'/>"> Add New Vendor</a>
	</h3>
	
	<h3>
		<a href="<spring:url value='/bank/summary'/>">Fetch Account Summary</a>
	</h3>
	<h3>
		<a href="<spring:url value='/bank/create'/>">Create New Account</a>
	</h3>


</body>
</html>