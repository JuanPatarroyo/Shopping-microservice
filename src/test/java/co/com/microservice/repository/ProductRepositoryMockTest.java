/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.microservice.repository;

import co.com.microservice.entity.Category;
import co.com.microservice.entity.Product;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author jpatarroyo
 */
@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void whenFindByCategoryThenReturnListProduct() {
        Product product = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("30000"))
                .status("A")
                .createdAt(new Date()).build();
        repository.save(product);
        List<Product> founds = repository.findByCategory(product.getCategory());
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
