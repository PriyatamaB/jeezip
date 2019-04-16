<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group SMS</title>

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

function sendMessage()
{
	if(document.frmSend.receiver.value=="")
	{
	  alert("Please enter the mobile number");
	  return false;
	}
	else
	{
		document.frmSend.action="../test/sendsms.action";
		document.frmSend.submit();
	}
}
function  getMessage()
{
	if(document.frmSend.subject.value=="")
	{
	  alert("Please select any one of the subject");
	  return false;
	}
	else
	{
		document.frmSend.action="../user/getmsg.action";
		document.frmSend.submit();
		return true;
	}
}
function saveSMS()
{
	document.frmSend.action="../test/savesms.action";
	document.frmSend.submit();
}

</script>
<style type="text/css">
.mm{
	/*background:rgb(198,190,212);*/
	background:gray;
	color:black;
	font-weight:bold;
	font-size: 16px;	
}

</style>
</head>
<body>
<table>
<tr>
	<td width="400"><h3 align="center"><font face="ALGERIAN">SEND GROUP MESSAGE</font></h3>
	 <form action="" name="frmSend">
	 
	<%
	String msg="jokes";
	if(session.getAttribute("msg")!=null)
	{
	 msg=session.getAttribute("msg").toString(); 
	}
	if(request.getParameter("mobileNo")!=null)
	{
		%>
		Enter Number   :<input type="text" name="receiver" style="width: 190px;" value="<%=request.getParameter("mobileNo") %>"><br><br>
		<%
	}
	else
	{
	%>	
	Enter Number   :<input type="text" name="receiver" style="width: 190px;"  onkeypress="return Onlynumber(event)"><br><br>
	<%} %>
			Enter Message  :<br>
			<%
			if(request.getParameter(msg)==null)
			{
				%>
				<textarea rows="4" cols="35" name="message"></textarea><br><br>
				<%
			}else{
			%>
			<textarea rows="4" cols="35" name="message"><%=request.getParameter(msg)%></textarea><br><br>
			<%} %>
			<input type="submit" value="SEND SMS" onclick="return sendMessage()">
			<input type="submit" value="SAVE" onclick="return saveSMS()"><br>
			<h3>If you want template message then <br>select subject</h3>
			<select name="subject">
			    <option value="">-- Select Subject --</option>
				<option value="jokes">jokes</option>
				<option value="GudMrng">GudMrng</option>
				<option value="BirthDay">BirthDay</option>
			</select>
			<input type="submit" value="GET MESSAGE" onclick="return getMessage()">
		</form>
	</td>
	
	<td width="400" align="right" >
	  <img height="340" width="300" src="../Images/SMS-tweets.jpg">
	</td>
</tr>
</table>
</body>
</html>