/**
 * <b>AppBaseServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per la gestione dei metodi di base comuni.
 * 
 */
package com.opengest.crm.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opengest.crm.web.utils.IAppCostants;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class AppBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che gestisce gli errori applicativi:
	 * 1. log.
	 * 2. gestione della redirect in seguito all'errore.
	 * 
	 * @param request
	 * @param response
	 * @param errorPage
	 * @param ex
	 */
	protected void manageErrors(HttpServletRequest request, HttpServletResponse response, 
								String errorPage, Exception ex, String errorMessage) {
		try {
			
			request.setAttribute(IAppCostants.REQUEST_PARAM_ERROR_MESSAGE, errorMessage);
			getLogger().error(errorMessage);
			getLogger().error(this.getClass());
			getLogger().error(ex.getLocalizedMessage());
			getServletContext().getRequestDispatcher(errorPage).forward(request, response);
			
		} catch (Exception e) {
			getLogger().error(e);
		}
	}
	
	/**
	 * Metodo che restituisce il logger dell'applicazione.
	 * @return
	 */
	protected Log getLogger() {
		return LogFactory.getLog(this.getClass());
	}
}
