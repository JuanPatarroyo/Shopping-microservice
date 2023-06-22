/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.controller;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import co.com.microservice.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jpatarroyo
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        List<Product> products = new ArrayList<>();
        if(categoryId == null){
            products = service.getAll();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }else{
            products = service.findByCategory(Category.builder().id(categoryId).build());
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id){
        Product product = service.getById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product productCreate = service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product product){
        product.setId(id);
        Product productUpdated = service.update(product);
        if(productUpdated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id){
        Product productDeleted = service.delete(id);
        if(productDeleted == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDeleted);
    }
    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable("id") Long id, @RequestParam(name = "stock", required = true) Double stock){
        Product product = service.updateStock(id, stock);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}
