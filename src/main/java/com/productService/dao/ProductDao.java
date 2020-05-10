package com.productService.dao;

import com.productService.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao {

    Optional<Product> save(Product product);

    Optional<Product> getProductById(String id);

    List<Product> getAllProducts();

    void deleteProductById(String id);
}
