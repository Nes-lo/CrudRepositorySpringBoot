<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Dojos y Ninjas</title>
</head>
<body style="margin:10vw;">

<h1 class="text-primary">List Dojos</h1>
<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Name Dojo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${dojos}">
				<tr>
                    <td><a href="/info/${dojo.id}"> <c:out value="${dojo.name}"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>