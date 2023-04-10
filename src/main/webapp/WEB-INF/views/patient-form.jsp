<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Patient</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/style.css">
<style>
input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 15%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>


</head>
<body>
	<h2>Add/Edit Patient</h2>
	<form:form method="POST" modelAttribute="patient" action="${pageContext.request.contextPath}/patients/savepatient">
		
<form action="/action_page.php">
  <label for="name">name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="email">email:</label><br>
  <input type="text" id="email" name="email"><br><br>
    <label for="phoneNumber">phoneNumber:</label><br>
  <input type="number" id="phoneNumber" name="phoneNumber"><br><br>
    <label for="dateOfBirth">dateOfBirth:</label><br>
  <input type="text" id="dateOfBirth" name="dateOfBirth"><br><br>
    <label for="gender">gender:</label><br>
  <input type="text" id="gender" name="gender"><br><br>
  <label for="bloodGroup">bloodGroup:</label><br>
  <input type="text" id="bloodGroup" name="bloodGroup"><br><br>
  <input type="submit" value="Submit">
</form> 
	</form:form>
	
</body>
</html>