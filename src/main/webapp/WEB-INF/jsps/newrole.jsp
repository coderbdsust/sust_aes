<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User Role</title>
</head>
<body>

	<form method="post"
		action="${pageContext.request.contextPath}/createrole">

		<input name="userTypeId" id="userTypeId" type="hidden" /> 
		
		<label>Role Name</label>
		
		 <input name=userTypeName id="userTypeName" value="ROLE_" type="text" />
		 
	    <label>User Desc</label>
		<input name="userDesc" id="userDesc" type="text" />
		
		  <input name="Submit" id="Submit" type="submit" value="Submit" />
	</form>


	<a href="<c:url value="/"/>">Index Page</a>
</body>

</html>