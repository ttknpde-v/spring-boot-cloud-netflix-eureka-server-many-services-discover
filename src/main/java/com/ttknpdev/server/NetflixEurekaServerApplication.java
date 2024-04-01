package com.ttknpdev.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // ** Mark this project is Eureka server (eureka server ทำหน้าที่เป็น service discovery/service registry)
public class NetflixEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaServerApplication.class, args);
    }
}
