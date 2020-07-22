package com.cagayake.service;

import com.cagayake.pojo.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    List<Order> findOrderByUsername(String username);
    void deleteOrderByUsername(String username);
}
