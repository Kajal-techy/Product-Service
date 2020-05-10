package com.productService.dao;

import com.productService.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ProductDaoImpl implements ProductDao {

    private final DefaultProductDao defaultProductDao;

    @Autowired
    public ProductDaoImpl(DefaultProductDao defaultProductDao) {
        this.defaultProductDao = defaultProductDao;
    }

    @Override
    public Optional<Product> save(Product product) {
        log.info("Entering ProductDaoImpl.save with parameter product {} ", product);
        return Optional.of(defaultProductDao.save(product));
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Entering ProductDaoImpl.getAllProducts");
        return defaultProductDao.findAll();
    }

    @Override
    public void deleteProductById(String id) {
        log.info("Entering ProductDaoImpl.deleteProductById with parameter id {} ", id);
        defaultProductDao.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(String id) {
        log.info("Entering ProductDaoImpl.getProductById with parameter id {} ", id);
        return defaultProductDao.findById(id);
    }
}
