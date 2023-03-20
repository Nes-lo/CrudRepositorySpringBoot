<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<script
							src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
					</head>

					<body class="bg-dark p-2 text-white " style="margin-left:20vw; margin-right: 20vw;">
						
						<h1 class="mx-auto text-center">Project Manager</h1>
						<h6 class="mx-auto">Welcome,${user.getUserName()}!</h6>
						<p><a href="/logout">Log Out</a></p>
						<h4>All Projects</h4>
						<p><a href="/projects/new">Add Project</a></p>

						<table class="table table-striped table-bordered text-white" style="color:white;">
							<thead>
								<tr>
									<th>Project</th>
									<th>Team Lead</th>
									<th>Due Date</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="project" items="${unassignedProjects}">
									<tr>
										<c:if test="${project.manager.id!=user.id}">
											<td class="text-white"><a
													href="/projects/${project.id}">${project.projectName}</a></td>
											<td class="text-white">
												<c:out value="${project.manager.userName}"></c:out>
											</td>
											<td class="text-white">
												<fmt:formatDate value="${project.dueDate}" pattern="MMMM dd, yyyy" />
											</td>
											<td class="text-white"><a href="/projects/join/${project.id}">Join Team</a>
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<hr>
						<h4>Your Projects</h4>
						<table class="table table-striped table-bordered text-white" style="color:white;">
							<thead>
								<tr>
									<th>Project</th>
									<th>Team Lead</th>
									<th>Due Date</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="project" items="${assignedProjects}">
									<tr>										
										<td class="text-white"><a
											href="/projects/${project.id}">${project.projectName}</a></td>
										<td class="text-white">
											<c:out value="${project.manager.userName}"></c:out>
										</td>
										<td class="text-white">
											<fmt:formatDate value="${project.dueDate}" pattern="MMMM dd, yyyy" />
										</td>
										<c:if test="${project.manager.id==user.id}">
											<td><a href="/projects/edit/${project.id}">Edit Project</a></td>
										</c:if>
										<c:if test="${project.manager.id!=user.id}">
											<td><a href="/projects/leave/${project.id}">Leave Team</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</body>

					</html>