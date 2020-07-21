package com.cagayake.order;

import com.cagayake.mapper.OrderMapper;
import com.cagayake.pojo.Order;
import com.cagayake.utils.RandomNumber;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderService01ApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
        Order order = new Order();
        order.setOrder_number(RandomNumber.createOrderNumber());
        order.setState(RandomNumber.createStateNumber());
        order.setPrice(RandomNumber.createPrice());
        order.setUser_name("adasd");
        orderMapper.addOrder(order);
    }

}
