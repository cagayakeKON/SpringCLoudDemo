package com.cagayake.mapper;

import com.cagayake.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    void addUser(User user);

    List<User> findAllUser();

    void deleteUser(String username);

    void updateUser(User user);

}
