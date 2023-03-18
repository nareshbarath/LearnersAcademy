<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher home</title>
</head>
<body>
	<h1>${message}</h1>
	<br>
	<form action="addteacherform" method="get">
		<input type="submit" value="Click to Add a Teacher">
	</form>
	<br>
	<form action="viewteachers" method="get">
		<input type="submit" value="Click to View list of all Teachers">
	</form>
</body>
</html>