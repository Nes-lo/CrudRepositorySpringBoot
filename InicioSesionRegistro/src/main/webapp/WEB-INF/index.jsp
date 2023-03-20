<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page isErrorPage="true"%>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>index</title>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
						crossorigin="anonymous">
				</head>

				<body class="bg-dark p-2 text-white " style="margin:20vw;">

	
	     <h1 class="mx-auto text-center">Welcome, <c:out value="${user.getUserName()}" />!</h1>

					
					<h6 class="mx-auto text-center">This is your dashboard. Nothing to see here yet.</h6>
                    <p><a class="nav-link - mx-auto text-center"  href="/logout"">Logout</a></p>
				</body>

				</html>