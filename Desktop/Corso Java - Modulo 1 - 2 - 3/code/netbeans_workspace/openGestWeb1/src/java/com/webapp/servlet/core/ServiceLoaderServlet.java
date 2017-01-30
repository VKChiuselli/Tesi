/**
 * <b>ServiceLoaderServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per il caricamento dei servizi dell'applicazione.
 * 
 */
package com.webapp.servlet.core;

import com.opengest.core.business.services.IDBConnectionService;
import com.opengest.core.business.services.ServiceFactory;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 
 * @author 2Clever.IT
 *
 */
public class ServiceLoaderServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.err.println("ServiceLoaderServlet - init");
		try {
			
			 
			 IDBConnectionService  connectionService = ServiceFactory.getInstance()
					 .initializeDBConnectionService();
			 
			connectionService.startService();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		
		try {
			
			// Chiamata del DB Service per l'interruzione delle comunicazioni con il database.
			IDBConnectionService connectionService = ServiceFactory.getInstance().getCurrentService();
			connectionService.terminateService();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.destroy();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
