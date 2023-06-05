<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Form</title>
</head>
<body>
    <h1>Product Form</h1>
    <form action="productServlet" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" required><br><br>
        
        <input type="submit" value="Save">
    </form>
</body>
</html>
