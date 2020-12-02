<%-- <%@page import="com.mnp.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
 Hi!!!!!!!!!!!!!!!!

<%
String id = request.getSession().getId();
Person person = null;

if(session.getAttribute(id)!=null){
	person = (Person)session.getAttribute(id);
%>
	<%= person.getAge()%>
	<%=person.getCity() %>
	<%=person.getName() %>
<%
} else {%>
	
	Session is closed please go back to login page <a href="login.jsp">Click </a>
	
<%}
%>

</body>
</html> --%>