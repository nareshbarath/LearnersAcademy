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
	<form action="addlessonform" method="get">
		<input type="submit" value="Click to Assign teacher and subject to a class">
	</form>
	<br>
	<form action="viewlessons" method="get">
		<input type="submit" value="Click to View list of assigned subjects and teachers for classes">
	</form>
</body>
</html>