<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>
	<div>
		<form action="servlet_listNavigation" method="post">
			<table>
				<c:forEach items="${requestScope.allContacts}" var="currentContact">
				<tr>
					<td><input type="radio" name="id" value="${currentContact.id}">${currentContact.id}</td>
					<td>${currentContact.firstName}</td>
					<td>${currentContact.lastName}</td>
				</tr>
				</c:forEach>
			</table>
			<div class="buttons">
				<button value ="edit" name="doThisToContact">Edit</button>
				<button value ="delete" name="doThisToContact">Delete</button>
				<button value ="add" name="doThisToContact">Add</button>
			</div>
		</form>
	</div>
</body>
</html>