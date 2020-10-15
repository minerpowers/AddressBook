/********************************
 * author: 		Ben Miner
 * class:		CIS 171 Java II
 * date:		October 2020
 * project:		AddressBook
 * file:		Servlet_ViewContactList
 * called from:	index.html
 * goes to:		view_contacts.jsp - if data is found
 * 				index.html - if no data is found
 ********************************/
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_ViewContactList
 */
@WebServlet("/servlet_ViewContactList")
public class Servlet_ViewContactList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_ViewContactList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Helper_Contacts contactHelper = new Helper_Contacts();
		request.setAttribute("allContacts", contactHelper.getAllContacts());
		String path = "/view_contacts.jsp";
		if(contactHelper.getAllContacts().isEmpty()) {
			//path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
