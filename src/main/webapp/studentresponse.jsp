<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="com.to.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		List<Student> s1 = (List<Student>) request.getAttribute("message");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Class</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Student s : s1) {
			%>
			<tr>
				<td><%=s.getID() %></td>
				<td><%=s.getName() %></td>
				<td><%=s.getClass_id() %></td>
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
	<form action=deletestudent method="get">
		<br>Enter the ID of the student to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the student">
	</form>
</body>
</html>