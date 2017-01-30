/**
 * <b>ServiceLoaderServlet.java</b>
 * 
 * <br/>
 * 
 * Classe Servlet per il caricamento dei servizi dell'applicazione.
 * 
 */
package com.opengest.crm.servlet;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.opengest.core.business.services.ConfigParams;
import com.opengest.core.business.services.IDBConnectionService;
import com.opengest.core.business.services.impl.ServiceFactory;
import com.opengest.crm.web.utils.AbstractConfigManager;
import com.opengest.crm.web.utils.ConfigManagerFactory;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class ServiceLoaderServlet extends AppBaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.err.println("ServiceLoaderServlet - init");
		try {
			
			/*
			 *  Recupera dal web.xml il nome del parametro di contesto
			 *  che identifica il nome del parametro a livello di context.xml
			 */
			
			String dbLoadDS   = getInitParameter("CONTEXT_DB_LOAD_MODE_DATASOURCE");
			String dbLoadJDBC = getInitParameter("CONTEXT_DB_LOAD_MODE_JDBC");
			
			/*
			 * Recupera il valore del path del file di configurazione 
			 */
			
			ConfigParams cp = new ConfigParams(getInitParameter("PARAM_DATABASE_DRIVER"), 
					getInitParameter("PARAM_DATABASE_URL"),
					getInitParameter("PARAM_DATABASE_USERNAME"), 
					getInitParameter("PARAM_DATABASE_PASSWORD"),
					getInitParameter("PARAM_DATABASE_DATASOURCE"), 
					getInitParameter("PARAM_DATABASE_START_MODE"));
			
			 
			 IDBConnectionService connectionService = ServiceFactory.getInstance()
					 .initializeDBConnectionService(cp.getPARAM_DATABASE_START_MODE(), dbLoadDS, dbLoadJDBC);
			 
			connectionService.startService(cp);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.destroy();
	}
}
