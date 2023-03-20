<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bedrooms</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    						rel="stylesheet"
    						integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    						crossorigin="anonymous">
</head>
<body style="margin:10vw; ">
	 <h1 class= "mx-auto text-center" >New Student</h1>
    	<p><a class="nav-link - mx-auto text-center"  href="/">Dashboard</a></p>
<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Student</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<td><c:out value="${student.name}"/></td>
					<td><a href="/students/remove/${student.id}"><c:out value="Remove"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		</tbody>
	</table>
</body>
</html>
