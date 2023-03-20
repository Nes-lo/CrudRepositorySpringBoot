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
					<div class="container">
						<div class="row">
							<div class="col-9">
								<h1 class="display-4 fw-bold">${book.bookName}</h1>								
							</div>
							<div class="col-3 text-end">
								<a href="/books" class="nav-link">Back to the shelves</a>
							</div>
						</div>
						
							<div class="col-8">
								<h5 class="text-danger d-inline me-2"> ${book.user.userName} </h5>
								<h5 class="d-inline me-2">read</h5>
								<h5 class="text-warning d-inline me-2">${book.bookName}</h5>
								<h5 class="d-inline me-2">by</h5>
								<h5 class="text-success d-inline me-2">${book.authorName}</h5>
								<p>Here are ${book.user.userName}'s thoughts:</p>
							</div>							
							<div class="border-bottom border-2 col-9"></div>
                            <p class="col-8">${book.myThoughts}</p>
							<div class="border-bottom border-2 col-9"></div>						
							<div class="col-12 text-center mt-3">
								<a href="/books/${book.id}/edit" class="btn btn-warning nav-link d-inline me-2 fw-bold text-white">edit</a>
								<form class="d-inline me-2" action="/books/${book.id}/delete" method="post">
									<input type="hidden" name="_method" value="delete" />
									<button type="submit" class="btn btn-danger nav-link d-inline me-2 fw-bold text-white">delete</button>
								</form>							
							</div>						
					</div>

				</body>

				</html>