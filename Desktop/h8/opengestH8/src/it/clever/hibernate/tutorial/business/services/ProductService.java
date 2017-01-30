package it.clever.hibernate.tutorial.business.services;

import it.clever.hibernate.tutorial.business.dao.impl.DaoFactory;
import it.clever.hibernate.tutorial.business.dao.impl.ProductDaoImpl;
import it.clever.hibernate.tutorial.business.entity.Product;
import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private ProductDaoImpl productDao;

    public ProductService() {
        this.productDao = new DaoFactory().createProductDao();
    }

    public List<Product> findAll() throws Exception {

        this.productDao.openCurrentSession();
        List<Product> retuserList = this.productDao.findAll();
        this.productDao.closeCurrentSession();;

        return retuserList;
    }

    public void persist(Product entity) throws Exception {
        this.productDao.beginTransaction();
        this.productDao.persist(entity);
        this.productDao.endTransaction();
    }

    public void update(Product entity) throws Exception {
        this.productDao.beginTransaction();
        this.productDao.update(entity);
        this.productDao.endTransaction();
    }

    public Product findById(Integer id) throws Exception {
        this.productDao.openCurrentSession();
        Product retProduct = this.productDao.findById(id);
        this.productDao.closeCurrentSession();
        return retProduct;
    }

    public void delete(Product entity) throws Exception {
        this.productDao.beginTransaction();
        this.productDao.delete(entity);
        this.productDao.endTransaction();
    }

    public void inserimentoProdotto(String codice, String descrizione, BigDecimal prezzo) throws Exception {

        this.productDao.beginTransaction();
        this.productDao.inserimentoProdotto(codice, descrizione, prezzo);
        this.productDao.endTransaction();
    }
    
    

}
