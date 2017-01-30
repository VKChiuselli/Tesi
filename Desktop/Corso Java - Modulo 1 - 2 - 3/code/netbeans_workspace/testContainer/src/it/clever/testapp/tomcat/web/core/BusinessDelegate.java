/**
 * BusinessDelegate.java
 *
 * robgion
 * www.2clever.it
 * 
 * 19 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.testapp.tomcat.web.core;

import it.clever.testapp.tomcat.business.services.BaseServiceFactory;
import it.clever.testapp.tomcat.business.services.IClientiService;
import it.clever.testapp.tomcat.business.services.IDBConnectionService;
import it.clever.testapp.tomcat.business.services.IUserSevice;
import it.clever.testapp.tomcat.business.services.impl.ServiceFactory;

/**
 * @author robgion
 *
 * Classe per la gestione del pattern BusinessDelegate ed il caricamento dei servizi.
 */
public class BusinessDelegate {

	public IDBConnectionService retrieveDBConnectionService(String dbInteractionMode) {
		
		BaseServiceFactory serviceFactory = ServiceFactory.getInstance();
		try {
			return serviceFactory.initDBConnectionService(dbInteractionMode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public IDBConnectionService retrieveCurrentDBService() throws Exception {
		BaseServiceFactory serviceFactory = ServiceFactory.getInstance();
		try {
			return serviceFactory.getCurrentService();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public IUserSevice retrieveUserService() {
		return ServiceFactory.getInstance().retrieveUserService();
	}
        
        
        public IClientiService retrieveClientiService() {
		return ServiceFactory.getInstance().retrieveClientiService();
	}
}
