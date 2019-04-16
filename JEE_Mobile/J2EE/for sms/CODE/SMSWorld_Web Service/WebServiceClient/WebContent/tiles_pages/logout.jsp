<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogOut</title>
</head>
<style>
li
{
	list-style: none;
	float: left;
}
li input 
{
	background:navy;
	color: white;
	height:30px;	
	border-color:white;
	cursor: pointer;	
}
.div
{
	height:70px;
	width:768px;
	color:white;
	background-color: rgb(4,132,172);
	font-size: 24px;	
	font-family:Baskerville Old Face;	
}
.mm{
	background:rgb(4,132,172);
	color:white;
	width:768px;
	height: 30px;
	float: left;
	font-weight:bold;
	font-size: 16px;	
}
</style>
<script>
function loginAgain()
{
	document.frmLogout.action="../sms_pages/login.html";
	document.frmLogout.submit();
}
function home()
{
	document.frmLogout.action="../sms_pages/welcome.html";
	document.frmLogout.submit();
}
</script>
<body>
<s:form name="frmLogout">
<%session.invalidate(); %>
<div class="mm">Welcome To Free SMS World....... 	      
</div>
<div align="left">
	<img src="../Images/way2sms-logo.png">	
</div>
<div class="div">
<i>You have been successfully logged out of SMSWorld</i>
	<div style="float: right;">
		<ul>
			<li><input type="submit" value="LOGIN AGAIN" onclick="loginAgain()"></li>
			<li><input type="submit" value="HOME" onclick="home()"></li>
		</ul>
	</div>
</div>
<div>
<img width="768" src="../Images/toyota.jpg">
</div>
<div class="mm">Thanks for visiting ....VISIT AGAIN..	      
</div>
</s:form>
</body>
</html>