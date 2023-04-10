<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #f1f1f1;
            padding: 20px;
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
    <h1>Registration List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Patient Name</th>
            <th>Doctor Name</th>
            <th>Appointment Date</th>
            <th>Appointment Type</th>
            <th>Diagnosis</th>
            <th>Prescription</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${registrations}" var="registration">
            <tr>
                <td>${registration.id}</td>
                <td>${registration.patient.name}</td>
                <td>${registration.doctor.name}</td>
                <td>${registration.appointmentDate}</td>
                <td>${registration.appointmentType.name}</td>
                <td>${registration.diagnosis}</td>
                <td>${registration.prescription}</td>
                <td>
                    <spring:url var="editUrl" value="/registration/edit/${registration.id}" />
                    <a href="${editUrl}">Edit</a>
                </td>
                <td>
                    <spring:url var="deleteUrl" value="/registration/delete/${registration.id}" />
                    <a href="${deleteUrl}" onclick="return confirm('Are you sure you want to delete this registration?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <spring:url var="addUrl" value="/registration/add" />
    <a href="${addUrl}">Add Registration</a>
    <br>
   <spring:url var="homeUrl" value="/home" />
<a href="${homeUrl}">Home</a>
</body>
</html>
