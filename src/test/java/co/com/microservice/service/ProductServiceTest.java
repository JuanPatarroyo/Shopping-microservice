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
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author jpatarroyo
 */
@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    private ProductService service;

    @BeforeEach
    public void setup() {
        service = new ProductServiceImpl(repository);
        Product product = Product.builder()
                .name("Computer")
                .category(Category.builder().id(1L).build())
                .description("Computador de escritorio gaming")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("350.00"))
                .status("A")
                .createdAt(new Date()).build();
        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(product));
        Mockito.when(repository.save(product)).thenReturn(product);
    }

    @Test
    public void whenValidGetIdThenReturnProduct() {
        Product found = service.getById(1L);
        Assertions.assertThat(found.getName()).isEqualTo("Computer");
    }

    @Test
    public void whenUpdateStockThenReturnNewStock() {
        Product newStock = service.updateStock(1L, Double.parseDouble("11"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(21);
    }
}
