package com.cagayake.demo;

import com.cagayake.mapper.UserMapper;
import com.cagayake.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> allUser = userMapper.findAllUser();
        User user = new User();
        user.setUsername("adasd");
        user.setPassword("asdsd");
      //  userMapper.addUser(user);
        //userMapper.deleteUser("a");
        userMapper.updateUser(user);
        System.out.println("");
    }



}
