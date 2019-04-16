<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Draft</title>
<script type="text/javascript">
function editMessage()
{	
	if(document.frmDraftMessage.sms.value=="")
	{
		alert("Please select the message");
		return false;
	}
}
</script>
</head>
<body>
<%-- <s:property value="#session.draftList"/> --%>
<h2>DRAFT SMS  :: </h2>
<form name="frmDraftMessage" action="send" >
<table border="1">
<tr>
<th>SENDER</th>
<th>RECEIVER</th>
<th>MESSAGE</th>
</tr>
<c:forEach var="draft" items="${session.draftList}">
<tr>
<td>
<input type="radio" value="${draft.receiver},${draft.message}" name="sms"/>
<c:out value="${draft.sender}"></c:out> 
</td>
<td>
<c:out value="${draft.receiver}"></c:out> 
</td>
<td>
<c:out value="${draft.message}"></c:out> 
</td>
</tr>
</c:forEach>
</table>
<br>
<input type="submit" value=" Edit Message " onclick="return editMessage()" name="editContact">&nbsp;&nbsp;
<%--<s:submit value="Edit Message" align="left"/> --%>
</form>
</body>
</html>