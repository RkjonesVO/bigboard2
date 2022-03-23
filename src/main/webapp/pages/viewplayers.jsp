<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>
<body>
<h1 align="center">Ryan's Big Board of Players</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>
<a  href="/bigboard2/addplayer"><h2>Add New Player</h2></a>

</th>


</tr>
</table>

   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Position</th><th>Name</th>
<th>Team</th><th>Points</th>
</tr>  

   <c:forEach var="player" items="${list}"> 
   <tr>   
   <td>${player.position}</td> 
   <td>${player.name}</td>  
   <td>${player.team}</td> 
   <td>${player.points}</td>  
   <td><a href="/bigboard2/edit/${player.id}">Edit</a></td>  
   <td><a href="/bigboard2/delete/${player.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>