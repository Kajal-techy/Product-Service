package com.productService.dao;

import com.productService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface UserServiceProxy {

    @GetMapping("/v1/users")
    User[] getUserDetails(@RequestParam(value = "userName") String userName);
}
