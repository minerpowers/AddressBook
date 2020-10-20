<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Contact View</title>
</head>
<body>
	<table>
		<tr><th>${toView.firstName} ${toView.lastName}</th></tr>
		<tr>
			<td colspan="3">${toView.streetAddress}</td>
			<td>${toView.zipCode.city}, </td>
			<td>${toView.zipCode.state}</td>
		</tr>
		<c:forEach items="${requestScope.phone}" var="currentPhone">
		<tr>
			<td colspan="3">${currentPhone.phoneNum}</td>
			<td>${currentPhone.phoneType}</td>
		</tr>
		</c:forEach>
		<c:forEach items="${requestScope.email}" var="currentEmail">
		<tr>
			<td colspan="3">${currentEmail.emailAddress}</td>
			<td>${currentEmail.emailType}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="links">
			<a href="index.html">Home</a>
		</div>
</body>
</html>