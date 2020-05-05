<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/><br/>
	<h2>Registration Form</h2>
	
 
<font color='red'>${msg}</font>
<form action="./registerform" method="post">
	<table>
			    <tr>
			        <td>Employee ID:</td>
			        <td><input type="text" name="ID" value = "${form.id}"></td>
			    </tr>
			    
			    <tr>
			        <td>First Name:</td>
			        <td><input type="text" name="firstName" value = "${form.firstName}"></td>
			    </tr>
			    
			    <tr>
			        <td>Last Name:</td>
			        <td><input type="text" name="lastName" value = "${form.lastName}"></td>
			    </tr>
			    
			    <tr>
			        <td>Password</td>
			        <td><input type="password" name="password"></td>
			    </tr>
			    
			    <tr>
			        <td>Age</td>
			        <td><input type="text" name="age" value = "${form.age}"></td>
			    </tr>
			    
			  <tr>
			      <td colspan="2"><input type="submit" value="Register"/></td>
		      </tr>
			</table>
</form>





<BR>
<B> <H1> Form to show multi errors   </H1></B>
<br>
		
<c:forEach items="${msgs}" var="msg1">
 <li>${msg1}</li>
 </c:forEach>
<form action="./registerform1" method="post">
	<table>
			    <tr>
			        <td>Employee ID:</td>
			        <td><input type="text" name="ID" value = "${form1.id}"></td>
			    </tr>
			    
			    <tr>
			        <td>First Name:</td>
			        <td><input type="text" name="firstName" value = "${form1.firstName}"></td>
			    </tr>
			    
			    <tr>
			        <td>Last Name:</td>
			        <td><input type="text" name="lastName" value = "${form1.lastName}"></td>
			    </tr>
			    
			    <tr>
			        <td>Password</td>
			        <td><input type="password" name="password"></td>
			    </tr>
			    
			    <tr>
			        <td>Age</td>
			        <td><input type="text" name="age" value = "${form1.age}"></td>
			    </tr>
			    
			  <tr>
			      <td colspan="2"><input type="submit" value="Register"/></td>
		      </tr>
			</table>
</form>

</body>
</html>
