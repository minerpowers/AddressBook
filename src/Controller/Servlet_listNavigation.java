package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Contacts;

/**
 * Servlet implementation class Servlet_listNavigation
 */
@WebServlet("/servlet_listNavigation")
public class Servlet_listNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_listNavigation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Helper_Contacts contactHelper = new Helper_Contacts();
		String action = request.getParameter("doThisToContact");
		String path = "/servlet_ViewContactList";
		if (action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Contacts toDelete = contactHelper.searchById(tempId);
				contactHelper.deleteContact(toDelete);
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
		}else if(action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Contacts toUpdate = contactHelper.searchById(tempId);
				request.setAttribute("toUpdate", toUpdate);
				path = "/update_contact.jsp";
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
		}else if(action.equals("add")) {
			path = "add_contact.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
