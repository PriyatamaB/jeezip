<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<s:form method="post" modelAttribute="bankAccount">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Customer Name</td>
				<td><s:input path="name" /></td>
				
			</tr>
			<tr>
				<td>Enter A/C Type</td>
				<td><s:input path="type"/></td>
				
			</tr>
			<tr>
				<td>Enter A/C PIN</td>
				<td><s:input path="pin" /></td>
				
			</tr>
			<tr>
				<td>Enter A/C Balance</td>
				<td><s:input path="balance" /></td>
				
			</tr>
			
			<tr>
				<td><input type="submit" value="Create A/C" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>