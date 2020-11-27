<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- import the jstl tags -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${age lt 18 }">
   Invalid age
</c:if>

<c:if test="${age == 18 }">
    age is 18
</c:if>


<c:if test="${empty  name }">
    name is empty
</c:if>


<c:if test="${not empty  name }">
    name is not empty
</c:if>


</body>
</html>