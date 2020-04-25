<%@page import="com.mnp.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <br/><br/>
	Registration form 
	<form action="./register" method="post">

	Enter name :
	 <input type="text" name="uName"/>
	<br />
	
	Enter age :
	 <input type="text" name="age"/>
	 <br />
	
	 Enter sal :
	 <input type="text" name="sal"/>
	 <br />
	<input type="submit" name="submit" value="submit" />
 	</form>
 	
 
 </body>
</html>