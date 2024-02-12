<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Fish</title>
</head>
<body>
	<h1>Edit Fish</h1>
	<form action = "editFishServlet" method="post"> 
	Store: <input type ="text" name = "species" value= "${fishToEdit.species}"> 
	Item: <input type = "text" name = "amount" value= "${fishToEdit.numOfFish}"> 
	<input type = "hidden" name = "id" value="${fishToEdit.id}"> 
	<input type = "submit" value="Save Edited Item"> 
	</form>
</body>
</html>