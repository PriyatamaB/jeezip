<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
<script type="text/javascript">
function Onlynumber(e)
{
	var unicode=e.charCode?e.charCode:e.keyCode;
	if(unicode!=8)
	{
		 if(unicode<48 || unicode>57)
		 {
		 	alert("Please Enter Only Numbers..");
		 	return false;
		 }
	}	
}

function OnlyChars(e)
{
	var unicode=e.charCode?e.charCode:e.keyCode;
	if(unicode!=8)
	{
		 if((unicode<64 || unicode>93) && (unicode<96 || unicode>123))
		 {
		 	alert("Please Enter Only Characters.."+unicode);
		 	return false;
		 }
	}	
}
function saveContact()
{
	if(document.frmAddContact.mobileNo.value=="" || document.frmAddContact.contactName.value=="")
	{
	  alert("Please enter both mobile number and contact name");
	  return false;
	}
}
</script>
</head>
<body>
<center>

<table align="right">
	<tr align="center"><td><h2>Add Contact</h2></td></tr>
	<tr><td>
	<s:form action="save_contact" namespace="/test" name="frmAddContact">
	<%
		if(request.getParameter("mobileNo")!=null)
		{
	%>
	MOBILE NO <input type="text" name="mobileNo" value="<%=request.getParameter("mobileNo")%>"><br>		
	<%}
		else{
	%>
	<s:textfield label="MOBILE NO " name="mobileNo" onkeypress="return Onlynumber(event)"/>
	<%} %>
	<s:textfield label="CONTACT NAME " name="contactName" onkeypress="return OnlyChars(event)"/>
	<s:submit value="Save Contact" onclick="return saveContact()"/>
	</s:form>
	</td></tr>
</table>		
</center>
</body>
</html>