/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.service;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public interface ProductService {

    public List<Product> getAll();

    public Product getById(Long id);

    public Product create(Product product);

    public Product update(Product product);

    public Product delete(Long id);

    public List<Product> findByCategory(Category category);

    public Product updateStock(Long id, Double quantity);

}
