package com.cagayake.controller;

import com.cagayake.feign.UserServiceFeignClient;
import com.cagayake.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private UserServiceFeignClient userServiceFeignClient;

    @RequestMapping("/get")
    public List<User> getAllUser(){
       return userServiceFeignClient.findAllUser();
    };


    @Autowired
    public void setUserServiceFeignClient(UserServiceFeignClient userServiceFeignClient) {
        this.userServiceFeignClient = userServiceFeignClient;
    }
}
