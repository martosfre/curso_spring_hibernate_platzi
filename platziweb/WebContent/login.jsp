<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--Comentario JSP --%>
	<%!int i = 0;%>
	<form method="get" action="./abc123">
		<table>
			<tr>
				<td><label>Usuario:</label></td>
				<td><input type="text" name="usuario"></td>
				<td><label>Clave:</label></td>
				<td><input type="password" name="password"></td>
				<td><label>Empresa:</label></td>
				<td><input type="text" name="empresa"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
		<%
			for (i = 0; i < 10; i++) {
		%>
		<label>Hola <%=i%></label>
		<%
			}
		%>
	</form>
</body>
</html>