<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="com.to.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	List of available classes<br>
	<%
	try {
		List<Classes> c1 = (List<Classes>) request.getAttribute("message");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>STD</th>
				<th>Section</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Classes c : c1) {
			%>
			<tr>
				<td><%=c.getID()%></td>
				<td><%= c.getStd() %></td>
				<td><%= c.getSection() %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>
	<%
	} catch (Exception e) {
	out.print(e.getMessage());
	}
	%>
	<br>
	<br>
	<br>
	<br>
	<h1>Fill the form to add a student</h1>
	<form action=addstudent method="post">
		Enter the name of the student
		<input type="text" name="name" required><br>
		Enter the ID of the class
		<input type="number" name="classid" value="ID of the Class" required> 
		<input type="submit">
	</form>
</body>
</html>