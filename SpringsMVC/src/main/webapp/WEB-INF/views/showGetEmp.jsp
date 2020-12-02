<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

${messageInfo }
<br />

 <form action="getEmpById" method="post">
Enter user Name to serach :  
<input type="text" name="id" id="" >
<br />
<input type="submit" name="Search" value="Search">
</form>
</body>

</html>