<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 	file:			update_contact.jsp
		author: 		Ben Miner
 		course:			CIS 171 Java II
 		date:			October 2020
 		project:		AddressBook
 		called from:	servlet_listNavigation
 		goes to:		servlet_UpdateContact.java (Submit button)
 	 					index.html	(home link)	
-->
	<meta charset="UTF-8">
	<title>Update Contact</title>
</head>
<body>
	<div class="formContaner">
		<form action="servlet_UpdateContact" method="post">
			<h4>Add New Contact</h4>
			<input type="hidden" name="id" value="${toUpdate.id}">
			<label>First Name</label><input type="text" name="firstName" value="${toUpdate.firstName}">
			<label>Last Name</label><input type="text" name="lastName" value="${toUpdate.lastName}"><br><!-- Break -->
			<label>Street</label><input type="text" name="street"	value="${toUpdate.streetAddress}"><br><!-- Break -->
			<label>City</label><input type="text" name="city" value="${toUpdate.zipCode.city }">
			<select name="state" size="5">
				<option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AR">AR</option>	
				<option value="AZ">AZ</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DC">DC</option>
				<option value="DE">DE</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="IA">IA</option>	
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="MA">MA</option>
				<option value="MD">MD</option>
				<option value="ME">ME</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MO">MO</option>	
				<option value="MS">MS</option>
				<option value="MT">MT</option>
				<option value="NC">NC</option>	
				<option value="NE">NE</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>			
				<option value="NV">NV</option>
				<option value="NY">NY</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VT">VT</option>
				<option value="VA">VA</option>
				<option value="WA">WA</option>
				<option value="WI">WI</option>	
				<option value="WV">WV</option>
				<option value="WY">WY</option>
			</select>
			<label>Zip Code</label><input type="number" name="zip" value="${toUpdate.zipCode.zipCode}"><br><!-- Break -->
			<c:forEach items="${requestScope.allPhone}" var="currentPhone">
			<label>Phone</label><input type="tel" name="phone" value="${currentPhone.phoneNum}" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
				<input type="radio" name="phoneType" value="Cell"><label>Cell</label>
				<input type="radio" name="phoneType" value="Work"><label>Work</label>
				<input type="radio" name="phoneType" value="Home"><label>Home</label><br><!-- Break -->
			</c:forEach>
			<c:forEach items="${requestScope.allEmail}" var="currentEmail">
			<label>email</label><input type="email" name="email" value="${currentEmail.emailAddress}">
				<input type="radio" name="emailType" value="Work"><label>Work</label>
				<input type="radio" name="emailType" value="Personal"><label>Personal</label><br><!-- Break -->
			</c:forEach>
			<button>Submit</button>
		</form>	
		<div>
			<a href="index.html">Home</a>
		</div>
	</div>
</body>
</html>