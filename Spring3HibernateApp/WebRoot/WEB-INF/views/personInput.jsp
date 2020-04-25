<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H2> Get Form</H2> <br/>
<form action="./person" method="get">
Enter name: <input type="text" name="name"/><br/><br/>
Enter age: <input type="text" name="age"/><br/><br/>
<input type="submit" name="submit" value="submit"/>
</form>

<br/><br/>


<H2> POST Form</H2> <br/>
<form action="./person" method="post">
Enter name: <input type="text" name="name"/><br/><br/>
Enter age: <input type="text" name="age"/><br/><br/>
<input type="submit" name="submit" value="submit"/>
</form>

</body>
</html>