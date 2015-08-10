<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
</head>
<body>


	<form method="post"
		action="${pageContext.request.contextPath}/createuser">

		<input name="userId" id=userId type="hidden" value="" /> <label>Username</label>
		<input name="userName" id="userName" type="text" /> <label>Password</label>
		<input name="password" id="password" type="password" /> <label>Email</label>
		<input name="userEmail" id="userEmail" type="text" /> <label>User
			Role</label>
		<!-- 		 <input name="userTypeId" id="userTypeId" type="radio" value="R"/> -->
		
		<select name="roleId" id="roleId">
			<c:if test="${not empty userTypes}">

				<c:forEach var="userType" items="${userTypes}">
					<option value="${userType.getUserTypeId()}">${userType.getUserTypeName()+${userType.getUserDesc()}}</option>
				</c:forEach>
			</c:if>
		</select> <input name="Submit" id="Submit" type="submit" value="Submit" />
	</form>


	<a href="<c:url value="/"/>">Index Page</a>
</body>

</html>