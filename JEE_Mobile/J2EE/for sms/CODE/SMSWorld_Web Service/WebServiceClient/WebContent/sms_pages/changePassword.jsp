<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script type="text/javascript">
function changePassword()
{
	if(document.frmChangePass.mbno.value=="")
	{
		alert("Please enter the mobile number");
		return false;
	}
	if(document.frmChangePass.old_password.value=="")
	{
		alert("Please enter the old password");
		return false;
	}
	if(document.frmChangePass.password.value=="")
	{
		alert("Please enter the new password");
		return false;
	}
	if(document.frmChangePass.new_password.value!=(document.frmChangePass.password.value))
	{
		alert("New password and confirm new password must be same");
		return false;
	}
}
</script>
</head>
<body >
<center>
<fieldset style="width: 500px; height: 200px;">
<legend><b>Change Password</b>
<s:form action="changePassword_success" nameplace="/test" name="frmChangePass">
<s:textfield name="mbno" label="Enter Mobile no " />
<s:password name="old_password" label="Enter Old Password " />
<s:password name="password" label="Enter New Password " />
<s:password name="new_password" label="Confirm New Password " />
<s:submit value="Change" onclick="return changePassword()"/>
</s:form>
</legend>
</fieldset>
</center>
</body>
</html>