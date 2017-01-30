/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.spring.tutorial.business.dao;

import it.clever.spring.tutorial.business.entities.Product;
import it.clever.spring.tutorial.business.utils.IServiceUtil;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

    public ProductDaoImpl(IServiceUtil hibernateUtil) {
        super(hibernateUtil);
    }

    
    
    @Override
    public Product loadProduct(Integer id) {
        List<Product> retuserList = getCurrentSession().createQuery("from Product")
                .list();
        for(Product p: retuserList)
        {
            
            if(p.getIdProdotto().equals(id))
            return p;
        }
        
       return null;

    }
    
    
//done
    @Override
    public void persist(Product entity) throws Exception {
        getCurrentSession().persist(entity);
    }
//done
    @Override
    public Integer save(Product entity) throws Exception {
        return (Integer) getCurrentSession().save(entity);
    }

    
    //done
    @Override
    public void saveOrUpdate(Product entity) throws Exception {
        getCurrentSession().saveOrUpdate(entity);
    }

    //done
    @Override
    public void update(Product entity) throws Exception {
        getCurrentSession().update(entity);
    }

    //done
    @Override
    public Product findById(Integer id) throws Exception {
        return (Product) getCurrentSession().get(Product.class, id);
    }

    //done
    @Override
    public void delete(Product entity) throws Exception {
        getCurrentSession().delete(entity);
    }
    
 //done
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> retuserList = getCurrentSession().createQuery("from Product")
                .list();
        return retuserList;
    }

    @Override
    public Product merge(Product entity) throws Exception {
        return (Product) getCurrentSession().merge(entity);
    }

}
