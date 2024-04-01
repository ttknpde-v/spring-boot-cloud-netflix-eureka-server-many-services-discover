package com.ttknpdev.client.service;


import java.util.List;

public interface RobotService<T> {
    List<T> reads();
    T read(Long id);
    T create(T obj);
    T update(T obj,Long id);
    Boolean delete(Long id);
}