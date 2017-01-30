/**
 * <b> ServiceFactory.java
 * 
 * <br>
 * 
 *  Classe che implementa la factory per i servizi messi a disposizione dal progetto. 
 * 
 */
package com.opengest.core.business.services.impl;

import java.sql.SQLException;

import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.core.business.services.IDBConnectionService;
import com.opengest.core.business.services.IDBConnectionServiceLocal;
import com.opengest.core.business.services.IOrderSevice;
import com.opengest.core.business.services.IProductSevice;
import com.opengest.core.business.services.IServiceFactory;
import com.opengest.core.business.services.ISystemService;
import com.opengest.core.business.services.IUserSevice;


/**
 * 
 * @author Roberto Giontella
 *
 */
public class ServiceFactory implements IServiceFactory {

	private static IServiceFactory _instance;
	private static String startMode;
	private static String smDatasource; 
	private static String smJDBC;	
	
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
	public IDBConnectionService initializeDBConnectionService(String mode, 
															  String startModeDatasource, 
															  String startModeJDBC) throws Exception, SQLException {
		
		startMode = mode;
		smDatasource = startModeDatasource; 
		smJDBC = startModeJDBC;
		
		if(mode.equals(startModeDatasource)) {
			return DatasourceConnector.getInstance();
		} else if(mode.equals(startModeJDBC)) {
			return JDBCService.getInstance();
		}
		return null;
	}
	
	/**
	 * Restituisce l'istanza del servizio corrente inizializzato.
	 * 
	 * @return
	 * @throws Exception
	 */
	public IDBConnectionService getCurrentService() throws Exception {
		
		if(startMode.equals(smDatasource)) {
			return DatasourceConnector.getInstance();
		} else if(startMode.equals(smJDBC)) {
			return JDBCService.getInstance();
		}
		
		return null;
	}

	/**
	 * Restituisce l'istanza dei servizi alle classi locali del progetto.
	 */
	public IDBConnectionServiceLocal getCurrentServiceLocal() throws Exception {
		return (IDBConnectionServiceLocal)getCurrentService();
	}
	
	
	/**
	 * Restituisce la service facade per le utilit� legate al modulo utenti.
	 * @return
	 */
	public IUserSevice getUserServiceFacade() {
		return new UserServiceFacade();
	}
	
	/**
	 * Restituisce la service facade per le utilit� legate ai dati di sistema.
	 * @return
	 */
	public ISystemService getSystemServiceFacade() {
		return new SystemServiceFacade();
	}

	/**
	 * Restituisce la service facade per le utilit� legate ai dati dei prodotti.
	 * @return
	 */
	public IProductSevice getProductServiceFacade() {
		return new ProductServiceFacade();
	}
	
	/**
	 * Restituisce la service facade per le utilit� legate ai dati dei clienti.
	 * @return
	 */
	public ICustomerSevice getCustomerServiceFacade() {
		return new CustomerServiceFacade();
	}
	
	/**
	 * Restituisce la service facade remota per le utilit� legate agli ordini.
	 * @return
	 */
	public ICustomerSevice getOrderServiceFacadeRemote() {
		return new CustomerServiceFacade();
	}

	/**
	 * Restituisce la service facade per le utilit� legate ai dati degli ordini.
	 * @return
	 */
	public IOrderSevice getOrderServiceFacade() {
		return new OrderServiceFacade();
	}


}
