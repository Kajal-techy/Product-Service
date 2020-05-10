package com.productService.dao;

import com.productService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultProductDao extends MongoRepository<Product, String> {
}
