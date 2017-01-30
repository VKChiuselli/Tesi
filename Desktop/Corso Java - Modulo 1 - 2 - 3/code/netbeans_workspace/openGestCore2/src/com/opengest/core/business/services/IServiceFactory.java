/**
 * <b> IServiceFactory.java
 * 
 * <br>
 * 
 *  Interfaccia con i metodi della corrispondente factory dei servizi. 
 * 
 */
package com.opengest.core.business.services;



/**
 * 
 * @author Roberto Giontella
 *
 */
public interface IServiceFactory {
	
	IDBConnectionService initializeDBConnectionService(String startMode, String startModeDAtasource, String startModeJDBC) throws Exception;
	
	IDBConnectionService getCurrentService() throws Exception;
	
	IDBConnectionServiceLocal getCurrentServiceLocal() throws Exception;

	IUserSevice getUserServiceFacade();
	
	ISystemService getSystemServiceFacade();
	
	IProductSevice getProductServiceFacade();
	
	ICustomerSevice getCustomerServiceFacade();
	
	IOrderSevice getOrderServiceFacade();
	
}
