<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Patients</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/style.css">
</head>
<body>

	<h2>List of Patients</h2>
	<c:if test="${not empty patients}">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					 <th>date_of_birth</th>
					<th>gender</th>
					<th>blood group</th>
					<th>Delete a patient </th>
					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="patient" items="${patients}">
					<tr>
						<td>${patient.id}</td>
						<td>${patient.name}</td>
						<td>${patient.email}</td>
						<td>${patient.phoneNumber}</td>
						<td>${patient.dateOfBirth}</td>
						<td>${patient.gender}</td>
						<td>${patient.bloodGroup}</td>
							<td>
							
							<a href="${pageContext.request.contextPath}/patients/delete?id=${patient.id}">Delete</a>
						</td>
						
						
						
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
		<form action="${pageContext.request.contextPath}/patients/" method="get">
		<button type="submit">Add New Patient</button>
	</form>
	
	<!-- <p><a href="/hospital/patients/">Add a patient</a>< -->
	

	

</body>
</html>