/**
 * <b>OrderServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione delle operazioni sugli ordini.
 * 
 */
package com.opengest.crm.servlet.orders;

/**
 * 
 * @author Roberto Giontella
 *
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.dto.OrderDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.core.business.services.IOrderSevice;
import com.opengest.core.business.services.IProductSevice;
import com.opengest.core.business.vo.ICustomer;
import com.opengest.core.business.vo.IProduct;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.forms.OrderForm;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * Servlet implementation class CustomerServlet
 */

public class OrderServlet extends AppBaseServlet {
	
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

		String orderId = request.getParameter(IAppCostants.REQUEST_PARAM_ORDER_ID);
		
		BusinessDelegate bd = new BusinessDelegate();
		IOrderSevice orderService = bd.retrieveOrderService();
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_ORDERS_UPDATE_INIT)) {
			
			// Richiesta modifica utente.
			try {
				OrderDTO order = orderService.findOrderById(new Long(orderId));
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_ORDER, order);
				
				populateRequestparamList(request, bd);
				
				
				getServletContext().getRequestDispatcher("/WEB-INF/pages/orders/order.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_ORDERS_LIST, e, "Errore durante il caricamento dell'ordine.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_ORDERS_DELETE)) {
			
			// Richiesta eliminazione utente.
			try {
					orderService.deleteOrder(new Long(orderId));
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_ORDERS_LIST).forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_ORDERS_LIST, e, "Errore durante l'eliminazione dell'ordine.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_ORDERS_UPDATE)) {
			
			// Richiesta modifica ordine.
			OrderForm orderForm = new OrderForm(orderService);
			try {
				OrderDTO order = orderForm.registerOrderforUpdate(request);
				if(orderForm.getMessages() != null
						&& !orderForm.getMessages().isEmpty()) {
					request.setAttribute(IAppCostants.REQUEST_PARAM_ORDER_FORM, orderForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_ORDERS_UPDATE_FAILURE).forward(request, response);
				} else {
					orderService.updateOrder(order);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_ORDERS_LIST).forward(request, response);
				}
				
			}catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_ORDERS_LIST, e, "Errore durante la modifica dell'ordine.");
			}
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_ORDERS_CREATE_INIT)) {
			
			// Richiesta creazione ordine.
			try {
				OrderDTO order = new OrderDTO();
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_ORDER, order);
				
				populateRequestparamList(request, bd);
				
				getServletContext().getRequestDispatcher("/WEB-INF/pages/orders/newOrder.jsp").forward(request, response);
				
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_ORDERS_LIST, e, "Errore durante il caricamento dell'ordine.");
			}			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_ORDERS_CREATE)) {
			
			// Richiesta creazione ordine.
			OrderForm orderForm = new OrderForm(orderService);
			OrderDTO order = orderForm.registerOrderForCreate(request);
			try {
				if(orderForm.getMessages() != null
						&& !orderForm.getMessages().isEmpty()) {
					
					request.setAttribute(IAppCostants.REQUEST_PARAM_ORDER_FORM, orderForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_ORDERS_CREATE_FAILURE).forward(request, response);
					
				} else {
					orderService.saveOrder(order);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_ORDERS_LIST).forward(request, response);
				}
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_ORDERS_LIST, e, "Errore durante la modifica dell'ordine.");
			}
			
		}
		
	}
	
	private void populateRequestparamList(HttpServletRequest request, BusinessDelegate bd) throws BusinessException {
		
		IProductSevice prodService = bd.retrieveProductService();
		ICustomerSevice customerService = bd.retrieveCustomerService();
		
		//Inizializzazione delle combo box dei prodotti e dei clienti.
		List<IProduct> pList = prodService.listProducts();
		request.setAttribute(IAppCostants.REQUEST_PARAM_PRODUCT_LIST, pList);
		
		List<ICustomer> cList = customerService.listCustomers();
		request.setAttribute(IAppCostants.REQUEST_PARAM_CUSTOMER_LIST, cList);		
	}
}
