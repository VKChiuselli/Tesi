/**
 * <b> IServiceFactory.java
 * 
 * <br>
 * 
 *  Interfaccia con i metodi della corrispondente factory dei servizi. 
 * 
 */
package it.clever.testapp.tomcat.business.services;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.services.impl.ClientiServiceImpl;
import it.clever.testapp.tomcat.business.services.impl.UserServiceImpl;

/**
 * 
 * @author robgion
 * www.2clever.it
 *
 */
public abstract class BaseServiceFactory {
	
	private static IDBConnectionServiceLocal currentService;

	public abstract IDBConnectionService initDBConnectionService(String dbInteractionMode) throws BusinessException;
	
	
	/**
	 * Metodo per il recupero del corrente servizio per l'accesso al database.
	 * Restituisce l'istanza in modo che possa essere utilizzato unicamente
	 * dai servizi di business.
	 * @return
	 * @throws Exception
	 */
	public IDBConnectionServiceLocal getCurrentServiceLocal() throws BusinessException {
		
		return currentService;
	}

	
	/**
	 * Metodo per il recupero del corrente servizio per l'accesso al database.
	 * Restituisce l'istanza in modo che possa essere utilizzato dai componenti web.
	 * @return
	 * @throws Exception
	 */
	public IDBConnectionService getCurrentService() throws BusinessException {
		
		return (IDBConnectionService)currentService;
	}
	
	
	protected void updateCurrentService(IDBConnectionServiceLocal dbService) {
		currentService = dbService;
	}


	/**
	 * Recupero del servizio che occupa della gestione degli utenti.
	 * @return
	 */
	public IUserSevice retrieveUserService() {
		return new UserServiceImpl();
	}
        
        public IClientiService retrieveClientiService() {
		return new ClientiServiceImpl();
	}
	
}
