<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Page!</title>
</head>
<body>
	<h1>WELCOME TO COURSE LIST PAGE!</h1>
</body>
<table>
	<thead>
		<tr>
			<th>Course ID</th>
			<th>Course Code</th>
			<th>Course Title</th>
			<th>Course Credit</th>
		</tr>
	</thead>

	<tbody>
<%-- 		<c:if test="${not empty courses}"> --%>
<%-- 			<c:forEach var="course" items="${courses}"> --%>
<!-- 				<tr> -->
<%-- 					<td>${course.getCourseId()}</td> --%>
<%-- 					<td>${course.getCourseCode()}</td> --%>
<%-- 					<td>${course.getCourseTitle()}</td> --%>
<%-- 					<td>${course.getCredit()}</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>

<%-- 		</c:if> --%>
	</tbody>
</table>
<a href="<c:url value="/"/>">Index Page</a>
</html>