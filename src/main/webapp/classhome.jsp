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
	<form action="addclassform" method="get">
		<input type="submit" value="Click to Add a Class">
	</form>
	<br>
	<form action="viewclasses" method="get">
		<input type="submit" value="Click to View list of all Classes">
	</form>
</body>
</html>