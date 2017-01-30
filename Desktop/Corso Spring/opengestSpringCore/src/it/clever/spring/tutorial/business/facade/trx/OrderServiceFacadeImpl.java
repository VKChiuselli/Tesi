package it.clever.spring.tutorial.business.facade.trx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.clever.spring.tutorial.business.dao.trx.OrderDao;
import it.clever.spring.tutorial.business.dao.trx.OrderDaoImpl;
import it.clever.spring.tutorial.business.exception.BusinessException;

@Service
public class OrderServiceFacadeImpl implements ApplicationService {

	@Autowired
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
