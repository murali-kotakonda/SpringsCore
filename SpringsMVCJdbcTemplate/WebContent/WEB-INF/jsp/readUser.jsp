<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search Employee By Id</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

  <jsp:include page="header.jsp"></jsp:include>  
<h2>Search Employee By Id</h2>

${messageInfo }
<br/>
<form action="getEmpById" >
Enter user id to search : 
 <input type="text" name="id" id="" >
<br />
<input type="submit" name="Search" value="Search">
</form>

</body>
</html>