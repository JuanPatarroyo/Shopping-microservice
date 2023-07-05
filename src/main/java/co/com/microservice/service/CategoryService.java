/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.service;

import co.com.microservice.controller.CategoryController;
import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;

import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public interface CategoryService {

    public List<Category> getAll();

    public Category getById(Long id);

    public Category create(Category product);

    public Category update(Category product);

    public String delete(Long id);

}
