<%@page import="pojos.UserPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question</title>
<style>
@import url("../css_pages/question_style.css");
</style>
</head>

<body background="../Images/bkg4.bmp">
<center>
<s:form action="answer" namespace="/user">
<%--<s:property value="#session.userInfo"/> --%>
<img src="../Images/secure.jpg" height="150" width="150">
<h3>Welcome <%=((UserPOJO)session.getAttribute("userInfo")).getName() %></h3>

<div>Your Security Question is ::
<%=((UserPOJO)session.getAttribute("userInfo")).getQue() %></div><br/>

<s:textfield name="ans" label="Give The Answer  "></s:textfield><br/>
<s:submit value="GET PASSWORD"></s:submit>

</s:form>
</center>
</body>
</html>