<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="com.to.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject and teacher assignment</title>
</head>
<body>
	List of available classes<br>
	<%
	try {
		List<Classes> c1 = (List<Classes>) request.getAttribute("class");
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
	<br> List of available subjects
	<%
	try {
		List<Subject> sl = (List<Subject>) request.getAttribute("subject");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Subject s : sl) {
			%>
			<tr>
				<td><%=s.getID()%></td>
				<td><%=s.getName()%></td>
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
	<br>List of available teachers
	<%
	try {
		List<Teacher> tr = (List<Teacher>) request.getAttribute("teacher");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Teacher t : tr) {
			%>
			<tr>
				<td><%=t.getID()%></td>
				<td><%=t.getName()%></td>
				<td><%=t.getEmail()%></td>
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
	<h1>Fill the form to assign subject and teacher to a class</h1>
	<form action=addlesson method="post">
		<br>Enter the ID of the class
		<input type="number" name="classid" value="ID of the Class" required>
		<br>Enter the ID of the subject
		<input type="number" name="subjectid" value="ID of the Subject" required> 
		<br>Enter the ID of the teacher
		<input type="number" name="teacherid" value="ID of the Teacher" required>
		<input type="submit">
	</form>
</body>
</html>