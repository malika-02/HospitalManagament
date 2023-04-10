<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Doctors</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/style.css">
</head>
<body>

	<h2>List of Doctors</h2>
	<c:if test="${not empty doctors}">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Specialization</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="doctor" items="${doctors}">
					<tr>
						<td>${doctor.id}</td>
						<td>${doctor.name}</td>
						<td>${doctor.email}</td>
						<td>${doctor.address}</td>
						<td>${doctor.phoneNumber}</td>
						<td>${doctor.specialization}</td>
						<td>
							<a href="${pageContext.request.contextPath}/doctors/edit?id=${doctor.id}">Edit</a>
							<a href="${pageContext.request.contextPath}/doctors/delete?id=${doctor.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/doctors/add" method="get">
		<button type="submit">Add New Doctor</button>
	</form>

	<p><a href="${pageContext.request.contextPath}/">Back to home page</a></p>
	

</body>
</html>