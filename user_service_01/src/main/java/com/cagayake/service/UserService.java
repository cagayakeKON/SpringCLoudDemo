package com.cagayake.service;

import com.cagayake.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    void deleteUser(String name);
    void updateUser(User user);
    void addUser(User user);

}
