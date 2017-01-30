/**
 * <b> BusinessDelegate.java
 * 
 * <br/>
 * 
 * Classe delegate per il recupero dei servizi.
 * 
 */
package com.opengest.crm.business;

import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.core.business.services.IOrderSevice;
import com.opengest.core.business.services.IProductSevice;
import com.opengest.core.business.services.ISystemService;
import com.opengest.core.business.services.IUserSevice;
import com.opengest.core.business.services.impl.ServiceFactory;


/**
 * 
 * @author Roberto Giontella
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
	
	/**
	 * Recupera il servizio legato alle operazioni di sistema.
	 * @return
	 */
	public ISystemService retrieveSystemService() {
		return ServiceFactory.getInstance().getSystemServiceFacade();
	}
	
	/**
	 * Recupera il servizio legato alle operazioni sui prodotti.
	 * @return
	 */
	public IProductSevice retrieveProductService() {
		return ServiceFactory.getInstance().getProductServiceFacade();
	}
	
	/**
	 * Recupera il servizio legato alle operazioni sui clienti.
	 * @return
	 */
	public ICustomerSevice retrieveCustomerService() {
		return ServiceFactory.getInstance().getCustomerServiceFacade();
	}
	/**
	 * Recupera il servizio legato alle operazioni sugli ordini.
	 * @return
	 */
	public IOrderSevice retrieveOrderService() {
		return ServiceFactory.getInstance().getOrderServiceFacade();
	}
}
