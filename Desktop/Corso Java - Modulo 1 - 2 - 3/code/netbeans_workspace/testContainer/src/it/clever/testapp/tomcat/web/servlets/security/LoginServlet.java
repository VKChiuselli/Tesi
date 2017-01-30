/**
 *
 * robgion
 * www.2clever.it
 * 
 * 19 nov 2016
 * For further information please write to info@2clever.it
 * 
 * Servlet implementation class LoginServlet
 */
package it.clever.testapp.tomcat.web.servlets.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.clever.testapp.tomcat.business.services.IUserSevice;
import it.clever.testapp.tomcat.web.core.BusinessDelegate;
import it.clever.testapp.tomcat.web.servlets.IWebParameters;
import it.clever.testapp.tomcat.web.servlets.OutResponsBuilderServlet;

/**
 *
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		performLogin(request, response);
	}

	private void performLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		BusinessDelegate bd = new BusinessDelegate();
		IUserSevice userSevice = bd.retrieveUserService();
		try {
			boolean auth = userSevice.authorization(username, password);
			if (auth) {
				// Utente autenticato.
				request.setAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION,
						IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_LOGIN_SUCCESS);
				
				HttpSession session = request.getSession();
				session.setAttribute("userInSession",username);
				
			} else {
				// Utente non autenticato.
				request.setAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION,
						IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_LOGIN_FAIL);

			}
			getServletContext().getRequestDispatcher("/buildResponse").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
