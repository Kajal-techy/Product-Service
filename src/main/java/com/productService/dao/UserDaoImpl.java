package com.productService.dao;

import com.productService.exception.DependencyFailureException;
import com.productService.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserDaoImpl implements UserDao {

    private final UserServiceProxy userServiceProxy;

    public UserDaoImpl(UserServiceProxy userServiceProxy) {
        this.userServiceProxy = userServiceProxy;
    }

    public List<User> getUserByUserName(String userName) throws DependencyFailureException {
        log.info("Entering UserDaoImpl.getUserByUserName with parameter userName {} ", userName);
        try {
            return (userServiceProxy.getUserDetails(userName));
        } catch (Exception e) {
            throw new DependencyFailureException("Internal Server Error : Exception = " + e.toString());
        }
    }
}
