package com.productService.dao;

import com.productService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user-service")
public interface UserServiceProxy {

    @GetMapping("/v1/users")
    List<User> getUserDetails(@RequestParam String userName);
}
