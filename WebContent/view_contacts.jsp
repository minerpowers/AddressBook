<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- file:			view_contacts.jsp
	 author: 		Ben Miner
 	 course:		CIS 171 Java II
 	 date:			October 2020
 	 project:		AddressBook
 	 called from:	Servlet_ViewContacts.java
 	 goes to:		Servlet_listNavigation.java (Submit button)
 	 				index.html	(home link)	
-->
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>
	<div>
		<form action="servlet_listNavigation" method="post">
			<table>
				<c:forEach items="${requestScope.allContacts}" var="currentContact">
				<tr>
					<td><input type="radio" name="id" value="${currentContact.id}"></td>
					<th>${currentContact.firstName} ${currentContact.lastName}</th>
				</tr>
				</c:forEach>
			</table>
			<div class="buttons">
				<button value ="edit" name="doThisToContact">Edit</button>
				<button value ="delete" name="doThisToContact">Delete</button>
				<button value ="add" name="doThisToContact">Add</button>
				<button value ="view" name="doThisToContact">View</button>
			</div>
		</form>
		<div class="links">
			<a href="index.html">Home</a>
		</div>
	</div>
</body>
</html>