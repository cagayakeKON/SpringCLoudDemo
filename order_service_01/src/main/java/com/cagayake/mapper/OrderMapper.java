package com.cagayake.mapper;

import com.cagayake.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    void addOrder(Order order);
    List<Order> findOrderByUsername(String username);
}
