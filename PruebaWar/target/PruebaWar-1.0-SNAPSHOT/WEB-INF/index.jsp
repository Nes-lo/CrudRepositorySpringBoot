<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page isErrorPage="true" %>
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

				<body class="bg-dark p-2 text-white " style="margin-left:20vw; margin-top:5vw; margin-right: 20vw;">

					<div class="d-flex justify-content-between align-items-center">
						<div>
							<h1 class="mx-auto">Welcome,
								<c:out value="${user.getUserName()}" />!
							</h1>
							<h6 class="mx-auto">Books from everyone is shelves:</h6>
						</div>
						<div>
							<div>
								<a class="me-3" href="/logout">Logout</a>
							</div>
							<div>
								<a href="/books/new">+ Add a to my shelf!</a>
							</div>
						</div>
					</div>
                   <br>
					<table class="table table-striped table-bordered text-white" style="color:white;">
						<thead>
							<tr>
								<th>ID</th>
								<th>Title</th>
								<th>Author Name</th>
								<th>Posted By</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books}">
								<tr>
									<td class="text-white">
										<c:out value="${book.id}" />
									</td>
									<td class="text-white"><a href="/books/${book.id}">
											<c:out value="${book.bookName}" />
										</a></td>
									<td class="text-white">
										<c:out value="${book.authorName}" />
									</td>
									<td class="text-white">
											<c:out value="${book.user.userName}" />
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</body>

				</html>