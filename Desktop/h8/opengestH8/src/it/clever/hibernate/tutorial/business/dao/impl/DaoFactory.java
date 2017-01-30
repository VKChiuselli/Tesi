/**
 * @author 2Clever.IT
 *
 */
package it.clever.hibernate.tutorial.business.dao.impl;

/**
 * @author 2Clever.IT
 *
 */
public class DaoFactory {

	
	
	/**
	 * Metodo che recupera l'implementazione dello UserDao interface.
	 * @return
	 */
	public UserDaoImpl createUserDao() {
		return new UserDaoImpl();
	}

	public ProductDaoImpl createProductDao() {
		return new ProductDaoImpl();
	}
	
	public OrderDaoImpl createOrdertDao() {
		return new OrderDaoImpl();
	}
	public CustomerDaoImpl createCustomerDao() {
		return new CustomerDaoImpl();
	}
	public DistrictDaoImpl createDistrictDao() {
		return new DistrictDaoImpl();
	}
	public DepartmentDaoImpl createDepartmentDao() {
		return new DepartmentDaoImpl();
	}
	
}
