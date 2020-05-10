package com.productService.service;

import com.productService.exception.DependencyFailureException;
import com.productService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    void deleteProductById(String id);

    Optional<Product> updateProduct(Product prod);

    Optional<Product> findProductById(String id, boolean sellerDetail) throws DependencyFailureException;

    Optional<Product> createProduct(Product product);

    List<Product> getAllProducts();
}
