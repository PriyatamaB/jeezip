
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<script type="text/javascript">
	function send()
	{
		document.form.action="send.action";
		document.form.submit;
	}
	function sent()
	{
		document.form.action="sent.action";
		document.form.submit;
	}
	function groupSMS()
	{
		document.form.action="groupSms.action";
		document.form.submit;
	}
	function draft()
	{
		document.form.action="draft.action";
		document.form.submit;
	}
	function addressBook()
	{
		document.form.action="addressBook.action";
		//document.form.submit;
	}
	function dismouout()
	{
		document.getElementById("settings-pop").style.display="block";
	}
	function dismouovr()
	{
		document.getElementById("settings-pop").style.display="none";
	}
</script>
<style type="text/css">
	@import url("../css_pages/header_style.css");
</style>
</head>

<body>
<form name="form" action="">
<div class="mm">Welcome To Free SMS World.......


		<DIV class="div11 " style="float: right; "  >
				<DIV onmouseover=dismouout(); onmouseout=dismouovr();>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SETTING | <strong>▼</strong> |
					<fieldset  style=" border:hidden;text-align: center;">
						<DIV style=" DISPLAY: none; background-color:white; border-color: white;" id=settings-pop> 
							<A href="../test/change_password.action">Change Password</A> 
							<HR>
							<A href="../sms_pages/helpCenter.html" target="blank">Help Center</A>
							<hr>
							<a href="../test/logout.action" >Logout</a> 
						</DIV>
					</fieldset>
				</DIV>
			</DIV>
	</div>		        

<div align="left">
	<img src="../Images/way2sms-logo.png">
</div>
<div class="div1">
	<ul>
		<li><input type="submit" value="SEND SMS" onclick="return send()"></li>
		<li><input type="submit" value="SENT SMS" onclick="return sent()"></li>
		<li><input type="submit" value="ADDRESS BOOK" onclick="return addressBook()"></li>
		<li><input type="submit" value="DRAFT" onclick="return draft()"></li>
	</ul>
</div>
</form>
</body>
</html>