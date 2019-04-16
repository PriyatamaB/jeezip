<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style type="text/css">
@import url("../css_pages/registration_style.css");
</style>
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
</script>
</head>

<body background="../Images/blue.bmp">
	<center>
		<fieldset style=" width: 600px; height:380px;">
			<legend><B><font size="4">Registration Form...</font></B></legend>
			<s:form name="regform" action="register" namespace="/user">
				<s:textfield name="name" label="Enter Name " onkeypress="return OnlyChars(event)"/>	
				<s:textfield name="mbno" label="Enter Mobile Number" onkeypress="return Onlynumber(event)"/>
				<s:textfield name="bdate" label="Enter BirthDate  (mm/dd/yyyy)"/>
				<s:radio list="#application.gender" label="Select Gender  " name="gender"/>
				<s:select list="#application.state" label="Select State  "name="state"></s:select>
				<s:select list="#application.city" label="Select City  "name="city"></s:select>
				<s:select list="#application.que" label="Select Question" name="que"/>
				<s:textfield name="ans" label="Enter Answer  "/>
				<s:submit  align="center" value="Register" />
			</s:form>
		</fieldset>
	</center>
</body>
</html>