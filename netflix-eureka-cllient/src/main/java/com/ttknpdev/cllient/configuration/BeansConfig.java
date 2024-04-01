package com.ttknpdev.cllient.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class BeansConfig {
    @Bean // for solve this error. Parameter 0 of constructor in com.ttknpdev.cllient.services.MobileResponseService required a bean of type 'org.springframework.web.client.RestTemplate' that could not be found.
    /*
        The @LoadBalanced annotation creates an instance of created RestTemplate load-balanced.
        There is no code you need to write to make the RestTemplate load-balance HTTP request it sends to an internal microservice.
        The RestTemplate bean will be intercepted(สกัดกั้น)and auto-configured by Spring Cloud.
        we need to use the @LoadBalanced Annotation in our configuration class while creating the Bean of RestTemplate.
    */
    @LoadBalanced //***** If i don't use I can't access MOBILES-MICROSERVICE domain :  (UnknownHostException: MOBILES-MICROSERVICE) ** Importance I used to solve this error. I/O error on GET request for "http://MOBILES-MICROSERVICE/api/mobile/reads": MOBILES-MICROSERVICE] with root causejava.net.UnknownHostException: MOBILES-MICROSERVICE
    // เราสามารถใช้ service name แทนที่จะใช้ address:port ในการเรียก ไปยัง service อื่นๆ
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
