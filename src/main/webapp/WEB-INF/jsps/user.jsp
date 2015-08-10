<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Users Page!</h1>
	
	<table>
		<thead>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>User Email</th>
				<th>User Password</th>
			</tr>
		</thead>
		
		<tbody>
			<c:if test="${not empty users}">
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.getUserId())}</td>
						<td>${user.getUserName()}</td>
						<td>${user.getUserEmail()}</td>
						<td>${user.getUserPassword()}</td>
					</tr>
				</c:forEach>

			</c:if>
		</tbody>
	</table>
	
	<a href="<c:url value="/"/>">Index Page</a>
</body>
</html>