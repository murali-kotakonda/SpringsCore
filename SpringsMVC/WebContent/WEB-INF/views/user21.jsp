<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<html>
<head>
	<title>Add User</title>
</head>
<body>
<font color="red">${errorMsg}</font>

<c:forEach items="${errors}" var="msg1">
 <font color="red">${msg1}</font>
 </c:forEach>
 
 
<h2>Add User21</h2>
<form:form method="post" action="addUser21" commandName="userData">
	<jsp:include page="addUser.jsp"/>
</form:form>
</body>
</html>
