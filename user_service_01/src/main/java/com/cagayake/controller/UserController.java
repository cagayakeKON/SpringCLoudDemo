package com.cagayake.controller;

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
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/add/{username}/{password}/{sex}/{phone_number}/{email}",method = RequestMethod.POST)
    public void addUser(@PathVariable String username,@PathVariable String password,@PathVariable String sex,@PathVariable String phone_number,@PathVariable String email){
        User user = new User(username,sex,password,phone_number,email);
        userService.addUser(user);
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> findALlUser(){
       return userService.findAllUser();
    }

    @RequestMapping(value = "/delete/{username}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }

    @RequestMapping(value = "/update/{username}/{password}/{sex}/{phone_number}/{email}")
    public void updateUser(@PathVariable String username,@PathVariable String password,@PathVariable String sex,@PathVariable String phone_number,@PathVariable String email){
        User user = new User(username,sex,password,phone_number,email);
        userService.updateUser(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
