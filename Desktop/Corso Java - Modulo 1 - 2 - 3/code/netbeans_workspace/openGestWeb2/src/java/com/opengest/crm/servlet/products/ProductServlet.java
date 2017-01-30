/**
 * <b>CustomerServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione delle operazioni prodotti.
 * 
 */
package com.opengest.crm.servlet.products;

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

import com.opengest.core.business.dto.ProductDTO;
import com.opengest.core.business.services.IProductSevice;
import com.opengest.crm.business.BusinessDelegate;
import com.opengest.crm.servlet.AppBaseServlet;
import com.opengest.crm.web.forms.ProductForm;
import com.opengest.crm.web.utils.IAppCostants;

/**
 * Servlet implementation class CustomerServlet
 */

public class ProductServlet extends AppBaseServlet {
	
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

		String productId = request.getParameter(IAppCostants.REQUEST_PARAM_PRODUCT_ID);
		
		BusinessDelegate bd = new BusinessDelegate();
		IProductSevice productService = bd.retrieveProductService();
		
		if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_PRODUCTS_UPDATE_INIT)) {
			
			// Richiesta modifica utente.
			try {
				ProductDTO product = productService.findProductById(new Long(productId));
				request.getSession(false).setAttribute(IAppCostants.SESSION_PARAM_REQUEST_PRODUCT, product);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/products/product.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST, e, "Errore durante il caricamento del prodotto.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_PRODUCTS_DELETE)) {
			
			// Richiesta eliminazione utente.
			try {
					productService.deleteProduct(new Long(productId));
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST).forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST, e, "Errore durante l'eliminazione del prodotto.");
			}
			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_PRODUCTS_UPDATE)) {
			
			// Richiesta modifica prodotto.
			ProductForm productForm = new ProductForm(productService);
			try {
				ProductDTO product = productForm.registerProductforUpdate(request);
				if(productForm.getMessages() != null
						&& !productForm.getMessages().isEmpty()) {
					request.setAttribute(IAppCostants.REQUEST_PARAM_PRODUCT_FORM, productForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_PRODUCTS_UPDATE_FAILURE).forward(request, response);
				} else {
					productService.updateProduct(product);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST).forward(request, response);
				}
				
			}catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST, e, "Errore durante la modifica del prodotto.");
			}
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_PRODUCTS_CREATE_INIT)) {
			
			// Richiesta creazione prodotto.
			try {
				ProductDTO product = new ProductDTO();
				request.setAttribute(IAppCostants.SESSION_PARAM_REQUEST_PRODUCT, product);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/products/saveProduct.jsp").forward(request, response);
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST, e, "Errore durante il caricamento del prodotto.");
			}			
		} else if(request.getServletPath().equals(IAppCostants.CONTEXT_PATH_PRODUCTS_CREATE)) {
			
			// Richiesta creazione prodotto
			ProductForm productForm = new ProductForm(productService);
			ProductDTO product = productForm.registerProductForCreate(request);
			try {
				if(productForm.getMessages() != null
						&& !productForm.getMessages().isEmpty()) {
					
					request.setAttribute(IAppCostants.REQUEST_PARAM_PRODUCT_FORM, productForm);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_PRODUCTS_CREATE_FAILURE).forward(request, response);
					
				} else {
					productService.saveProduct(product);
					getServletContext().getRequestDispatcher(IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST).forward(request, response);
				}
			} catch (Exception e) {
				manageErrors(request, response, IAppCostants.CONTEXT_PATH_PRODUCTS_PRODUCT_LIST, e, "Errore durante la modifica del prodotto.");
			}
			
		}
		
	}
	

}
