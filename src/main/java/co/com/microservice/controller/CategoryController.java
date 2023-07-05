package co.com.microservice.controller;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import co.com.microservice.service.CategoryService;
import co.com.microservice.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = new ArrayList<>();
        categories = service.getAll();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Long id) {
        Category category = service.getById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatResult(result));
        }
        Category categoryExisted = service.getById(category.getId());
        if (categoryExisted != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryExisted);
        }
        Category categoryCreate = service.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category category) {
        category.setId(id);
        Category categoryUpdated = service.update(category);
        if (categoryUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        String respuesta = service.delete(id);
        if (respuesta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    private String formatResult(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).toList();
        ErrorMessage message = ErrorMessage.builder().code("01").messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(message);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace(System.err);
        }
        return jsonString;
    }
}
