<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Appointment Type</title>
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

        form {
            display: inline-block;
            text-align: left;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        label, input {
            display: block;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #2196F3;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0b75c4;
        }

        .container {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Appointment Type</h1>
        <form action="add" method="post">
            <label for="name">Name:</label>
            <input type="text" name="name" id="name" required><br><br>
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
