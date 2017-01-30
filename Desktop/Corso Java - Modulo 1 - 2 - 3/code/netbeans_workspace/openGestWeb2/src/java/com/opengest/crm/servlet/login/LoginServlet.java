/**
 * <b>LoginServlet.java</b>
 * 
 * <br/>
 *
 * robgion
 * www.2clever.it
 * 
 * 19 nov 2016
 * For further information please write to info@2clever.it
 * 
 * Classe Servlet per la gestione del login applicativo.
 * 
 */
package com.opengest.crm.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opengest.core.business.services.IUserSevice;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_LOGIN)) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			BusinessDelegate bd = new BusinessDelegate();
			IUserSevice userService = bd.retrieveUserService();
			
			try {
				if(userService.authorization(username, password)) {
					request.getSession(true).setAttribute(IAppCostants.SESSION_PARAM_LOGGED_USER, username);
					getServletContext().getRequestDispatcher("/WEB-INF/pages/login/welcome.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Login errato");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "Errore durante la procedura di login.\n " +
						"Riprovare pi� tardi.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_LOGOUT)) {
			HttpSession currentSession = request.getSession(false);
			if(currentSession != null 
					&& currentSession.getAttribute(IAppCostants.SESSION_PARAM_LOGGED_USER) != null ) {
				currentSession.removeAttribute(IAppCostants.SESSION_PARAM_LOGGED_USER);
				currentSession.invalidate();
			}
			getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_INIT_LOGIN)) {
			getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
		}
		
	}

	
}
