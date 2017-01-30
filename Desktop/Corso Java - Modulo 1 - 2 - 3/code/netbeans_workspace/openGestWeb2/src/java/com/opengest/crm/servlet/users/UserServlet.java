/**
 * <b>UserServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione delle operazioni utenti.
 * 
 */
package com.opengest.crm.servlet.users;

/**
 * 
 * @author Roberto Giontella
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opengest.core.business.dto.UserDTO;
import com.opengest.core.business.services.IUserSevice;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.forms.UserForm;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends AppBaseServlet {
	
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

		String userid = request.getParameter(IAppCostants.REQUEST_PARAM_USER_ID);
		
		BusinessDelegate bd = new BusinessDelegate();
		IUserSevice userService = bd.retrieveUserService();
		HttpSession session = request.getSession(false);
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_USERS_CREATE_INIT)) {
			
			// Richiesta creazione utente
			try {
				UserDTO user = new UserDTO();
				session.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_USER, user);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/users/newuser.jsp").forward(request, response);
				
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_USERS_CREATE, e, "Errore durante il caricamento dell'utente.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_USERS_CREATE)) {
			
			// Richiesta creazione utente
			UserForm userForm = new UserForm(userService);
			try {
				UserDTO user = userForm.registerUserForCreate(request);
				if(userForm.getMessages() != null
						&& !userForm.getMessages().isEmpty()) {
					request.setAttribute(IAppCostants.REQUEST_PARAM_USER_FORM, userForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_USERS_CREATE_FAILURE).forward(request, response);
				} else {
					userService.saveUser(user);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_USERS_USERLIST).forward(request, response);
				}
			}catch (Exception e) {
				request.setAttribute(IAppCostants.REQUEST_PARAM_USER_FORM, userForm);
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_USERS_USERLIST, e, "Errore durante la creazione dell'utente.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_USERS_UPDATE_INIT)) {
			
			// Richiesta modifica utente.
			try {
				UserDTO user = userService.findUserById(new Long(userid));
				session.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_USER, user);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/users/user.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_USERS_USERLIST, e, "Errore durante il caricamento dell'utente.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_USERS_UPDATE)) {
			
			// Richiesta modifica utente.
			UserForm userForm = new UserForm(userService);
			try {
				UserDTO user = userForm.registerUserforUpdate(request);
				if(userForm.getMessages() != null
						&& !userForm.getMessages().isEmpty()) {
					request.setAttribute(IAppCostants.REQUEST_PARAM_USER_FORM, userForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_USERS_UPDATE_FAILURE).forward(request, response);
				} else {
					userService.updateUser(user);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_USERS_USERLIST).forward(request, response);
				}
			}catch (Exception e) {
				request.setAttribute(IAppCostants.REQUEST_PARAM_USER_FORM, userForm);
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_USERS_UPDATE_FAILURE, e, "Errore durante la modifica dell'utente.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_USERS_DELETE)) {
			
			// Richiesta eliminazione utente.
			try {
					userService.deleteUser(new Long(userid));
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_USERS_USERLIST).forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_USERS_USERLIST, e, "Errore durante l'eliminazione dell'utente.");
			}
			
		} 
		
	}
	

}
