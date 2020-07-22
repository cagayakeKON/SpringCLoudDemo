package com.cagayake.feign;

import com.cagayake.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user")
public interface UserServiceFeignClient {

    @RequestMapping(value = "/api/user/getAllUser" ,method = RequestMethod.GET)
    public List<User> findAllUser();
}
