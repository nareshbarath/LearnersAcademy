<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
</head>
<body>
	<h1>Fill the form to add a teacher</h1>
	<form action=addteacher method="post">
		<input type="text" name="name" value="Name of the Teacher" required> 
		<input type="text" name="email" value="Email of the Teacher" required> 
		<input type="submit">
	</form>
</body>
</html>