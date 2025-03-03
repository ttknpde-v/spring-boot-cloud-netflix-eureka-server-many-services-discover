package com.ttknpdev.client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "robots")
public class Robot {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) No auto_increment
    private Long rid;
    private String codename;
    @Column(name = "releasedate") // but this annotation for mapping specify column name
    private String releaseDate; // by default it mapped release_date column name on sql
    private Double price;
    private Boolean status;
}
