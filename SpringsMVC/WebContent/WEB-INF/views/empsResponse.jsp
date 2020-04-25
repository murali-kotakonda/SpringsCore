<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message }
<br/>

<ul>names are :
<c:forEach items="${names}" var="name">
 <li>${name}</li>
 </c:forEach>
</ul> 
<br/>


Employees are: <br/>
<table border="1" cellpadding="10">
  <tr >
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age</th>
    <th>salary</th>
  </tr>
  
<c:forEach items="${emps}" var="emp">
	<tr>
	<td>${emp.id}   </td>
	<td>${emp.age}  </td>
	<td>${emp.name} </td>
	<td>${emp.lName} </td>
	<td>${emp.salary} </td>
	</tr>
</c:forEach>
  
</table>


</body>
</html>