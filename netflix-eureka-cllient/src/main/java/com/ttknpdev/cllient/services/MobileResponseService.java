package com.ttknpdev.cllient.services;

import com.ttknpdev.cllient.entities.Mobile;
import com.ttknpdev.cllient.entities.Robot;
import com.ttknpdev.cllient.logging.LogBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MobileResponseService {

    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private HttpEntity entity;
    private final LogBack logBack;
    @Autowired
    public MobileResponseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        logBack = new LogBack(MobileResponseService.class);
    }

    public List<Mobile> reads(String url) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** you ganna called {}", url);
        // way to convert array object to list
        Mobile[] objects = restTemplate.getForObject(url, Mobile[].class);
        List<Mobile> mobiles = null;
        if (objects != null) {
            mobiles = Arrays.asList(objects);
        }
        logBack.log.info("mobiles has {}",mobiles);
        return mobiles;
    }

    public Mobile read(String url) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** you ganna called {}", url);
        // way to convert array object to list
        Mobile mobile = restTemplate.getForObject(url ,Mobile.class);
        logBack.log.info("mobiles has {}",mobile);
        return mobile;
    }

    public Boolean create(String url,Mobile mobile) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** you ganna called {}", url);
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<Mobile>(mobile);
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.POST, entity, Boolean.class);
        logBack.log.info("response has {}",response); // <200 OK OK,true,[Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Mon, 01 Apr 2024 05:44:56 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>
        return response.getBody(); // my microservice i set for response Only true OR false on body
    }

    public Boolean update(String url,Mobile mobile) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** you ganna called {}", url);
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<Mobile>(mobile);
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.PUT, entity, Boolean.class);
        logBack.log.info("response has {}",response);
        return response.getBody(); // my microservice i set for response Only true OR false on body
    }

    public Boolean delete(String url) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** you ganna called {}", url);
        headers = new HttpHeaders();
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class);
        logBack.log.info("response has {}",response);
        return response.getBody(); // my microservice i set for response Only true OR false on body
    }


}
