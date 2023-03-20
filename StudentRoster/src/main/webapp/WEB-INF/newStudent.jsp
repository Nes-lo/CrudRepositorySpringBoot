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
	<form:form action="/students/new" modelAttribute="student" method="post">
		<div  class="mx-auto text-center">
			<form:label path="name">Name:</form:label>
			<form:input path="name" style="width:250px;" /><br>
			<form:errors path="name" class="text-danger" />
		</div>
		<br>
		<div class="mx-auto text-center">
        			<form:select path="bedroom" class="input">
        			    <c:forEach var="bedroom" items="${bedrooms}">
        			    	<option value="${bedroom.id}">${bedroom.name}</option>
        			    </c:forEach>
        			</form:select>
        		</div>
		<br>
		<div  class="mx-auto text-center">
			<input value="Add Student" type="submit"/>
		</div>
	</form:form>

</body>
</html>