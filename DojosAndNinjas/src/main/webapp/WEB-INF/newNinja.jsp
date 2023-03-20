<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page isErrorPage="true" %>
				<!DOCTYPE html>
				<html>

				<head>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
						crossorigin="anonymous">
					<title>New Ninja</title>
				</head>

				<body style="margin:10vw;">
					<h1 class="text-primary">New Ninja</h1>

					<form:form class="border border-dark border-2 rounded-3" action="/ninja/savedNinja" mode="post"
						modelAttribute="ninja">
                      <div class="mx-auto text-center">
						<form:select path="dojo">
							<form:option value="" label="Seleccione un dojo" />
							<form:options items="${dojos}" itemValue="id" itemLabel="name" />
						</form:select>
						<br>
                       <form:errors path="dojo" class="text-danger" />
                       	</div>
						<div class="mx-auto text-center">
							<form:label path="firstName">First Name:</form:label>
							<br>
							<form:input path="firstName" style="width:250px;" />
							<br>
							<form:errors path="firstName" class="text-danger" />
						</div>
						<div class="mx-auto text-center">
							<form:label path="lastName">Last Name:</form:label>
							<br>
							<form:input path="lastName" style="width:250px;" />
							<br>
							<form:errors path="lastName" class="text-danger" />
						</div>
						<div class="mx-auto text-center">
							<form:label path="age">Age:</form:label>
							<br>
							<form:input path="age" style="width:250px;" />
							<br>
							<form:errors path="age" class="text-danger" />
						</div>
						<div class="mx-auto text-center">
							<input type="submit" value="Create" />
						</div>
					</form:form>
				</body>

				</html>