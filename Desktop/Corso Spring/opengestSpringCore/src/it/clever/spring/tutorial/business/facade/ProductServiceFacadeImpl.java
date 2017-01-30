/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.spring.tutorial.business.facade;

import it.clever.spring.tutorial.business.dao.ProductDaoImpl;
import it.clever.spring.tutorial.business.entities.Product;
import it.clever.spring.tutorial.business.exception.BusinessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author v.chiuselli
 */
public class ProductServiceFacadeImpl {

    private ProductDaoImpl daoImpl;

    public ProductDaoImpl getDaoImpl() {
        return daoImpl;
    }

    public void setDaoImpl(ProductDaoImpl daoImpl) {
        this.daoImpl = daoImpl;
    }

    public List<Product> findAll() throws Exception {
        this.daoImpl.openCurrentSession();
        List<Product> retuserList = (List<Product>) this.daoImpl.findAll();
        this.daoImpl.closeCurrentSession();
        return retuserList;
    }

    public void persist(Product entity) throws Exception {
        this.daoImpl.beginTransaction();
        this.daoImpl.persist(entity);
        this.daoImpl.endTransaction();
    }

    public void update(Product entity) throws Exception {
        this.daoImpl.beginTransaction();
        this.daoImpl.update(entity);
        this.daoImpl.endTransaction();
    }

    public Product findById(Integer id) throws Exception {
        this.daoImpl.beginTransaction();
        Product retUser = (Product) this.daoImpl.findById(id);
        this.daoImpl.endTransaction();
        return retUser;
    }

    public void delete(Product entity) throws Exception {
        this.daoImpl.beginTransaction();
        this.daoImpl.delete(entity);
        this.daoImpl.endTransaction();
    }

    public Integer save(Product entity) throws Exception {

        this.daoImpl.beginTransaction();
        Integer id = this.daoImpl.save(entity);
        this.daoImpl.endTransaction();
        return id;
    }

    public void saveOrUpdate(Product entity) throws Exception {
        this.daoImpl.beginTransaction();
        this.daoImpl.saveOrUpdate(entity);
        this.daoImpl.endTransaction();
    }

    public Product loadProduct(Integer id) throws BusinessException {
        this.daoImpl.beginTransaction();
        Product product = this.daoImpl.loadProduct(id);
        this.daoImpl.endTransaction();
        return product;
    }

}
