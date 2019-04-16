<%@page import="ws.SMSClientService ,ws.SMSClientIntf"%>
<%@page import="pojos.UserPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Answer</title>
</head>
<style>
@import url("../css_pages/answer_style.css");
</style>
<body background="../Images/bkg4.bmp">
 <%
	String ans= request.getParameter("ans");
	String dbAns=((UserPOJO)session.getAttribute("userInfo")).getAns();
	if(ans.equals(dbAns))
	{
		String password=((UserPOJO)session.getAttribute("userInfo")).getPassword();
		SMSClientService clientService=new SMSClientService();
		SMSClientIntf clientIntf= clientService.getSMSClientPort();
		//SMSClient cl=new SMSClient(1);
		String num=((UserPOJO)session.getAttribute("userInfo")).getMbno();
		int status=clientIntf.sendMessage(num,"Your Password is : \n"+password+"\n" + "via SmsWorld.com");
			// out.print("YOUR PASSWORD IS SEND ON YOUR MOBILE PLEASE LOGIN...");
	    %>
	  
	     <s:div cssClass="div">
	     Your Password Has Been Sent On Your Mobile Please Login...
	     <img align="right" src="../Images/smile.jpg" height="50" width="50">
	     </s:div>

	     <%-- <s:a href="../sms_pages/login.html">Go to Login Page...</s:a>    --%> 
	     <jsp:include page="../sms_pages/login.html"></jsp:include>
	     
	     
	    <%
	}
	else
	{
		%>
		<img src="../Images/wrong.jpg" height="200" width="200">
		<h3>Sorry!!...you have entered incorrect answer... </h3>
      <s:a href="../sms_pages/question.jsp"> 
      <h4>Try Again....</h4></s:a>
<% 
	}
%>
	



</body>
</html>