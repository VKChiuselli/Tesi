/**
 * <b> IOrderSevice.java
 * 
 * <br/>
 * 
 * Interfaccia facade per la gestione delle operazioni del modulo ordini.
 * 
 */
package com.opengest.core.business.services;

import java.util.List;

import com.opengest.core.business.dto.OrderDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.vo.IOrder;


/**
 * @author Roberto Giontella
 * 
 */
public interface IOrderSevice {
	
	
	OrderDTO findOrderById(Long id) throws BusinessException;
	
	void saveOrder(OrderDTO order) throws BusinessException;
	
	void updateOrder(OrderDTO order) throws BusinessException;
	
	List<IOrder> listOrders() throws BusinessException;
	
	void deleteOrder(Long id) throws BusinessException;
	
}
