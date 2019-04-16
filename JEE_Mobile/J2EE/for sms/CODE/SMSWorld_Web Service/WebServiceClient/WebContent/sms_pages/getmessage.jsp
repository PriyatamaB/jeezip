<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Message</title>
<style type="text/css">
.txt
{
color: white;
}
</style>
</head>
<body background="../Images/bkg5.jpg">
<form action="../test/send">

<%
	String msg=request.getParameter("subject");
	if(msg.equals("jokes"))
	{
%>
 
	<h3>Select Joke :: </h3>
	
	 <s:radio name="jokes" list="#application.jokes.get(1)" /><br/>
	 <s:radio name="jokes" list="#application.jokes.get(2)"/><br/>
	 <s:radio name="jokes" list="#application.jokes.get(3)"/><br/>
	 <s:radio name="jokes" list="#application.jokes.get(4)"/><br/>
	 <s:radio name="jokes" list="#application.jokes.get(5)"/><br/>
	 
	 <img src="../Images/jok1.jpg" height="140" width="200"><br/>
<%
   session.setAttribute("msg","jokes");
}
	else if(msg.equals("GudMrng"))
{%>
	<h3>Select Good morning Messages ::</h3>
	<img align="right" src="../Images/gudmrng1.gif" height="150" width="300"><br/>
	 <s:radio name="gudmrng" list="#application.gudmrng.get(1)"/><br/>
	 <s:radio name="gudmrng" list="#application.gudmrng.get(2)"/><br/>
	 <s:radio name="gudmrng" list="#application.gudmrng.get(3)"/><br/>
	 <s:radio name="gudmrng" list="#application.gudmrng.get(4)"/><br/>
	 <s:radio name="gudmrng" list="#application.gudmrng.get(5)"/><br/>
	 
	 
<%
   session.setAttribute("msg","gudmrng");
}
else
	
{%>
<img src="../Images/birth2.jpg" height="150" width="180">
<img align="right" src="../Images/birth1.jpg" height="250" width="300">

	<h3>Select BirthDay Messages ::</h3>
	 <s:radio name="birthday" list="#application.birthday.get(1)"/><br/>
	 <s:radio name="birthday" list="#application.birthday.get(2)"/><br/>
	 <s:radio name="birthday" list="#application.birthday.get(3)"/><br/>
	 <s:radio name="birthday" list="#application.birthday.get(4)"/><br/>
	 <s:radio name="birthday" list="#application.birthday.get(5)"/><br/>
<%
    session.setAttribute("msg","birthday");
}
	
	
%>
<br>
<s:submit align="left" value="ADD MESSAGE"></s:submit>
</form>
</body>
</html>