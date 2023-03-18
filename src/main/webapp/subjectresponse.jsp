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
		List<Subject> sl = (List<Subject>) request.getAttribute("message");
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
	<br>
	<form action="deletesubject" method="get">
		<br>Enter the ID of the subject to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the subject">
	</form>
</body>
</html>