<%@ page language="java" contentType="text/html"; charset="UTF-8" 
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Home Page</title>
</head>

<body>
	<h1>This is the Product home page</h1>
	<hr>
	<form action="home">
		<label for="name">Name:</label> 
			<input type="text" name="name"><br>
			
		<br> <label for="brand">Brand:</label> 
			<input type="text"	name="brand"><br>
		
		<br> <label for="category">Category:</label> 
			<input type="text" name="category"><br>
		
		<br> <label for="price">Price:</label> 
			<input type="number" name="price" step="0.01"><br>
		<br>
	</form>


</body>
</html>