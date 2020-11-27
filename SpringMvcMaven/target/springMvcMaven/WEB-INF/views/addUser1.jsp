<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add User</title>
</head>
<body>
	<font color="red">${errorMsg}</font>

	<h2>Add User1</h2>
	<form:form method="post" action="addNewUser" commandName="userData">
		<jsp:include page="addUser.jsp"/>
	</form:form>
</body>
</html>
