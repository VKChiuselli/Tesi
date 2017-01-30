/**
 * <b> BusinessDelegate.java
 * 
 * <br/>
 * 
 * Classe delegate per il recupero dei servizi.
 * 
 */
package com.webapp.web;

import com.opengest.core.business.services.IUserSevice;
import com.opengest.core.business.services.ServiceFactory;


/**
 * 
 * @author 2Clever.IT
 *
 */
public class BusinessDelegate {

	/**
	 * Recupera il servizio legato alle operazioni utente.
	 * @return
	 */
	public IUserSevice retrieveUserService() {
		return ServiceFactory.getInstance().getUserServiceFacade();
	}
	
}
