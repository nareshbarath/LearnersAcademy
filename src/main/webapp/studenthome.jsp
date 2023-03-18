<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Home</title>
</head>
<body>
	<h1>${message}</h1>
	<br>
	<form action="addstudentform" method="get">
		<input type="submit" value="Click to Add a Student">
	</form>
	<br>
	<form action="viewstudents" method="get">
		<input type="submit" value="Click to View list of all Students">
	</form>
</body>
</html>