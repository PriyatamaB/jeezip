<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function showProfile()
{
	  document.getElementById('profile').style.display="";
}
</script>
<title>Employee Profile</title>
</head>
<body>
<sf:form enctype="multipart/form-data" modelAttribute="emp" method="post">
<div>
     <sf:input path="name"/>     
</div>
    
    <div>
        <button onclick="showProfile()">Click To download Profile</button>
    </div>
    
    <div id="profile">
	    <div>
	          Name : ${emp.name}
	    </div>
	     <div>
	          Salary : ${emp.sal}
	     </div>
	    <div align="center">
	        <img src="${url}"/> 
	        
	       
	    </div>
    </div>
</sf:form>
</body>
</html>
