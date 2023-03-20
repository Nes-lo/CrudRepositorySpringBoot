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

                        <h2><a href="/">Dashboard</a></h2>

                        <h1>Project: Employee Relations Lazertag</h1>
                        <h6>Project Lead: ${user.getUserName()}</h6>

                        <form:form action="/projects/task/new" method="post" modelAttribute="task">
                            <input type="hidden" name="projectTasks" value="${project.id}">
                            <div>
                                <form:label path="taskName" class="form-label">Add a task ticket for this team:
                                </form:label><br>
                                <form:textarea rows="8" class="form-control form-control-lg" path="taskName" />
                                <form:errors path="taskName" class="text-danger" />
                            </div>
                            <div>
                                <input class="form-control form-control-lg btn btn-primary btn-large btn-block"
                                    value="Save" type="submit" />
                            </div>
                        </form:form>
                        <hr>
                        <c:forEach var="task" items="${tasks}">
                            <h4>Added by <c:out value="${task.member.userName}"></c:out> at
                                <fmt:formatDate value="${task.createdAt}" pattern="h:mm a MMMM dd" />:
                            </h4>
                            <p>
                                <c:out value="${task.taskName}"></c:out>
                            </p>
                        </c:forEach>
                    </body>

                    </html>