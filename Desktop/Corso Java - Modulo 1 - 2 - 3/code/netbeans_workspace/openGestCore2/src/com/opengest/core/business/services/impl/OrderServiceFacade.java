/**
 * <b> OrderServiceFacade.java
 * 
 * <br/>
 * 
 * Classe facade per la gestione delle operazioni del modulo ordini.
 * 
 */
package com.opengest.core.business.services.impl;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.opengest.core.business.dto.OrderDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.IOrderSevice;
import com.opengest.core.business.vo.IOrder;

/**
 * 
 * @author Roberto Giontella
 *
 */
public class OrderServiceFacade implements IOrderSevice {

	
	public OrderDTO findOrderById(Long id) throws BusinessException {
		return null;
	}
	
	public void deleteOrder(Long id) throws BusinessException {
	}

	public void saveOrder(OrderDTO Order) throws BusinessException {
	}
	
	public void updateOrder(OrderDTO Order) throws BusinessException {
	}

	public List<IOrder> listOrders() throws BusinessException {
		throw new NotImplementedException();
	}



}
