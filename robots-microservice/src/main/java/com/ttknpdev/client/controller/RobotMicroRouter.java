package com.ttknpdev.client.controller;


import com.ttknpdev.client.entity.Robot;
import com.ttknpdev.client.logging.LogBack;
import com.ttknpdev.client.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RobotMicroRouter.DEFAULT_PATH)
public class RobotMicroRouter {
    protected static final String DEFAULT_PATH = "/api/robot";
    private LogBack logBack;
    private RobotService robotService;

    @Autowired
    public RobotMicroRouter(RobotService robotService) {
        this.robotService = robotService;
        logBack = new LogBack(RobotMicroRouter.class);
    }

    @GetMapping(value = "/reads")
    private List<Robot> retrieveRobots() {
        logBack.log.info("You called http://ROBOTS-MICROSERVICE{} api",DEFAULT_PATH+"/reads");
        return robotService.reads();
    }

    @GetMapping(value = "/read")
    private Robot retrieveRobot(@RequestParam(required = false) Long id) {
        logBack.log.info("You called http://ROBOTS-MICROSERVICE{} api",DEFAULT_PATH+"/read?id="+id);
        return (Robot) robotService.read(id);
    }

    @PostMapping(value = "/create")
    private Robot addRobot(@RequestBody(required = false) Robot robot) {
        logBack.log.info("You called http://ROBOTS-MICROSERVICE{} api",DEFAULT_PATH+"/create");
        return (Robot) robotService.create(robot);
    }

    @PutMapping(value = "/update")
    private Robot editRobot(@RequestParam(required = false) Long id,@RequestBody(required = false) Robot robot) {
        logBack.log.info("You called http://ROBOTS-MICROSERVICE{} api",DEFAULT_PATH+"/update?id="+id);
        return (Robot) robotService.update(robot,id);
    }

    @DeleteMapping(value = "/delete")
    private Boolean removeRobot(@RequestParam(required = false) Long id) {
        logBack.log.info("You called http://ROBOTS-MICROSERVICE{} api",DEFAULT_PATH+"/delete?id="+id);
        return robotService.delete(id);
    }

}
