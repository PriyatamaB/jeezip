<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.StringTokenizer" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Contact</title>
</head>
<body>
<%
	StringTokenizer str=new StringTokenizer(request.getParameter("contact"),":");
	String arr[]=new String[str.countTokens()];
	int i=0;
	while(str.hasMoreTokens())
	{
		arr[i]=str.nextToken();
		i++;
	}
	System.out.println("String array : "+arr[0]);
	System.out.println("String array : "+arr[1].trim());
	session.setAttribute("update_no",arr[1].trim());
	session.setAttribute("update_name",arr[0]);
%>
<center>
<table>
	<tr align="center"><td><h2><%= arr[0]%></h2></td></tr>
	<tr align="center"><td>	
		<s:form namespace="/test">
		Mobile No.   :: <input type="text" name="mobileNo" value="<%= arr[1].trim()%>" readonly="readonly"/><br><br>
		Contact Name  :: <input type="text" name="contactName" value="<%= arr[0]%>"/>
		<s:submit value="Send SMS" align="center" action="send"/>
		<s:submit value="Update Contact" action="update_success" align="center"/>
		<s:submit value=" Delete  Contact" align="center" action="delete"/>
		</s:form>
	</td></tr>
</table>		
</center>
</body>
</html>