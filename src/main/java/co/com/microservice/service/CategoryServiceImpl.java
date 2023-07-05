/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.service;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import co.com.microservice.repository.CategoryRepository;
import co.com.microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    
    private final CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category categoryResult = getById(category.getId());
        if (categoryResult == null) {
            return null;
        }
        category.setId(categoryResult.getId());
        return repository.save(category);
    }

    @Override
    public String delete(Long id) {
        Category categoryResult = getById(id);
        if (categoryResult == null) {
            return null;
        }
        repository.delete(categoryResult);
        return "Deleted successfully";
    }

}
