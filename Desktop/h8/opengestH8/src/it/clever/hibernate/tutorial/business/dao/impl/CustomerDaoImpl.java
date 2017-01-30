/**
 * <b> UserDaoImpl.java
 *
 * <br>
 *
 * Classe bo per l'accesso ai dati della tabella utente.
 *
 */
package it.clever.hibernate.tutorial.business.dao.impl;

import it.clever.hibernate.tutorial.business.dao.CustomerDao;
import it.clever.hibernate.tutorial.business.entity.Customer;
import it.clever.hibernate.tutorial.business.entity.CustomerContract;

import java.util.List;

import org.hibernate.Session;

/**
 * @author 2Clever.IT
 *
 */
public class CustomerDaoImpl extends BaseDaoServiceImpl implements CustomerDao {

    CustomerDaoImpl() {
    }

    @Override
    public Integer save(Customer entity) throws Exception {
        return (Integer) getCurrentSession().save(entity);
    }

    public List<Customer> findAll() throws Exception {

        List<Customer> retuserList = getCurrentSession()
                .createQuery("from Customer").list();
        return retuserList;
    }

    @Override
    public void persist(Customer entity) throws Exception {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Customer entity) throws Exception {
        getCurrentSession().update(entity);
    }

    @Override
    public Customer findById(Integer id) throws Exception {
        return (Customer) openCurrentSession().get(Customer.class, id);
    }

    @Override
    public void delete(Customer entity) throws Exception {
        Session session = getCurrentSession();
        session.merge(entity);
        session.delete(entity);
        session.flush();
    }

    public Integer saveContract(Customer customer, CustomerContract contract) throws Exception {

        contract.setCustomer(customer);
        customer.setContract(contract);
        Integer savedInt = save(customer);
        System.err.println("savedInt: " + savedInt);
        return savedInt;
    }

}
