/**
 * <b> ServiceFactory.java
 * 
 * <br>
 * 
 *  Classe che implementa la factory per i servizi messi a disposizione dal progetto. 
 * 
 */
package it.clever.testapp.tomcat.business.services.impl;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.services.BaseServiceFactory;
import it.clever.testapp.tomcat.business.services.IBusinessParams;
import it.clever.testapp.tomcat.business.services.IDBConnectionService;


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
