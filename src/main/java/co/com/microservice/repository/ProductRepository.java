/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.repository;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jpatarroyo
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public List<Product> findByCategory(Category category);
}
