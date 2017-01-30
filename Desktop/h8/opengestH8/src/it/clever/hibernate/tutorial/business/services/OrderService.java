package it.clever.hibernate.tutorial.business.services;

import it.clever.hibernate.tutorial.business.dao.impl.CustomerDaoImpl;
import it.clever.hibernate.tutorial.business.dao.impl.DaoFactory;
import it.clever.hibernate.tutorial.business.dao.impl.OrderDaoImpl;
import it.clever.hibernate.tutorial.business.dao.impl.ProductDaoImpl;
import it.clever.hibernate.tutorial.business.entity.Customer;
import it.clever.hibernate.tutorial.business.entity.Order;
import it.clever.hibernate.tutorial.business.entity.OrderDetail;
import it.clever.hibernate.tutorial.business.entity.Product;
import it.clever.hibernate.tutorial.exception.BusinessException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class OrderService {

	private OrderDaoImpl orderDao;
	private CustomerDaoImpl customerDao;
	private ProductDaoImpl productDao;
	
	public OrderService() {
		this.orderDao = new DaoFactory().createOrdertDao();
		this.customerDao = new DaoFactory().createCustomerDao();
		this.productDao = new DaoFactory().createProductDao();
	}
	
	public List<Order> findAll() throws Exception  {
		
		this.orderDao.openCurrentSession();
		List<Order> retOrdersList = this.orderDao.findAll();
		this.orderDao.closeCurrentSession();
		return retOrdersList;
	}

	public void persist(Order entity) throws Exception {
		this.orderDao.beginTransaction();
		this.orderDao.persist(entity);		
		this.orderDao.closeCurrentSession();
	}

	public void update(Order entity) throws Exception {
		this.orderDao.beginTransaction();
		this.orderDao.update(entity);		
		this.orderDao.closeCurrentSession();
	}

	public Order findById(Integer id) throws Exception {
		this.orderDao.openCurrentSession();
		Order retOrder = this.orderDao.findById(id);
		this.orderDao.closeCurrentSession();
		return retOrder;
	}

	public void delete(Order entity) throws Exception {
		this.orderDao.beginTransaction();
		this.orderDao.delete(entity);		
		this.orderDao.endTransaction();
	}
	
	public void batchInsert(int limit) throws BusinessException {
		
		try {
			this.orderDao.beginTransaction();
			
			this.orderDao.batchInsert(limit);
			
			this.orderDao.endTransaction();
			
		} catch(Exception ex) {
			this.orderDao.abortTransaction();
		}
	}
	
	/**
	 * Metodo per la verifica dei meccanismi di flush della session.
	 * @throws BusinessException
	 */
	public void flushOrder() throws BusinessException {
		
		try {
			
			Customer cliente = new Customer();
			cliente.setCodice("OPGL2");
			cliente.setRagSoc("Customer molto importante	");
			cliente.setPiva("12325456325");
			
			Product prodotto = new Product();
			prodotto.setCodice("PRD02");
			prodotto.setDescrizione("PRD02");
			prodotto.setPrezzo(new BigDecimal(100));
			
			Order ordine1 = new Order();
			ordine1.setAmmontare(new BigDecimal(10));
			ordine1.setDataOrdine(new Date());
			ordine1.setQuantita(1);
			
			Order ordine2 = new Order();
			ordine2.setAmmontare(new BigDecimal(20));
			ordine2.setDataOrdine(new Date());
			ordine2.setQuantita(2);

			Order ordine3 = new Order();
			ordine3.setAmmontare(new BigDecimal(30));
			ordine3.setDataOrdine(new Date());
			ordine3.setQuantita(3);
			

			// Inizio transazione.
			Session currentSession = this.orderDao.beginTransaction();
			customerDao.setCurrentSession(currentSession);
			productDao.setCurrentSession(currentSession);
			
			this.orderDao.persist(ordine1);
			this.orderDao.persist(ordine2);
			this.orderDao.persist(ordine3);
			
			
			customerDao.save(cliente);
			productDao.save(prodotto);
			
			/*
			 * La sessione viene "sporcata" modificando degli oggetti in meoria 
			 * senza riflesso sulla base dati.
			 */
			ordine1.setProdotti(prodotto);
			ordine1.setCliente(cliente);
			ordine2.setProdotti(prodotto);
			ordine2.setCliente(cliente);
			ordine3.setProdotti(prodotto);
			ordine3.setCliente(cliente);
			
			/*
			 * 1. Hibernate minimizza gli accessi al DB quindi effettua il flush solo se effettivamente necessario.
			 * 	  Questo non accade prima di ogni query.
			 * 
			 * 2. Hibernate effettuerà il flush solo esclusivamente se gli oggetti in sessione sono rilevanti per 
			 *    la query che sta per effettuare.
			 *    
			 * 3. Eseguire una query HQL o con Criteria che non coinvolga gli oggetti modificati nella session
			 *    non prevede il flush delgi oggetti.
			 */
			List<Product> productList = this.productDao.findAll();
			
			/*
			 * 4. Una query SQL Hibernate non vede la necessità di effettuare il flush degli oggetti.
			 */
			Query query = currentSession.createSQLQuery("select * from ordini");
			List results = query.list();
			
			/*
			 * 4. Gli oggetti interessati dalla query sono stati modificati precedentemente e quindi devono 
			 *    necessariamente essere aggiornati.
			 */
			List<Order> orderList = this.orderDao.findAll();
			
			
			this.orderDao.endTransaction();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			this.orderDao.abortTransaction();
			
		}
	}
	
	public List<Order> findOrdersByOrderFilters(Integer prodId, int qta) throws BusinessException  {
		try {
			List<Order> retList = null;
			
			this.orderDao.openCurrentSession();
			
			retList = this.orderDao.findOrdersByOrderFilters(prodId, qta);
			
			this.orderDao.closeCurrentSession();
			
			return retList;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Errore durante il recupero degli ordini.",ex);
		}
	}
	
	public List<Object[]> findInfoOrdersfortable() throws BusinessException  {
		try {
			List<Object[]> retList = null;
			
			this.orderDao.openCurrentSession();
			
			retList = this.orderDao.findInfoOrdersforTable();
			
			this.orderDao.closeCurrentSession();
			
			return retList;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Errore durante il recupero degli ordini.",ex);
		}
	}
	
	public List<OrderDetail> findInfoOrderDetails() throws BusinessException  {
		try {
			List<OrderDetail> retList = null;
			
			this.orderDao.openCurrentSession();
			
			retList = this.orderDao.findInfoOrderDetails();
			
			this.orderDao.closeCurrentSession();
			
			return retList;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Errore durante il recupero degli ordini.",ex);
		}
	}	
}
