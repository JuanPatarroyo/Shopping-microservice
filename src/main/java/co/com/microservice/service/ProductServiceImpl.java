/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.service;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import co.com.microservice.repository.ProductRepository;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpatarroyo
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    
    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        product.setStatus("CREATED");
        product.setCreatedAt(new Date());
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product productResult = getById(product.getId());
        if (productResult == null) {
            return null;
        }
        product.setId(productResult.getId());
        return repository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product productResult = getById(id);
        if (productResult == null) {
            return null;
        }
        productResult.setStatus("DELETED");
        return repository.save(productResult);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productResult = getById(id);
        if (productResult == null) {
            return null;
        }
        Double stock = productResult.getStock() + quantity;
        productResult.setStock(stock);
        return repository.save(productResult);
    }

}
