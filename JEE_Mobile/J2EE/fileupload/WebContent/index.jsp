<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="upload">
		Upload File: <input type="file" name="file"/>
		<br/>
		<input type="submit" value="Upload"/>
	</form>
	<div>
		Status: ${status}
	</div>
	<a href="image.jsp?imgname=${image}">Find Image</a>
</body>
</html>

