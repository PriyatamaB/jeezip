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
	<h3>${requestScope.status}</h3>
	<s:form method="post" modelAttribute="part">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Part Name</td>
				<td><s:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter Part Description</td>
				<td><s:input path="description" /></td>
			</tr>
			<tr>
				<td>Enter Part Price</td>
				<td><s:input path="price" /></td>
			</tr>
					<tr>
				<td><input type="submit" value="Add Part" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>