<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page isErrorPage="true" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Login</title>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
						crossorigin="anonymous">
						<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
				</head>

				<body class="bg-dark p-2 text-white " style="margin-left:20vw; margin-right: 20vw;">


<div class="d-flex justify-content-between align-items-center">
						<div>
							<h1 class="mx-auto text-center display-4 text-white">${title}</h1>
						</div>
						<div>
							<div>
								<a class="me-3" href="/logout">Logout</a>
							</div>
							<div>
								<a href="/books">Back to the shelves</a>
							</div>
						</div>
					</div>
                   <br>

									<form:form action="/books/create" modelAttribute="book" method="post">
										<input type="hidden" name="id" value="${id}">
										<div class="form-control form-control-lg bg-light">
											<form:label path="bookName">Title:</form:label>
											<form:input path="bookName" class="form-control form-control-lg"  placeholder="Enter Title"  /><br>
											<form:errors path="bookName" class="text-danger" />
                                             <br>
											<form:label path="authorName">Author:</form:label>
											<form:input path="authorName" class="form-control form-control-lg" placeholder="Enter Author" /><br>
											<form:errors path="authorName" class="text-danger" />
											 <br>
											<form:label path="myThoughts">My Thoughts</form:label>
											<form:textarea path="myThoughts" class="form-control form-control-lg" type="Text" placeholder="Enter Thoughts"  /><br>
											<form:errors path="myThoughts" class="text-danger" />

										<br>
										<div>
											<input class="form-control form-control-lg btn btn-primary btn-large btn-block" value="Save" type="submit" />
										</div>
									</form:form>

				</body>

				</html>