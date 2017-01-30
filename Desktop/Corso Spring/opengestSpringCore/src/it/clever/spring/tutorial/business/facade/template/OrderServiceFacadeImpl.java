package it.clever.spring.tutorial.business.facade.template;

import it.clever.spring.tutorial.business.dao.template.OrderDao;
import it.clever.spring.tutorial.business.dao.template.OrderDaoImpl;
import it.clever.spring.tutorial.business.exception.BusinessException;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceFacadeImpl {

	private OrderDao orderDao;
	
	public OrderServiceFacadeImpl() {
	}
	
	
	public void batchInsert(int limit) throws BusinessException {
		
		try {
			
			this.orderDao.batchInsert(limit);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDaoImpl orderDao) {
		this.orderDao = orderDao;
	}
	
}
