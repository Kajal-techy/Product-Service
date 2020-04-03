package com.productService.dao;

import com.productService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {

    private DefaultProductDao defaultProductDao;

    @Autowired
    public ProductDaoImpl(DefaultProductDao defaultProductDao) {
        this.defaultProductDao = defaultProductDao;
    }

    @Override
    public void save(Product product) {
        defaultProductDao.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
    	return defaultProductDao.findAll();
    }

    @Override
    public void deleteProductById(int id) {
        defaultProductDao.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
    	defaultProductDao.deleteAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        Optional<Product> product = defaultProductDao.findById(id);
        return product;
    }
}
