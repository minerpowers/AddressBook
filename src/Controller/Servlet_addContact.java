package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Contacts;
import Model.Emails;
import Model.PhoneNumber;
import Model.ZipCode;

/**
 * Servlet implementation class Servlet_addContact
 */
@WebServlet("/servlet_addContact")
public class Servlet_addContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_addContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Helper_Contacts contactHelper = new Helper_Contacts();
		Helper_PhoneNumber phoneHelper = new Helper_PhoneNumber();
		Helper_Emails emailHelper = new Helper_Emails();
		Helper_ZipCode zipHelper = new Helper_ZipCode();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String phone = request.getParameter("phone");
		String phonetype = request.getParameter("phoneType");
		String email = request.getParameter("email");
		String emailType = request.getParameter("emailType");
		// add Zip, city, and state to ZipCode object
		int zipCode = Integer.parseInt(zip);
		ZipCode addZip = new ZipCode();
		// check if zip data exists in database
		if (zipHelper.searchByZip(zipCode) == null) {
			// add ZipCode object to database
			addZip.setZipCode(zipCode);
			addZip.setCity(city);
			addZip.setState(state);
			zipHelper.insertZipCode(addZip);
		} else {
			addZip = zipHelper.searchByZip(zipCode);
		}
		// create Contacts object with first & last name, street, and zip
		Contacts addContact = new Contacts(firstName,lastName, street, addZip);
		// add contact to database
		contactHelper.insertContact(addContact);
		Contacts tempContact = contactHelper.searchByName(addContact);
		// crate list of PhoneNumber
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();
		int tempId = addContact.getId();
		PhoneNumber addPhone1 = new PhoneNumber(tempId, phonetype, phone);
		// add phone number to database
		phoneHelper.insertPhoneNumber(addPhone1);
		// add phone number to list
		phoneList.add(addPhone1);
		List<Emails> emailList = new ArrayList<Emails>();
		Emails addEmail1 = new Emails(tempId, emailType, email);
		// add email to database
		emailHelper.insertEmail(addEmail1);
		// add email to list
		emailList.add(addEmail1);
		// add phone list to contact
		tempContact.setPhoneList(phoneList);
		// add email list to contact
		tempContact.setEmailList(emailList);
		contactHelper.updateContact(addContact);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
