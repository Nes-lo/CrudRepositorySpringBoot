
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
					<h1 class="mx-auto text-center">Welcome</h1>
					<h6 class="mx-auto text-center">Join our growing community</h6>
					<table class="table table-striped table-bordered">
						<tbody>
							<tr>
								<td>
									<div class="form-control-lg bg-dark p-2">
										<div class="container">
											<c:if test="${not empty success}">
												<div class="alert alert-success alert-dismissible fade show"
													role="alert" data-bs-autohide="true">
													<button type="button" class="btn-close" data-bs-dismiss="alert"
														aria-label="Close"></button>
													<strong>
														<c:out value="${success}" />
													</strong>
												</div>
											</c:if>
										</div>
										<h1 class="mx-auto text-center display-4 text-white">Register</h1>
										<form:form action="/register" modelAttribute="newUser" method="post">
											<div class="form-control form-control-lg bg-light">
												<form:label path="userName">User Name:</form:label>
												<form:input path="userName" class="form-control form-control-lg"
													placeholder="Enter User Name" /><br>
												<form:errors path="userName" class="text-danger" />
												<br>
												<form:label path="email">Email:</form:label>
												<form:input path="email" class="form-control form-control-lg"
													type="email" placeholder="Enter Email" /><br>
												<form:errors path="email" class="text-danger" />
												<br>
												<form:label path="birthDate">Select date of birth:</form:label>
												<form:input path="birthDate" class="form-control form-control-lg"
													type="date" /><br>
												<form:errors path="birthDate" class="text-danger" />
												<br>
												<form:label path="password">Password:</form:label>
												<form:input path="password" class="form-control form-control-lg"
													type="password" placeholder="Enter Password" /><br>
												<form:errors path="password" class="text-danger" />
												<br>
												<form:label path="confirmPW">Confirm PW:</form:label>
												<form:input path="confirmPW" class="form-control form-control-lg"
													type="password" placeholder="Confirm Password" /><br>
												<form:errors path="confirmPW" class="text-danger" />
												<br>
												<div>
													<input
														class="form-control form-control-lg btn btn-primary btn-large btn-block"
														value="Register" type="submit" />
												</div>
										</form:form>
									</div>
								</td>
								<td class="content-center">
									<div class="form-control-lg  bg-dark p-2" style="margin-top:5vw;">
										<h1 class="mx-auto text-center display-4 text-white">Log In</h1>
										<form:form action="/login" modelAttribute="newLogin" method="post">

											<div class="form-control form-control-lg bg-light">
												<form:label path="email" class="form-label">Email:</form:label>
												<form:input path="email" class="form-control form-control-lg"
													type="email" placeholder="Enter Email" /><br>
												<form:errors path="email" class="text-danger" />
												<br>
												<form:label path="password">Password:</form:label>
												<form:input path="password" class="form-control form-control-lg"
													type="password" placeholder="Enter Password" /><br>
												<form:errors path="password" class="text-danger" />
											</div>
											<br>
											<div>
												<input
													class="form-control form-control-lg btn btn-primary btn-large btn-block"
													value="Log In" type="submit" />
											</div>
										</form:form>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</body>

				</html>