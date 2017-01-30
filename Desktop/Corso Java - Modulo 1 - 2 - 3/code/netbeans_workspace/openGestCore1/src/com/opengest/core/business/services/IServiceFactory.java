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
 * @author 2Clever.IT
 *
 */
public interface IServiceFactory {
	
	public IDBConnectionService initializeDBConnectionService() throws Exception;
	
	public IUserSevice getUserServiceFacade();
	
	public IDBConnectionService getCurrentService() throws Exception;
}
