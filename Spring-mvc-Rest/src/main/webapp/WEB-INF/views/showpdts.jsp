<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  

 <h2>Show All Products</h2>
<table border="2" width="70%" cellpadding="2">  
<tr>
<th>ArticleId</th>
<th>Title</th>
<th>Category</th>

</tr>  
   
   <c:forEach var="p" items="${pdts}">   
	   <tr>  
	   <td>${p.articleId}</td>  
	   <td>${p.title}</td>  
	   <td>${p.category}</td>  
	   
	   
   </c:forEach>  
   
   </table>  
  