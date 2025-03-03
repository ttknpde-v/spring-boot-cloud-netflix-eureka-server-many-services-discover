package com.ttknpdev.cllient.controller;

import com.ttknpdev.cllient.entities.Robot;
import com.ttknpdev.cllient.services.RobotResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Done crud concept
// when you call http://localhost:8080/api/robot/reads eureka client will handle to  http://ROBOTS-MICROSERVICE/api/robot/reads
// but you can not request on your own
@RestController
@RequestMapping(value = RobotRouter.ROUTER)
public class RobotRouter {
    protected final static String ROUTER = "/api/robot";
    private final static String NEW_DOMAIN = "http://ROBOTS-MICROSERVICE"+ROUTER;
    private RobotResponseService robotResponseService;
    @Autowired
    public RobotRouter(RobotResponseService robotResponseService) {
        this.robotResponseService = robotResponseService;
    }
    @GetMapping(value = "/reads")
    private ResponseEntity<List<Robot>> retrieveRobotFromRobotsMicroservice(){
        String url = NEW_DOMAIN+"/reads";
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(robotResponseService.reads(url));
    }
    @GetMapping(value = "/read")
    private ResponseEntity<Robot> retrieveRobotFromRobotMicroservice(@RequestParam(required = false) Long id){
        String url = NEW_DOMAIN+"/read?id="+id;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(robotResponseService.read(url));
    }

    @PostMapping(value = "/create")
    private ResponseEntity<Robot> addRobotFromRobotMicroservice(@RequestBody Robot robot){
        String url = NEW_DOMAIN+"/create";
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(robotResponseService.create(url,robot));
    }

    @PutMapping(value = "/update")
    private ResponseEntity<Robot> editRobotFromRobotMicroservice(@RequestParam(required = false) Long id,@RequestBody Robot robot){
        String url = NEW_DOMAIN+"/update?id="+id;
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(robotResponseService.update(url,robot));
    }

    @DeleteMapping(value = "/delete")
    private ResponseEntity<Boolean> removeRobotFromRobotMicroservice(@RequestParam(required = false) Long id){
        String url = NEW_DOMAIN+"/delete?id="+id;
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(robotResponseService.delete(url));
    }
}
