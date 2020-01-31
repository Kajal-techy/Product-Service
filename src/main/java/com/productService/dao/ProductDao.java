package com.productService.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.productService.model.Product;

@Repository
public interface ProductDao {
	
	public void save(Product product);

	public Optional<Product> getProductById(int id);

	public List<Product> getAllProducts();

	public void deleteProductById(int id);

	public void deleteAllProducts();

}
