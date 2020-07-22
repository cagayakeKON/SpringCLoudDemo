package com.cagayake.controller;

import com.cagayake.feign.OrderFeign;
import com.cagayake.mapper.UserMapper;
import com.cagayake.pojo.User;
import com.cagayake.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping()
public class UserController {

    private UserService userService;

    private OrderFeign orderFeign;

    @RequestMapping(value = "/add/{username}/{password}/{sex}/{phone_number}/{email}",method = RequestMethod.POST,produces = "application/json")
    public Response addUser(@PathVariable String username,@PathVariable String password,@PathVariable String sex,@PathVariable String phone_number,@PathVariable String email){
        User user = new User(username,sex,password,phone_number,email);
        userService.addUser(user);
        return new Response(200,"success",null);
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET,produces = "application/json")
    public Response findALlUser(){
       return new Response(200,"success",userService.findAllUser());
    }

    @RequestMapping(value = "/delete/{username}",method = RequestMethod.DELETE,produces = "application/json")
    public Response deleteUser(@PathVariable String username){
        Response response = orderFeign.deleteOrderByUsername(username);
        if (response.getCode()==200){
            userService.deleteUser(username);
        }
        return new Response(200,"success",null);
    }

    @RequestMapping(value = "/update/{username}/{password}/{sex}/{phone_number}/{email}",produces = "application/json")
    public Response updateUser(@PathVariable String username,@PathVariable String password,@PathVariable String sex,@PathVariable String phone_number,@PathVariable String email){
        User user = new User(username,sex,password,phone_number,email);
        userService.updateUser(user);
        return new Response(200,"success",null);
    }

    @RequestMapping(value = "/create/{username}")
    public Response createOrder(@PathVariable String username){
        Response order = orderFeign.createOrder(username);
        return new Response(200,"The order is as follows ",orderFeign.findOrderByUsername(username).getData());
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderFeign(OrderFeign orderFeign) {
        this.orderFeign = orderFeign;
    }
}
