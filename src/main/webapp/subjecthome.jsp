<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Home</title>
</head>
<body>
	<h1>${message}</h1>
	<br>
	<form action="addsubjectform" method="get">
		<input type="submit" value="Click to Add a Subject">
	</form>
	<br>
	<form action="viewsubjects" method="get">
		<input type="submit" value="Click to View list of all Subjects">
	</form>
</body>
</html>