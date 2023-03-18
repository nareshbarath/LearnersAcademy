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
		List<Teacher> tr = (List<Teacher>) request.getAttribute("message");
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
	<form action="deleteteacher" method="get">
		<br>Enter the ID of the teacher to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the teacher">
	</form>
</body>
</html>