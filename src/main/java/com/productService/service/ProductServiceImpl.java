package com.productService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.productService.dao.ProductDao;
import com.productService.model.Product;

@Service
class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void createProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> getAllProducts(Product product) {
		return null;
		
	}

	@Override
	public Optional<Product> findProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public void deleteProductbyId(int id) {
		productDao.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		
	}

} 