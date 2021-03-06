
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
			<select name="state" size="10">
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
			<label>Zip Code</label><input type="number" name="zip"><br><!-- Break -->
			<label>Phone</label><input type="tel" name="phone" placeholder="555-555-5555" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
				<input type="radio" name="phoneType" value="Cell"><label>Cell</label>
				<input type="radio" name="phoneType" value="Work"><label>Work</label>
				<input type="radio" name="phoneType" value="Home"><label>Home</label><br><!-- Break -->
			<label>email</label><input type="email" name="email">
				<input type="radio" name="emailType" value="Work"><label>Work</label>
				<input type="radio" name="emailType" value="Personal"><label>Personal</label><br><!-- Break -->
			<button>Submit</button>
		</form>	
		<div>
			<a href="index.html">Home</a>
		</div>
	</div>
</body>
</html>