<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book List</title>
<script type="text/javascript">
function editContact()
{	
	if(document.frmEditContact.contact.value=="")
	{
		alert("Please select the contact");
		return false;
	}
}
</script>
</head>
<body>
<center>
<s:form namespace="/test" name="frmEditContact">
<s:updownselect name="contact" list="#session.contactList" allowMoveDown="false" allowMoveUp="false" allowSelectAll="false"><h2>Contacts</h2></s:updownselect>
<s:submit value="Edit Contact" align="center" action="update" onclick="return editContact()"/>
</s:form>
</center>
</body>
</html>