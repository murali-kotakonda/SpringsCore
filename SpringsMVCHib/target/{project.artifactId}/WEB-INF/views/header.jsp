<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${name}
	<br><br>
	<a href="profile?loginName=${loginName}" name="My Profile" value="My Profile">My Profile </a>&nbsp;&nbsp;&nbsp;
     
    <a href="addEmp">Add Employee</a>&nbsp;&nbsp;&nbsp;
    
    <a href="getAllEmps">Show all Employee</a>&nbsp;&nbsp;&nbsp;
    
    <a href="getAllEmpsPagination">Show all Employee [Pagination]</a>&nbsp;&nbsp;&nbsp;

    <a href="readUser">Search Employee</a>&nbsp;&nbsp;&nbsp;
    
    <a href="deleteEmp" name="DeleteUser" value="DeleteUser">Delete Employee</a>&nbsp;&nbsp;&nbsp;
    
    <a href="logout">Logout</a>&nbsp;&nbsp;&nbsp;
    <br/><br/>	
	
</body>
</html>
