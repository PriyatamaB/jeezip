<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account</title>
</head>
<body>
<%
if(request.getParameter("mbno")!=null)
{
	/*String mobno=request.getParameter("mbno");
	out.print(""+mobno);*/
	session.setAttribute("mobileNo",request.getParameter("mbno"));
}
/*else
{
	out.print(session.getAttribute("mobileNo"));
}*/
%>
<img src="../Images/SMS-tweets.jpg" height="250px" width="250px">
</body>
</html>