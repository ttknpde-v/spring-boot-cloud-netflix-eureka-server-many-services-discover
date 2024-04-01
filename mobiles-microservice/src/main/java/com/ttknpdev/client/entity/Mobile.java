package com.ttknpdev.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {
    private Long mid;
    private String brand;
    private String model;
    private Short stock;
    private Float price;
    private Boolean state;
}
