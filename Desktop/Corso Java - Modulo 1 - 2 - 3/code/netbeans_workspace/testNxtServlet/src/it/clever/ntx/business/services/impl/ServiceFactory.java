/**
 * <b> ServiceFactory.java
 * 
 * <br>
 * JSONServlet
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 *  
 * Classe che implementa la factory per i servizi messi a disposizione dal progetto. 
 * 
 */
package it.clever.ntx.business.services.impl;

import it.clever.ntx.business.exceptions.BusinessException;
import it.clever.ntx.business.services.BaseServiceFactory;
import it.clever.ntx.business.services.IBusinessParams;
import it.clever.ntx.business.services.IDBConnectionService;


/**
 * 
 * @author Roberto Giontella
 *
 */
public class ServiceFactory extends BaseServiceFactory {

	private static BaseServiceFactory _instance;
	
	
	private ServiceFactory() {
		
	}
	
	public static BaseServiceFactory getInstance() {
		
		synchronized (ServiceFactory.class) {
			if(_instance == null) {
				_instance = new ServiceFactory();
			}
		}
		return _instance;
	}
	

	/**
	 * Metodo per il recupero del servizio del database.
	 */
	@Override
	public IDBConnectionService initDBConnectionService(String dbInteractionMode) throws BusinessException {
		if(dbInteractionMode.equals(IBusinessParams.DAB_CONNECTION_MODE_DATASOURCE)) {
			updateCurrentService(DatasourceServiceImpl.getInstance());
			return DatasourceServiceImpl.getInstance();
		} else if(dbInteractionMode.equals(IBusinessParams.DAB_CONNECTION_MODE_JDBC)) {
			updateCurrentService(JDBCServiceImpl.getInstance());
			return JDBCServiceImpl.getInstance();
		}
		return null;
	}
}
