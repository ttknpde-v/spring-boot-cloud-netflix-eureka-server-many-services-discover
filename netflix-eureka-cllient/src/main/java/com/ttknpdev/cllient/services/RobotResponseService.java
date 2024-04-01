package com.ttknpdev.cllient.services;

import com.ttknpdev.cllient.entities.Mobile;
import com.ttknpdev.cllient.entities.Robot;
import com.ttknpdev.cllient.logging.LogBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RobotResponseService {
    private RestTemplate restTemplate;
    private final LogBack logBack;
    private HttpHeaders headers;
    private HttpEntity entity;

    @Autowired
    public RobotResponseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        logBack = new LogBack(RobotResponseService.class);
    }
    public List<Robot> reads(String url) {
        logBack.log.info("************ H2 DATABASE ************** you ganna called {}", url);
        // way to convert array object to list
        Robot[] objects = restTemplate.getForObject(url, Robot[].class);
        List<Robot> robots = null;
        if (objects != null) {
            robots = Arrays.asList(objects);
        }
        logBack.log.info("mobiles has {}",robots);
        return robots;
    }

    public Robot read(String url) {
        logBack.log.info("************ H2 DATABASE ************** you ganna called {}", url);
        // way to convert array object to list
        Robot robot = restTemplate.getForObject(url ,Robot.class);
        logBack.log.info("mobiles has {}",robot);
        return robot;
    }

    public Robot create(String url, Robot robot) {
        logBack.log.info("************ H2 DATABASE ************** you ganna called {}", url);
        // *** way to pass json body on request
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Robot robotResponse = restTemplate.postForObject(url ,robot, Robot.class);
        logBack.log.info("robotResponse has {}",robotResponse);
        return robotResponse;
    }

    public Robot update(String url, Robot robot) {
        logBack.log.info("************ H2 DATABASE ************** you ganna called {}", url);
        // *** way to get the response from my http put method
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<Robot>(robot);
        ResponseEntity<Robot> response = restTemplate.exchange(url, HttpMethod.PUT, entity, Robot.class);
        // restTemplate.put(url ,robot); // ** no need cause its type is void
        logBack.log.info("response has {}",response);
        return response.getBody();
    }

    public Boolean delete(String url) {
        logBack.log.info("************ H2 DATABASE ************** you ganna called {}", url);
        // default it set content-type is application/json => Content-Type:"application/json"
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class);
        logBack.log.info("response has {}",response);
        return response.getBody();
    }
}
