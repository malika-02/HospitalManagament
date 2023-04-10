<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Registration</title>
</head>
<body>
    <h2>Edit Registration</h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/registration/edit/${registration.id}" modelAttribute="registration">
        <form:hidden path="id" />
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
                    <input type="submit" value="Update Registration" />
                </td>
            </tr>
        </table>
    </form:form>
    <a href="${pageContext.request.contextPath}/registration/list">Back to Registration List</a>
</body>
</html>
