<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Appointment Type List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
        }

        h1 {
            background-color: #4CAF50;
            padding: 20px;
            color: white;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        a {
            color: #2196F3;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Appointment Type List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${appointmentTypes}" var="appointmentType">
            <tr>
                <td>${appointmentType.id}</td>
                <td>${appointmentType.name}</td>
                <td><a href="edit/${appointmentType.id}">Edit</a></td>
                <td><a href="delete/${appointmentType.id}" onclick="return confirm('Are you sure you want to delete this appointment type?')">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="add">Add Appointment Type</a>

</body>
</html>
