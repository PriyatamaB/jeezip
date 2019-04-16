<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC - Hibernate File Upload to Database Demo</title>
</head>
<body>
    <div align="center">
        <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
        <sf:form method="post" action="doUpload" enctype="multipart/form-data" modelAttribute="emp">
               
               <span>Employee Name:</span><sf:input path="name"/><br/>
               <span>Salary :</span><sf:input path="sal"/><br/>
               <span>Select Department :</span>
              <%--  <select name="d">
                 <c:forEach var="dep" items="${deptList}">
                      <option value="dep">${dep.name}</option>
                 </c:forEach>
               </select> --%>
               <sf:select path="dept.deptno">
                    
                   <sf:options items="${deptList}" itemValue="deptno" itemLabel="name"/> 
               </sf:select>
                <br/>  
               
               
               Browse Image:<input type="file" name="fileUpload" size="50" /><br/>
                    
               <input type="submit" value="Upload" />
               
            
        </sf:form>
    </div>
</body>
</html>