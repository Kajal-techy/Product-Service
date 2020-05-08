package com.productService.dao;

import com.productService.exception.NotFoundException;
import com.productService.model.Product;
import com.productService.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ProductDaoImpl implements ProductDao {

    private final DefaultProductDao defaultProductDao;

    private final UserServiceProxy userServiceProxy;

    @Value("${hostname.userservice}")
    private String hostname;

    @Value("${path.getUserByUserName}")
    private String path;

    @Autowired
    public ProductDaoImpl(DefaultProductDao defaultProductDao, UserServiceProxy userServiceProxy) {
        this.defaultProductDao = defaultProductDao;
        this.userServiceProxy = userServiceProxy;
    }

    @Override
    public void save(Product product) {
        log.info("Entering ProductDaoImpl.save with parameter product {} ", product);
        defaultProductDao.save(product);
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
    public void deleteAllProducts() {
        log.info("Entering ProductDaoImpl.deleteAllProducts");
        defaultProductDao.deleteAll();
    }

    @Override
    public User[] getUserByUserName(String userName) {
        log.info("Entering ProductDaoImpl.getUserByUserName with parameter userName {} ", userName);
        try {
            return userServiceProxy.getUserDetails(userName);
        } catch (Exception e) {
            throw new NotFoundException("Internal Server Error : Exception = " + e.toString());
        }
    }

    @Override
    public Optional<Product> getProductById(String id) {
        log.info("Entering ProductDaoImpl.getProductById with parameter id {} ", id);
        return defaultProductDao.findById(id);
    }
}
