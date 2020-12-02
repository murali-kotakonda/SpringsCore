<%-- <%@page import="com.mnp.dto.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

 <jsp:include page="header.jsp"></jsp:include>


<% 
List<Person> allUsers = (List)request.getAttribute("allUsers");
%>
<br/> <br/>

<br /> <br/>


		<table border="1">
            <tr>
                <th>User Name</th>
                <th>Age</th>
                <th>City</th>
                <th>Action</th>
            </tr>
            <%for (Person p : allUsers) {%>
                <tr>
                    <td><%= p.getName() %></td>
                    <td><%= p.getAge() %></td>
                    <td><%= p.getCity()%></td>
                    <td><a href="./UpdateUser?ProfileId=<%= p.getName() %>" 
                    name="UpdateUser" value="UpdateUser">Edit</a>
                    </td>
                </tr>
             <%} %>
        </table>


</body>
</html>

 --%>