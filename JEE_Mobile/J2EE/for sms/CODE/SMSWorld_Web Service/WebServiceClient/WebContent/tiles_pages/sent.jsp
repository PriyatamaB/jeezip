<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OutBox</title>
</head>
<body>
<h2>SENT SMS  :: </h2>

<table border="1">
<tr>
<th>SENDER</th>
<th>RECEIVER</th>
<th>MESSAGE</th>
<th>TIME</th>
<th>DATE</th>
</tr>
<c:forEach var="sms" items="${session.smslist}">
<tr>
<td>
<c:out value="${sms.sender}"></c:out> 
</td>
<td>
<c:out value="${sms.receiver}"></c:out> 
</td>
<td>
<c:out value="${sms.message}"></c:out> 
</td>
<td>
<c:out value="${sms.sendTime}"></c:out> 
</td>
<td>
<c:out value="${sms.sendDate}"></c:out> 
</td>
</tr>
</c:forEach>
</table>
</body>
</html>