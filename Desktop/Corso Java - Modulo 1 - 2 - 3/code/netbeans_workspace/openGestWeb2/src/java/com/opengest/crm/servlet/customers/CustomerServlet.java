/**
 * <b>CustomerServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione delle operazioni clienti.
 * 
 */
package com.opengest.crm.servlet.customers;

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

import com.opengest.core.business.dto.CustomerDTO;
import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.forms.CustomerForm;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * Servlet implementation class CustomerServlet
 */

public class CustomerServlet extends AppBaseServlet {
	
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

		String customerId = request.getParameter(IAppCostants.REQUEST_PARAM_CUSTOMER_ID);
		
		BusinessDelegate bd = new BusinessDelegate();
		ICustomerSevice customerService = bd.retrieveCustomerService();
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_UPDATE_INIT)) {
			
			// Richiesta modifica cliente.
			try {
				CustomerDTO customer = customerService.findCustomerById(new Long(customerId));
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_CUSTOMER, customer);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/customers/customer.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST, e, "Errore durante il caricamento del cliente.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_DELETE)) {
			
			// Richiesta eliminazione cliente.
			try {
					customerService.deleteCustomer(new Long(customerId));
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST).forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST, e, "Errore durante l'eliminazione del cliente.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_UPDATE)) {
			
			// Richiesta modifica cliente.
			CustomerForm customerForm = new CustomerForm(customerService);
			try {
				CustomerDTO customer = customerForm.registerCustomerforUpdate(request);
				if(customerForm.getMessages() != null
						&& !customerForm.getMessages().isEmpty()) {
					request.setAttribute(IAppCostants.REQUEST_PARAM_CUSTOMER_FORM, customerForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_UPDATE_FAILURE).forward(request, response);
				} else {
					customerService.updateCustomer(customer);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST).forward(request, response);
				}
				
			}catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST, e, "Errore durante la modifica del cliente.");
			}
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_CREATE_INIT)) {
			
			// Richiesta creazione cliente.
			try {
				CustomerDTO customer = new CustomerDTO();
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_CUSTOMER, customer);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/customers/newCustomer.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST, e, "Errore durante il caricamento del cliente.");
			}			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_CUSTOMERS_CREATE)) {
			
			// Richiesta creazione cliente
			CustomerForm customerForm = new CustomerForm(customerService);
			CustomerDTO customer = customerForm.registerCustomerForCreate(request);
			try {
				if(customerForm.getMessages() != null
						&& !customerForm.getMessages().isEmpty()) {
					
					request.setAttribute(IAppCostants.REQUEST_PARAM_CUSTOMER_FORM, customerForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_CREATE_FAILURE).forward(request, response);
					
				} else {
					customerService.saveCustomer(customer);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_CUSTOMERS_LIST).forward(request, response);
				}
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_CUSTOMERS_CREATE_FAILURE, e, "Errore durante la creazione del cliente.");
			}
			
		}
		
	}
	

}
