package com.cagayake.feign;

import com.cagayake.controller.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name="order")
public interface OrderFeign {

    @RequestMapping(value = "/create/{username}",method = RequestMethod.POST)
    public Response createOrder(@PathVariable String username);

    @RequestMapping(value = "/find/{username}",method = RequestMethod.GET)
    public Response findOrderByUsername(@PathVariable String username);

    @RequestMapping(value = "/delete/{username}",method = RequestMethod.DELETE)
    public Response deleteOrderByUsername(@PathVariable String username);

}
