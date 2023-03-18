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
	<form action="deleteclass" method="get">
		<br>Enter the ID of the class to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the class">
	</form>
</body>
</html>