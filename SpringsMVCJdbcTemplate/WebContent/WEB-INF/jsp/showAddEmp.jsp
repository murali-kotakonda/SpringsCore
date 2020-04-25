<%@taglib 
uri="http://www.springframework.org/tags/form" 
prefix="form"%>

<html>
<head>
	<title>Add Employee</title>
<style>
	.error { 
		color: red; font-weight: bold; 
	}
</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<h2>Add Employee</h2>

<form:form method="post" action="AddEmp">
	<table>
	<tr>
		<td><form:label path="name">First Name</form:label></td>
		<td><form:input path="name" /></td> 
		<td><form:errors path="name" cssClass="error" /></td>
	</tr>
	<tr>
		<td><form:label path="lName">Last Name</form:label></td>
		<td><form:input path="lName" /></td>
	</tr>
	<tr>
		<td><form:label path="age">age</form:label></td>
		<td><form:input path="age" /></td>
		<td><form:errors path="age" cssClass="error" /></td>
	</tr>
	<tr>
		<td><form:label path="salary">salary</form:label></td>
		<td><form:input path="salary" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Emp"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>
