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
								<h1 class="display-4 fw-bold">Project Details</h1>
							</div>
							<div class="col-3 text-end">
								<a href="/projects" class="nav-link">Back to the shelves</a>
							</div>
						</div>
						
							<div class="col-8">
								<h5>Project:      ${project.projectName} </h5>
								<h5>Description:  ${project.projectDescription} </h5>
								<h5>Due Date ${project.dueDate}</h5>
							</div>							

							<div class="col-12 text-center mt-3">								
								<div>
								<c:if test="${project.manager.id==user.id}">
									<h2><a class="btn btn-danger nav-link d-inline me-2 fw-bold text-white"
								 href="/projects/delete/${project.id}">Delete Project</a></h2>								
								</c:if>
							</div>
							</div>	
							<div class="mb-5"></div>
							<div class="d-inline">
								<a href="/projects/${project.id}/tasks"
								 class="btn btn-success nav-link d-inline me-2 fw-bold text-white">See Task</a>
							</div>					
					</div>

				</body>

				</html>