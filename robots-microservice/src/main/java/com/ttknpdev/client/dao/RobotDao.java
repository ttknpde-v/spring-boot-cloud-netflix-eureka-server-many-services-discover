package com.ttknpdev.client.dao;

import com.ttknpdev.client.entity.Robot;
import com.ttknpdev.client.repository.RobotRepository;
import com.ttknpdev.client.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotDao implements RobotService<Robot> {
    private RobotRepository robotRepository;
    @Autowired
    public RobotDao(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    @Override
    public List<Robot> reads() {
        return robotRepository.findAll();
    }

    @Override
    public Robot read(Long id) {
        // if not exist it will throw error
        return robotRepository.findById(id).orElseThrow();
    }

    @Override
    public Robot create(Robot obj) {
        return robotRepository.save(obj);
    }
    // basic for any robot id did not exist i set to throw error
    @Override
    public Robot update(Robot obj, Long id) {
        return robotRepository.findById(id).map(robot -> {
            robot.setCodename(obj.getCodename());
            robot.setPrice(obj.getPrice());
            robot.setReleaseDate(obj.getReleaseDate());
            robot.setStatus(obj.getStatus());
            return robotRepository.save(robot);
        }).orElseThrow();
    }

    @Override
    public Boolean delete(Long id) {
        return robotRepository.findById(id).map(robot -> {
            robotRepository.delete(robot);
            return true;
        }).orElseThrow();
    }
}
