/**
 * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.hibernate.tutorial.business.dao.impl;

import it.clever.hibernate.tutorial.business.dao.OrderDao;
import it.clever.hibernate.tutorial.business.entity.Customer;
import it.clever.hibernate.tutorial.business.entity.Order;
import it.clever.hibernate.tutorial.business.entity.OrderDetail;
import it.clever.hibernate.tutorial.business.entity.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

/**
 * @author 2Clever.IT
 * 
 */
public class OrderDaoImpl extends BaseDaoServiceImpl implements OrderDao {

	OrderDaoImpl() {
	}

	@Override
	public Integer save(Order entity) throws Exception {
		return (Integer) getCurrentSession().save(entity);
	}

	@Override
	public void persist(Order entity) throws Exception {
		getCurrentSession().persist(entity);
	}

	@Override
	public void update(Order entity) throws Exception {
		getCurrentSession().update(entity);
	}

	@Override
	public Order findById(Integer id) throws Exception {
		return (Order) openCurrentSession().get(Order.class, id);
	}

	@Override
	public void delete(Order entity) throws Exception {
		getCurrentSession().delete(entity);
	}

	@Override
	public List<Order> findAll() throws Exception {
		List<Order> retuserList = getCurrentSession().createQuery("from Order")
				.list();
		return retuserList;
	}

	@Override
	public void batchInsert(int limit) throws Exception {
		Customer cliente = new Customer();
		cliente.setIdCliente(1);

		Product prodotto = new Product();
		prodotto.setIdProdotto(1);

		for (int i = 0; i < limit; i++) {
			Order ordine = new Order();
			ordine.setProdotti(prodotto);
			ordine.setCliente(cliente);

			ordine.setAmmontare(new BigDecimal(10));
			ordine.setDataOrdine(new Date());
			ordine.setQuantita(1);

			persist(ordine);
			if (i % 20 == 0) {
				// 20, stesso valore del batch size JDBC.
				// Effettua la flush e libera la memoria.
				// ordine.setAmmontare(new BigDecimal(0));
				flush();
				clear();
			}
		}
		
		ScrollableResults orderResult = getCurrentSession().getNamedQuery("GetAllOrdersBatchMode")
			    .setCacheMode(CacheMode.IGNORE)
			    .scroll(ScrollMode.FORWARD_ONLY);
		
			int count=0;
			while ( orderResult.next() ) {
			    Order order = (Order) orderResult.get(0);
			    order.setQuantita(100);
			    if ( ++count % 20 == 0 ) {
			        //flush a batch of updates and release memory:
			    	getCurrentSession().flush();
			    	getCurrentSession().clear();
			    }
			}
			   
	}
	
	public List<Order> findOrdersByOrderFilters(Integer prodId, int qta) throws Exception  {
		List<Order> retList = null;
		
		String q1 = "select o from Order o " +
				" where o.product.idProdotto = :prodId and o.quantita > :qta";

		
		Query query = getCurrentSession()
						.createQuery(q1);
		
		query.setParameter("prodId", prodId);
		query.setParameter("qta", qta);
		retList = query.list();
		
		return retList;
	}
	
	public List<Object[]> findInfoOrdersforTable() throws Exception  {
		List<Object[]> retList = null;
		
		String q = "select o.idOrdine, o.dataOrdine, o.quantita, c.ragSoc, " +
				" p.codice from Order o inner join o.cliente c inner join o.product p";

		
		Query query = getCurrentSession().createQuery(q);
		
		retList = query.list();
		
		return retList;
	}
	
	
	public List<OrderDetail> findInfoOrderDetails() throws Exception  {
		List<OrderDetail> retList = null;
		
		String q = "select new it.clever.hibernate.tutorial.business.entity.OrderDetail(" +
				"o.idOrdine, o.dataOrdine, o.quantita, c.ragSoc, " +
				" p.codice) from Order o inner join o.cliente c inner join o.product p";

		
		Query query = getCurrentSession().createQuery(q);
		
		retList = query.list();
		
		return retList;
	}	
}
