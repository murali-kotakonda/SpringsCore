<%@page import="com.mnp.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<% 
String msgInfo  =(String) request.getAttribute("messageInfo");
Person person  = (Person)request.getAttribute("person");;

  %>  
    <jsp:include page="header.jsp"></jsp:include>
    
      <br/> <br/> <br/>
    
  <%=msgInfo!=null? msgInfo :"" %>
    
user Details for   ::  <%= person.getName()  %> 
<br />

Age:   <%= person.getAge()  %> 
<br />


City:   <%= person.getCity()  %> 
<br />

UserType:   <%= person.getUserType() %> 
<br />

Description:   <%= person.getDesc() %> 
<br />

    
    