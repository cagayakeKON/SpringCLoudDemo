package com.cagayake.controller;

import com.cagayake.feign.UserServiceFeignClient;
import com.cagayake.pojo.Order;
import com.cagayake.pojo.User;
import com.cagayake.service.OrderService;
import com.cagayake.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class OrderController {

    private UserServiceFeignClient userServiceFeignClient;

    private OrderService orderService;

    @RequestMapping(value = "/create/{username}", method = RequestMethod.POST,produces = "application/json")
    public Response createOrder(@PathVariable String username) {
        Order order = new Order();
        order.setUser_name(username);
        order.setOrder_number(RandomNumber.createOrderNumber());
        order.setPrice(RandomNumber.createPrice());
        order.setState(RandomNumber.createStateNumber());
        orderService.addOrder(order);
        return new Response(200,"success",null);
    }

    @RequestMapping(value = "/find/{username}",method = RequestMethod.GET,produces = "application/json")
    public Response findOrderByUsername(@PathVariable String username){
        List<Order> orders = orderService.findOrderByUsername(username);
        return new Response(200,"success",orders);
    }

    @RequestMapping(value = "/delete/{username}",method = RequestMethod.DELETE,produces = "application/json")
    public Response deleteOrderByUsername(@PathVariable String username){
        orderService.deleteOrderByUsername(username);
        return new Response(200,"success",null);
    }

    @Autowired
    public void setUserServiceFeignClient(UserServiceFeignClient userServiceFeignClient) {
        this.userServiceFeignClient = userServiceFeignClient;
    }
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
