/**
 * <b>UserListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista degli utenti.
 * 
 */
package com.opengest.crm.servlet.users;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.services.IUserSevice;
import com.opengest.core.business.vo.UserVO;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class UserListServlet extends AppBaseServlet {


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
			Vector<UserVO> vector = new Vector<UserVO>(userList);
			request.setAttribute(IAppCostants.REQUEST_PARAM_USER_LIST, vector);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/users/userList.jsp").forward(request, response);
			
		} catch (Exception e) {
			manageErrors(request, response, "/WEB-INF/pages/users/userInit.jsp", e, "Errore durante il caricamento della lista utenti.");
		}
	}
}
