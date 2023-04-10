<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add/Edit Doctor</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/style.css">
</head>
<body>
	<h2>Add/Edit Doctor</h2>
	<form:form method="POST" modelAttribute="doctor" action="${pageContext.request.contextPath}/doctors/saveOrUpdateDoctor">
		<table>
			<tr>
				<td>ID:</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Specialization:</td>
				<td><form:input path="specialization" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>