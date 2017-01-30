/**
 * <b> UserDaoImpl.java
 *
 * <br>
 *
 * Classe bo per l'accesso ai dati della tabella utente.
 *
 */
package it.clever.hibernate.tutorial.business.dao.impl;

import it.clever.hibernate.tutorial.business.dao.ProductDao;
import it.clever.hibernate.tutorial.business.entity.Product;
import it.clever.hibernate.tutorial.business.entity.User;
import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author 2Clever.IT
 *
 */
public class ProductDaoImpl extends BaseDaoServiceImpl implements ProductDao {

    ProductDaoImpl() {
    }

    @Override
    public Integer save(Product entity) throws Exception {
        return (Integer) getCurrentSession().save(entity);
    }

    public List<Product> findAll() throws Exception {

        List<Product> retuserList = getCurrentSession()
                .createQuery("from Product").list();
        return retuserList;
    }

    @Override
    public void persist(Product entity) throws Exception {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Product entity) throws Exception {
        getCurrentSession().update(entity);
    }

    @Override
    public Product findById(Integer id) throws Exception {
        return (Product) openCurrentSession().get(Product.class, id);
    }

    @Override
    public void delete(Product entity) throws Exception {
        getCurrentSession().delete(entity);
    }

    public Integer inserimentoProdotto(String codice, String descrizione,  BigDecimal prezzo) throws Exception {
        
        Product p = new Product();
        p.setCodice(codice);
        p.setDescrizione(descrizione);
        p.setPrezzo(prezzo);
        
      return save(p);
    }

}
