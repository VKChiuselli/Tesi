/**
 * <b> UserDaoImpl.java
 * 
 * <br>
 * 
 *  Classe bo per l'accesso ai dati della tabella utente.
 * 
 */
package it.clever.spring.tutorial.business.dao.annotations;

import it.clever.spring.tutorial.business.entities.Customer;
import it.clever.spring.tutorial.business.entities.Order;
import it.clever.spring.tutorial.business.entities.OrderDetail;
import it.clever.spring.tutorial.business.entities.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 2Clever.IT
 * 
 */
@Repository("orderDao")
public class OrderDaoImpl  implements OrderDao {

	private HibernateTemplate hibernateTemplate;
	
	OrderDaoImpl() {
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void batchInsert(final int limit) throws Exception {
		
		this.hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) {
            	
        		Customer cust = new Customer();
        		cust.setIdCliente(1);
        		
        		Product prodotto = (Product)session.load(Product.class, 1);
        		//prodotto.setIdProdotto(1);
        		//session.refresh(prodotto);

        		for (int i = 0; i < limit; i++) {
        			Order ordine = new Order();
        			//ordine.setProduct(prodotto);
        			ordine.setCliente(cust);

        			ordine.setAmmontare(new BigDecimal(10));
        			ordine.setDataOrdine(new Date());
        			ordine.setQuantita(1);

        			session.saveOrUpdate(ordine);
        			if (i % 20 == 0) {
        				// 20, stesso valore del batch size JDBC.
        				// Effettua la flush e libera la memoria.
        				// ordine.setAmmontare(new BigDecimal(0));
        				session.flush();
        				session.clear();
        			}
        		}
                return null;
            }
        });
		
	}

	@SuppressWarnings("unchecked")
	public List<Order> findOrderByFilterCriterion() throws Exception {

		return (List<Order>) this.hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) {
            	
        		Criteria criteria = session.createCriteria(Order.class);
        		Criteria customerCriteria = criteria.createCriteria("cliente");
        		Property idP = Property.forName("idCliente");
        		
        		customerCriteria.add( Restrictions.disjunction()
        		        .add( idP.isNotNull() )
        		        .add( idP.eq( 1 ) )).setMaxResults(10);
                return criteria.list();
            }
        });
	}
	
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


	@Override
	public void persist(Order entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Integer save(Order entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveOrUpdate(Order entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Order entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Order findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Order entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Order> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Order merge(Order entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Order> findOrdersByOrderFilters(Integer prodId, int qta)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Object[]> findInfoOrdersforTable() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrderDetail> findInfoOrderDetails() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Order> findOrderListPaginated(int minQta, int maxQta,
			int minAmount, int maxAmount, int firstResult, int maxResults)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Object[]> findOrderByCriteria() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Object[]> findOrderByProductCriteria() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
