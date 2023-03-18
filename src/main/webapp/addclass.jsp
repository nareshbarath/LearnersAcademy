<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
</head>
<body>
	<h1>Fill the form to add a teacher</h1>
	<form action=addclass method="post">
		<input type="text" name="std" value="STD of the Class" required>
		<input type="text" name="section" value="Section of the Class" required> 
		<input type="submit">
	</form>
</body>
</html>