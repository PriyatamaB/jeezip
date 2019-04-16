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
	<s:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Vendor Name</td>
				<td><s:input path="name" /></td>
				<td><s:errors path="name"/></td>
			</tr>
			<tr>
				<td>Enter Vendor Email</td>
				<td><s:input path="email" /></td>
				<td><s:errors path="email"/></td>
			</tr>
			<tr>
				<td>Select Your City</td>
				<td><s:radiobuttons items="${requestScope.cities}" path="city" />
				<td><s:errors path="city"/></td>
			</tr>
			<tr>
				<td>Enter Phone No</td>
				<td><s:input path="phoneNo" /></td>
				<td><s:errors path="phoneNo"/></td>
			</tr>
			<tr>
				<td>Select Reg Amount</td>
				<td><s:select path="regAmount">
						<s:option value="0">Select</s:option>
						<s:options items="${requestScope.amounts}" />
					</s:select></td>
					<td><s:errors path="regAmount"/></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><s:input type="date" path="regDate" /></td>
				<td><s:errors path="regDate"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register Me" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>