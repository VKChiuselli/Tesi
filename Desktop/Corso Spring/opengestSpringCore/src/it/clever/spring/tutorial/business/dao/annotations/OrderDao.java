package it.clever.spring.tutorial.business.dao.annotations;

import it.clever.spring.tutorial.business.entities.Order;
import it.clever.spring.tutorial.business.entities.OrderDetail;

import java.util.List;

public interface OrderDao {

	public void persist(Order entity) throws Exception;

	public Integer save(Order entity) throws Exception;

	public void saveOrUpdate(Order entity) throws Exception;

	public void update(Order entity) throws Exception;

	public Order findById(Integer id) throws Exception;

	public void delete(Order entity) throws Exception;

	public List<Order> findAll() throws Exception;
	
	public Order merge(Order entity) throws Exception;
	public void batchInsert(int limit) throws Exception;
	
	public List<Order> findOrdersByOrderFilters(Integer prodId, int qta) throws Exception;
	
	public List<Object[]> findInfoOrdersforTable() throws Exception;
	
	public List<OrderDetail> findInfoOrderDetails() throws Exception;
	
	public List<Order> findOrderListPaginated(int minQta, int maxQta, 
			int minAmount, int maxAmount,int firstResult, int maxResults) throws Exception;
	
	public List<Object[]> findOrderByCriteria() throws Exception;
	
	public List<Object[]> findOrderByProductCriteria() throws Exception;
}
