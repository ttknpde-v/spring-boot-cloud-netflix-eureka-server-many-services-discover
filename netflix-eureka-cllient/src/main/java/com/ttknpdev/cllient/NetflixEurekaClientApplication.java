package com.ttknpdev.cllient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // *** The @EnableEurekaClient annotation is used to make your Spring Boot application acts as a Eureka Client.
public class NetflixEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaClientApplication.class, args);
    }

}
