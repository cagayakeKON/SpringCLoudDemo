package com.cagayake.service;

import com.cagayake.mapper.OrderMapper;
import com.cagayake.pojo.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public List<Order> findOrderByUsername(String username) {
        return orderMapper.findOrderByUsername(username);
    }

    @Override
    public void deleteOrderByUsername(String username) {
        orderMapper.deleteOrderByUsername(username);
    }


    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
}
