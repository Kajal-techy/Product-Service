package com.productService.dao;

import com.productService.exception.DependencyFailureException;
import com.productService.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUserByUserName(String userName) throws DependencyFailureException;
}
