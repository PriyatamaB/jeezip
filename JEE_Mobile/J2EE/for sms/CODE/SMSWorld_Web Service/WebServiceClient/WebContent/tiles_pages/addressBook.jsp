<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pojos.AddressBookPOJO,java.util.ArrayList" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book</title>
</head>
<body>
<center>
<table border="1">
	<tr height="150px">
		<td>
			<table align="left" height="150px" width="350px">
			<tr><td align="center">			
				<jsp:include page="addressBook_list.jsp"></jsp:include>
			</td></tr>			
			</table>	
		</td>
		<td>
			<table align="right">
				<tr><td>
					<jsp:include page="add_contact.jsp"></jsp:include>
				</td></tr>
			</table>
		</td>
	</tr>
</table>
</center>
</body>
</html>