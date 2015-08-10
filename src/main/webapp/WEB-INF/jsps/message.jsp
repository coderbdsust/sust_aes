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
	<h1>WELCOME TO MESSAGE PAGE!</h1>
	<h2>${message}</h2>
</body>

<a href="<c:url value="/showusers"/>">Users Page</a>
<%-- <a href="<c:url value="/showusers"/>">Users Page</a> --%>
<a href="<c:url value="/"/>">Home Page</a>
</html>