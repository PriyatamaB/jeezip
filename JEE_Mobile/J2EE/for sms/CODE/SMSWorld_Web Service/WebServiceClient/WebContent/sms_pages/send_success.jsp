
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send SMS Success</title>
</head>
<body>
<center>
<s:form action="main" namespace="/test">
<h2><i>MESSAGE HAS BEEN SENT SUCCESSFULLY....</i></h2>
<img alt="Message sent" src="../Images/animatedsmiley.gif">
<br/>
<br/>
<br/>
<a href="../test/addressBook.action?mobileNo=<%=request.getParameter("receiver") %>"> Do You Want To save This Contact...??</a>
<s:submit value="<<Back"/>
</s:form>
</center>
</body>
</html>