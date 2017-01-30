/**
 * <b>OrderListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista degli ordini.
 * 
 */
package com.opengest.crm.servlet.orders;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.services.IOrderSevice;
import com.opengest.core.business.vo.IOrder;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * 
 * @author 2Clever.it
 *
 */
public class OrderListServlet extends AppBaseServlet {


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
		IOrderSevice orderService = bd.retrieveOrderService();
		
		try {
			List<IOrder> orderList = orderService.listOrders();
			Vector<IOrder> list = new Vector<IOrder>(orderList);
			request.setAttribute(IAppCostants.REQUEST_PARAM_ORDER_LIST, list);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/orders/orderList.jsp").forward(request, response);
			
		} catch (Exception e) {
			manageErrors(request, response, "/WEB-INF/pages/orders/orderInit.jsp", e, "Errore durante il caricamento della lista ordini.");
		}
	}
}
