package com.opengest.crm.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.crm.web.utils.IAppCostants;

public class MenuServlet extends HttpServlet {

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
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_MENU_USERS)) {
			try {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/users/userInit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_MENU_PRODUCTS)) {
			try {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/products/productInit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_MENU_CUSTOMERS)) {
			try {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/customers/customerInit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_MENU_ORDERS)) {
			try {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/orders/orderInit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
