package it.clever.testapp.tomcat.web.servlets;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import it.clever.testapp.tomcat.business.services.IDBConnectionService;
import it.clever.testapp.tomcat.business.utils.ConfigParams;
import it.clever.testapp.tomcat.web.core.BusinessDelegate;


/**
 * Servlet implementation class ConfigLoaderServlet
 */
public class ConfigLoaderServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ConfigLoaderServlet() {
        super();
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo per l'inzializzazione dei servizi dell'applicazione.
	 */
	@Override public void init(ServletConfig config) throws ServletException {

		super.init(config);
		
		String dbMode = getServletContext().getInitParameter("db_mode");
		String dbURL = getServletContext().getInitParameter("db_url");
		String dbDriver = getServletContext().getInitParameter("db_driver");
		String dbUsername = getServletContext().getInitParameter("db_username");
		String dbPassword = getServletContext().getInitParameter("db_password");
		String datasourceJNDIName = getServletContext().getInitParameter("db_datasource_jndi_name");
		
		ConfigParams cp = new ConfigParams(dbDriver, dbURL, dbUsername, dbPassword, datasourceJNDIName, dbMode);
		BusinessDelegate bD = new BusinessDelegate();
		IDBConnectionService connectionService = bD.retrieveDBConnectionService(dbMode);
		try {
			connectionService.startService(cp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo per la terminazione dei servizi attivati.
	 */
	@Override public void destroy() {
		BusinessDelegate bD = new BusinessDelegate();
		try {
			IDBConnectionService connectionService = bD.retrieveCurrentDBService();
			connectionService.terminateService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.destroy();
	}

	
}
