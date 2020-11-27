   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<jsp:include page="header.jsp"/> <br/> <br/>
      
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
<th>Salary</th>
</tr>  
   
   <c:forEach var="emp" items="${emps}">   
	   <tr>  
	   <td>${emp.id}</td>  
	   <td>${emp.name}</td>
	   <td>${emp.lName}</td>
	   <td>${emp.age}</td>   
	   <td>${emp.salary}</td>  
	    <td>
	    <a href="./showEditEmp?empId=${emp.id}">Edit</a></td>
	   </tr>  
   </c:forEach>  
   
   </table>  