/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.spring.tutorial.business.dao;

import it.clever.spring.tutorial.business.entities.Product;
import java.util.List;

/**
 *
 * @author v.chiuselli
 */
public interface ProductDao  extends BaseDaoInterface<Product, Integer> {
    
    
    public Product loadProduct(Integer id);
    
    
}
