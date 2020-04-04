package com.productService.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productService.model.Product;

@Repository
public interface DefaultProductDao extends MongoRepository<Product, Integer> {
}
