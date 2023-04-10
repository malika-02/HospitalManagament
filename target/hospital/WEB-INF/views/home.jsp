<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Hospital System</title>
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

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin: 10px 0;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #2196F3;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0b75c4;
        }

        .container {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Online Hospital System</h1>
        <ul>
            <li><a href="registration/list">View Registrations</a></li>
            <li><a href="registration/add">Add Registration</a></li>
            <li><a href="appointmentType/list">View Appointment Types</a></li>
            <li><a href="appointmentType/add">Add Appointment Type</a></li>
              <li><a href="doctors/list">View Doctors</a></li>
        </ul>
    </div>
</body>
</html>
