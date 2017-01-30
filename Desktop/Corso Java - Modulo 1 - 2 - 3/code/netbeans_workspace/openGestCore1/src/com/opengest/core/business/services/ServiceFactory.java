/**
 * <b> ServiceFactory.java
 * 
 * <br>
 * 
 *  Classe che implementa la factory per i servizi messi a disposizione dal progetto. 
 * 
 */
package com.opengest.core.business.services;

import java.sql.SQLException;


/**
 * 
 * @author 2Clever.IT
 *
 */
public class ServiceFactory implements IServiceFactory {

	private static IServiceFactory _instance;
	
	private ServiceFactory() {
		
	}
	
	public static IServiceFactory getInstance() {
		
		synchronized (ServiceFactory.class) {
			if(_instance == null) {
				_instance = new ServiceFactory();
			}
		}
		return _instance;
	}
	
	/**
	 * Crea il serivzio di connessione al database a seconda delle impostazioni parametriche.
	 * @param mode
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public IDBConnectionService initializeDBConnectionService() throws Exception {
		
			return JDBCService.getInstance();
	}
	
	/**
	 * Restituisce l'istanza del servizio corrente inizializzato.
	 * 
	 * @return
	 * @throws Exception
	 */
	public IDBConnectionService getCurrentService() throws Exception {
		
		return JDBCService.getInstance();
		
	}

	/**
	 * Restituisce la service facade per le utiliyt� legate al modulo utenti.
	 * @return
	 */
	public IUserSevice getUserServiceFacade() {
		return new UserServiceFacade();
	}
	
}
