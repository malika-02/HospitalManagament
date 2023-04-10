<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        h2 {
            background-color: #f1f1f1;
            padding: 20px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
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
    <h2>Add Registration</h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/registration/add" modelAttribute="registration">
        <table>
            <tr>
                <td>Patient:</td>
                <td>
                    <form:select path="patient.id">
                        <form:options items="${patients}" itemValue="id" itemLabel="name" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Doctor:</td>
                <td>
                    <form:select path="doctor.id">
                        <form:options items="${doctors}" itemValue="id" itemLabel="name" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Appointment Date:</td>
                <td><form:input path="appointmentDate" type="datetime-local" /></td>
            </tr>
            <tr>
                <td>Appointment Type:</td>
                <td>
                    <form:select path="appointmentType.name">
                        <form:options items="${appointmentTypes}" itemValue="name" itemLabel="name" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Diagnosis:</td>
                <td><form:input path="diagnosis" /></td>
            </tr>
            <tr>
                <td>Prescription:</td>
                <td><form:input path="prescription" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Registration" />
                </td>
            </tr>
        </table>
    </form:form>
    <a href="${pageContext.request.contextPath}/registration/list">Back to Registration List</a>
</body>
</html>
