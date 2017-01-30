/**
 * <b>UserListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista degli utenti.
 * 
 */
package it.clever.testapp.tomcat.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.clever.testapp.tomcat.business.model.UserVO;
import it.clever.testapp.tomcat.business.services.IUserSevice;
import it.clever.testapp.tomcat.web.core.BusinessDelegate;


/**
 * 
 * @author 2clever.it
 *
 */
public class UserListServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		BusinessDelegate bd = new BusinessDelegate();
		IUserSevice userService = bd.retrieveUserService();
		
		try {
			List<UserVO> userList = userService.listUsers();
			request.setAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_USERLIST, userList);
			request.setAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION,
					IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_USERLIST);

			getServletContext().getRequestDispatcher("/buildResponse").forward(request, response);
			
		} catch (Exception e) {
			
		}
	}
}
