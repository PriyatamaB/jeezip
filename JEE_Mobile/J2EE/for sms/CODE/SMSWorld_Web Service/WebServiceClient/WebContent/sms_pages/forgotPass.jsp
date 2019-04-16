<%@page import="java.awt.PageAttributes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
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
function forgot()
{
	if(document.frmForgotPass.mbno.value=="")
	{
	  alert("Please enter the mobile number");
	  return false;
	}
}
</script>
</head>
<style>
@import url("../css_pages/forgotpass_style.css");
</style>
<body background="../Images/bkg4.bmp">
<img align="left" src="../Images/sad_forgot.gif" height="150" width="150">
<center>
<h3>FORGOT &nbsp; PASSWORD</h3>
<s:form action="question" namespace="/user" name="frmForgotPass">
<s:textfield value="" name="mbno" label="Enter your mobile number" onkeypress="return Onlynumber(event)"/>
<br>
<s:submit value="CLICK HERE" onclick="return forgot()"/>
</s:form>
</center>
</body>
</html>