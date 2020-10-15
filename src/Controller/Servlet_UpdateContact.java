/********************************
 * author: 		Ben Miner
 * class:		CIS 171 Java II
 * date:		October 2020
 * project:		AddressBook
 * file:		Servlet_listNavigation.java
 * called from:	update_contact.jsp - processes form
 * goes to:		servlet_ViewContactList.java - if delete was selected
 ********************************/
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
 * Servlet implementation class Servlet_UpdateContact
 */
@WebServlet("/servlet_UpdateContact")
public class Servlet_UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_UpdateContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * Entity Helper instances
		 */
		Helper_Contacts contactHelper = new Helper_Contacts();
		Helper_PhoneNumber phoneHelper = new Helper_PhoneNumber();
		Helper_Emails emailHelper = new Helper_Emails();
		Helper_ZipCode zipHelper = new Helper_ZipCode();
		/**
		 * create strings from input and update the contact object
		 */
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Contacts toUpdate = contactHelper.searchById(tempId);
		String firstName = request.getParameter("firstName");
		toUpdate.setFirstName(firstName);
		String lastName = request.getParameter("lastName");
		toUpdate.setLastName(lastName);
		String street = request.getParameter("street");
		toUpdate.setStreetAddress(street);
		/**
		 * update phone data
		 */
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();
		PhoneNumber phoneUpdate = phoneHelper.getPhoneById(tempId);
		String phone = request.getParameter("phone");
		phoneUpdate.setPhoneNum(phone);
		String phonetype = request.getParameter("phoneType");
		phoneUpdate.setPhoneType(phonetype);
		phoneList.add(phoneUpdate);
		toUpdate.setPhoneList(phoneList);
		List<Emails> emailList = new ArrayList<Emails>();
		Emails emailUpdate = emailHelper.searchById(tempId);
		String email = request.getParameter("email");
		emailUpdate.setEmailAddress(email);
		String emailType = request.getParameter("emailType");
		emailUpdate.setEmailType(emailType);
		emailList.add(emailUpdate);
		toUpdate.setEmailList(emailList);
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
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
		toUpdate.setZipCode(addZip);
		contactHelper.updateContact(toUpdate);
		
		getServletContext().getRequestDispatcher("/servlet_ViewContactList").forward(request, response);
	}

}
