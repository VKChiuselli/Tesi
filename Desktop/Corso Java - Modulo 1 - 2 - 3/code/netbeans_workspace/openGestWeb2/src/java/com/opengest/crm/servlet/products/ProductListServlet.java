/**
 * <b>CustomerListServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione della lista dei prodotti.
 * 
 */
package com.opengest.crm.servlet.products;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.core.business.services.IProductSevice;
import com.opengest.core.business.vo.IProduct;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class ProductListServlet extends AppBaseServlet {


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
		IProductSevice productService = bd.retrieveProductService();
		
		try {
			List<IProduct> productList = productService.listProducts();
			Vector<IProduct> vector = new Vector<IProduct>(productList);
			request.setAttribute(IAppCostants.REQUEST_PARAM_PRODUCT_LIST, vector);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/products/productList.jsp").forward(request, response);
			
		} catch (Exception e) {
			manageErrors(request, response, "/WEB-INF/pages/products/productInit.jsp", e, "Errore durante il caricamento della lista prodotti.");
		}
	}
}
