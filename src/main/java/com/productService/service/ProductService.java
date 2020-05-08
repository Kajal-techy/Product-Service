package com.productService.service;

import com.productService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    void deleteProductbyId(String id);

    void updateProduct(Product prod);

    void deleteAllProducts();

    Optional<Product> findProductById(String id, boolean sellerDetail);

    void createProduct(Product product);

    List<Product> getAllProducts();

}
