/**
 * <b>LoginServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione del login applicativo.
 * 
 */
package com.webapp.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opengest.core.business.dto.UserDTO;
import com.opengest.core.business.services.IUserSevice;
import com.webapp.web.BusinessDelegate;
import com.webapp.web.utils.IAppCostants;


/**
 * 
 * @author 2Clever.IT
 *
 */
public class LoginServlet extends HttpServlet {
	
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
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_LOGIN)) {
		
			// Richiesto login.
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			BusinessDelegate bd = new BusinessDelegate();
			IUserSevice userService = bd.retrieveUserService();
			
			try {
				if(userService.authorization(username, password)) {
					UserDTO user = userService.findByUsername(username);
					request.getSession(true).setAttribute("loggedUser", user);
					getServletContext().getRequestDispatcher("/WEB-INF/pages/login/welcome.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Login errato");
					getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "Errore durante la procedura di login.\n " +
						"Riprovare più tardi.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_LOGOUT)) {
			// Richiesto logout.
			HttpSession currentSession = request.getSession(false);
			if(currentSession != null) {
				currentSession.removeAttribute("loggedUser");
				currentSession.invalidate();
			}
			getServletContext().getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(request, response);
		}
	}

	
}
