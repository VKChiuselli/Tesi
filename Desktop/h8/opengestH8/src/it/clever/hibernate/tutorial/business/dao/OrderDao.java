package it.clever.hibernate.tutorial.business.dao;

import it.clever.hibernate.tutorial.business.entity.Order;
import it.clever.hibernate.tutorial.business.entity.OrderDetail;

import java.util.List;

public interface OrderDao  extends BaseDaoInterface<Order, Integer> {

	public void batchInsert(int limit) throws Exception;
	
	public List<Order> findOrdersByOrderFilters(Integer prodId, int qta) throws Exception;
	
	public List<Object[]> findInfoOrdersforTable() throws Exception;
	
	public List<OrderDetail> findInfoOrderDetails() throws Exception;
}
