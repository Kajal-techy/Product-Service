package com.productService.dao;

import com.productService.model.Product;
import com.productService.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao {

    void save(Product product);

    Optional<Product> getProductById(String id);

    List<Product> getAllProducts();

    void deleteProductById(String id);

    void deleteAllProducts();

    User[] getUserByUserName(String userName);
}
