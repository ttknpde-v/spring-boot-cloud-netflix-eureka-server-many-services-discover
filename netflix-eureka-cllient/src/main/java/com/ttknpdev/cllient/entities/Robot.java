package com.ttknpdev.cllient.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Robot {
    private Long rid;
    private String codename;
    private String releaseDate;
    private Double price;
    private Boolean status;
}
