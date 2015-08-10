<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"/> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello Page</title>
</head>
<body>
	<h1>MVC forwarded index page!</h1>
</body>

<%-- <a href="<c:url value="/course"/>"> Course Page </a> --%>
<br></br>
<a href="<c:url value="/showusers"/>">Show Users List</a>
<br></br>
<a href="<c:url value="/newuser" />"> Create New User</a>
<br></br>
<a href="<c:url value="/newrole" />"> Create New User Type</a>


</html>