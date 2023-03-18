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
		List<Lesson> L1= (List<Lesson>) request.getAttribute("message");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Class</th>
				<th>Subject</th>
				<th>Teacher</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Lesson s : L1) {
			%>
			<tr>
				<td><%=s.getID() %></td>
				<td><%=s.getClass_id() %></td>
				<td><%=s.getSubject_id() %></td>
				<td><%=s.getTeacher_id() %></td>
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
	<form action=deletelesson method="get">
		<br>Enter the ID of the assignment to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the assignment">
	</form>
</body>
</html>