package it.clever.hibernate.tutorial.business.services;

import it.clever.hibernate.tutorial.business.dao.impl.CustomerDaoImpl;
import it.clever.hibernate.tutorial.business.dao.impl.DaoFactory;
import it.clever.hibernate.tutorial.business.dao.impl.OrderDaoImpl;
import it.clever.hibernate.tutorial.business.entity.Customer;
import it.clever.hibernate.tutorial.business.entity.CustomerContract;
import it.clever.hibernate.tutorial.business.entity.Order;
import it.clever.hibernate.tutorial.exception.BusinessException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

public class CustomerService {

	private CustomerDaoImpl customerDao;
	private OrderDaoImpl orderDao;
	
	public CustomerService() {
		this.customerDao = new DaoFactory().createCustomerDao();
		this.orderDao = new DaoFactory().createOrdertDao();
	}

	public List<Customer> findAll() throws BusinessException {

		this.customerDao.openCurrentSession();
		List<Customer> retuserList = null;
		try {
			retuserList = this.customerDao.findAll();
			this.customerDao.closeCurrentSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Errore durante la ricerca dei customer",e);
		}
		return retuserList;
	}

	public void persist(Customer entity) throws Exception {
		this.customerDao.beginTransaction();
		this.customerDao.persist(entity);
		this.customerDao.endTransaction();
	}

	public void update(Customer entity) throws Exception {
		this.customerDao.beginTransaction();
		this.customerDao.update(entity);
		this.customerDao.endTransaction();
	}

	public Customer findById(Integer id) throws Exception {
		this.customerDao.openCurrentSession();
		Customer retProduct = this.customerDao.findById(id);
		this.customerDao.closeCurrentSession();
		return retProduct;
	}

	public void delete(Customer entity) throws Exception {
		this.customerDao.beginTransaction();
		this.customerDao.delete(entity);
		this.customerDao.endTransaction();
	}

	public void testEquality(Integer customerId, Integer orderId) throws Exception {

		// Apertura prima sessione.
		Session session1 = this.orderDao.openCurrentSession();
		Order order = this.orderDao.findById(orderId);
		this.orderDao.closeCurrentSession();

		// Apertura seconda sessione.
		Session session2 = this.customerDao.beginTransaction();
		Customer customer = customerDao.findById(customerId);
		
		// L'ordine in stato detached non viene aggiunto al Set.
		boolean added = customer.getOrders().add(order);
		System.err.println("Stato ordine aggiunto:  " + added);
		customerDao.update(customer);
		
		session2.flush();
		
		this.customerDao.endTransaction();
		
	}
	
	public void insertContract(Integer customerId) throws BusinessException {
		try {
			CustomerContract cc = new CustomerContract();
			cc.setProtocol("CC0_" + new Date());
			cc.setNotes("Contratto per la consulenza Java");
			cc.setDateStart(new Date());
			
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			cal.roll(Calendar.DAY_OF_YEAR,100);
			cc.setDateEnd(cal.getTime());
			
			// Creazione di un oggetto TRANSIENT da uno DETACHED.
			Customer customer = findById(customerId);
			customer.setIdCliente(null);
			customer.setCodice(customer.getCodice() + "_" + new Date());
			this.customerDao.beginTransaction();
			// Salvataggio degli oggetti.
			Integer savedId = this.customerDao.saveContract(customer, cc);
			this.customerDao.endTransaction();
			System.out.println("Contratto registrato correttamente");
			
			
		} catch (Exception ex) {
			this.customerDao.abortTransaction();
			ex.printStackTrace();
			throw new BusinessException("Errore durante l'inserimento del contratto",ex);
		}
	}


}