package com.ttknpdev.client.repository;

import java.util.List;

public interface MobileRepository <T> {
    List<T> reads();
    T read(Long id);
    Boolean create(T obj);
    Boolean update(T obj,Long id);
    Boolean delete(Long id);
}
