<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<br/>
Id == ${emp.id}<br/>
Age == ${emp.age}<br/>
Name == ${emp.name}<br/>
Last Name == ${emp.lName}<br/>
Salary == ${emp.salary}<br/>

<c:if test="${empty emp.address}">
    address is not available
</c:if>
<c:if test="${not empty emp.address}">
    address is available
</c:if>

<c:choose>
    <c:when test="${empty emp.address}">
        address is not available
    </c:when>
    <c:otherwise>
        ${emp.address.hno }<br/>
		${emp.address.pinCode }<br/>
		${emp.address.city }<br/>
		${emp.address.state }<br/>
		${emp.address.country }<br/>
    </c:otherwise>
</c:choose>
</body>
</html>