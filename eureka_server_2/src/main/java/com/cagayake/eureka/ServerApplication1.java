package com.cagayake.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication1.class,args);
    }
}
