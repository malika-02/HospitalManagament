<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Appointment Type</title>
</head>
<body>
    <h1>Edit Appointment Type</h1>
    <form action="../edit/${appointmentType.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="${appointmentType.name}" required><br><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
