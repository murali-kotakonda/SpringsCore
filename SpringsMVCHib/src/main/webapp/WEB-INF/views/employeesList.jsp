<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<jsp:include page="header.jsp"/> <br/>
<h2>List Employees</h2>

<c:if test="${!empty emps}">

	<c:if test="${ count gt 1}">
		 Pages: 
			<c:forEach var = "i" begin = "1" end = "${count}">
          		<a href='getAllEmpsPagination?pageId=${i}'>${i}</a> &nbsp;
    		</c:forEach>
	</c:if>	
		
		<br/><br/>

		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>LName</th>
				<th>Age</th>
				<th>Login Name</th>
				<th>Salary</th>
				<th>Email</th>
			</tr>
			<c:forEach var="emp" items="${emps}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.lName}</td>
					<td>${emp.age}</td>
					<td>${emp.loginName}</td>
					<td>${emp.salary}</td>
					<td>${emp.email}</td>
					<td><a href="./editEmp?empId=${emp.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>

		<br/> 
	
</c:if>
</body>
</html>