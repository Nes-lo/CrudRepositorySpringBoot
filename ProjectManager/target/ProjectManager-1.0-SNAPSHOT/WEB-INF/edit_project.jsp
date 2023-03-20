<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<%@ page isErrorPage="true" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Edit</title>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
						crossorigin="anonymous">
						<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
				</head>

				<body class="bg-dark p-2 text-white " style="margin-left:20vw; margin-right: 20vw;">

					<h2><a href="/">Dashboard</a></h2>

<h1>Edit project</h1>
<form:form action="/projects/edit/{id}" method="post" modelAttribute="project">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="id" value="${id}">
	<table class="table table-striped table-bordered text-white" style="color:white;">
	    <thead>
	    	<tr>
	            <td class="float-left">Project Title:</td>
	            <td class="float-left">
	            	<form:errors path="projectName" class="text-danger"/>
					<form:input class="input" path="projectName"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Project Description:</td>
	            <td class="float-left">
	            	<form:errors path="projectDescription" class="text-danger"/>
					<form:textarea rows="5" class="input" path="projectDescription"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Due Date:</td>
	            <td class="float-left">
	            	<form:errors path="dueDate" class="text-danger"/>
					<form:input path="dueDate" type="date"/>
	            </td>
	        </tr>
	        <tr>
                <td><input  class="btn btn-danger btn-large btn-block" type="button" value="Cancel" onclick="window.location.href='/'"/>
                <td ><input class="btn btn-primary btn-large btn-block" class="button" type="submit" value="Editar"/></td>
                
	        </tr>
	    </thead>
	</table>
</form:form>


				</body>

				</html>