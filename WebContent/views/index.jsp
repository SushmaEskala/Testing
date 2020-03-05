<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>

<title>Placement Management System</title>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>
	<center>
		<h1>Placement Management System</h1>
		<form:form method="POST" action="home" commandName="user">
			<form:errors path="*" cssClass="errorblock" element="div"/>

				<table>
					<tr>
						<td>
							<h2>Login</h2>
						</td>
					</tr>
					<tr>
						<td><form:label path="email">Email</form:label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
						<c:if test="${not empty message }">
							Error:${message}
						</c:if>
					</tr>

					<tr>
						<td><form:label path="password">Password</form:label> 
						<form:input path="password" /> 
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
		
		</form:form>
	</center>
</body>
</html>
