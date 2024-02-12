<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Fish</title>
</head>
<body>
	<h1>All Fish</h1>
	
	<form method = "post" action = "navigationServlet">
	<table> 
		<c:forEach items="${requestScope.allFish}" var="currentfish"> 
		<tr> 
			<td><input type="radio" name="id" value="${currentfish.id}"></td> 
			<td>${currentfish.species}</td> 
			<td>${currentfish.numOfFish}</td> 
		</tr> 
		</c:forEach> 
	</table> 
	<input type = "submit" value = "edit" name="doThisToFish"> 
	<input type = "submit" value = "delete" name="doThisToFish"> 
	<input type="submit" value = "add" name = "doThisToFish">
	</form>
</body>
</html>