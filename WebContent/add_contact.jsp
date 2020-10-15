

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- add_contact.jsp
	 author: 		Ben Miner
 	 course:		CIS 171 Java II
 	 date:			October 2020
 	 project:		AddressBook
 	 called from:	index.html
 	 goes to:		servlet_addContact.java (Submit button)
 	 				index.html	(home link)	
-->
	<meta charset="UTF-8">
	<title>Add New Contact</title>
</head>
<body>
	<!-- form for entering a new contact -->
	<div class="formContaner">
		<form action="servlet_addContact" method="post">
			<h4>Add New Contact</h4>
			<label>First Name</label><input type="text" name="firstName">
			<label>Last Name</label><input type="text" name="lastName"><br><!-- Break -->
			<label>Street</label><input type="text" name="street"><br><!-- Break -->
			<label>City</label><input type="text" name="city">
			<label>State</label><input type="text" name="state">
			<label>Zip Code</label><input type="number" name="zip"><br><!-- Break -->
			<label>Phone</label><input type="number" name="phone">
				<input type="radio" name="phoneType" value="Cell"><label>Cell</label>
				<input type="radio" name="phoneType" value="Work"><label>Work</label>
				<input type="radio" name="phoneType" value="Home"><label>Home</label><br><!-- Break -->
			<label>email</label><input type="text" name="email">
				<input type="radio" name="emailType" value="Work"><label>Work</label>
				<input type="radio" name="emailType" value="Personal"><label>Personal</label><br><!-- Break -->
			<button>Submit</button>
		</form>	
		<div>
			<a href="index.hrml">Home</a>
		</div>
	</div>
</body>
</html>