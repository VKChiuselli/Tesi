/**
 * <b>CustomerListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista dei clienti.
 * 
 */
package com.opengest.crm.servlet.customers;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.core.business.vo.ICustomer;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class CustomerListServlet extends AppBaseServlet {


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
		ICustomerSevice customerService = bd.retrieveCustomerService();
		
		try {
			List<ICustomer> customerList = customerService.listCustomers();
			Vector<ICustomer> vector = new Vector<ICustomer>(customerList);
			request.setAttribute(IAppCostants.REQUEST_PARAM_CUSTOMER_LIST, vector);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/customers/customerList.jsp").forward(request, response);
			
		} catch (Exception e) {
			manageErrors(request, response, "/WEB-INF/pages/customers/customersInit.jsp", e, "Errore durante il caricamento della lista clienti.");
		}
	}
}
