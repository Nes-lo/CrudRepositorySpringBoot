<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>New Dojo</title>
</head>
<body style="margin:10vw;">
 <h1 class="text-primary">New Dojo</h1>
 <form:form class="border border-dark border-2 rounded-3"
 		action="/savedDojo" mode="post" modelAttribute="dojo">
 		<div class="mx-auto text-center">
 			<form:label path="name">Name:</form:label>
 			<br>
 			<form:input path="name" style="width:250px;" />
 			<br>
 			<form:errors path="name" class="text-danger" />
 		</div>
 		<div class="mx-auto text-center">
 			<input type="submit" value="Create" />
 		</div>
 	</form:form>
</body>
</html>