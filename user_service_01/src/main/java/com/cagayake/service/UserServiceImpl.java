package com.cagayake.service;

import com.cagayake.mapper.UserMapper;
import com.cagayake.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {

        return userMapper.findAllUser();
    }

    @Override
    public void deleteUser(String name) {
        userMapper.deleteUser(name);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
