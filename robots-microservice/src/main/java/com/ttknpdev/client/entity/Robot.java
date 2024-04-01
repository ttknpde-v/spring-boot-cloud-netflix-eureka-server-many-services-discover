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
    private String releaseDate; // work like @Column(name = "release_date")
    private Double price;
    private Boolean status;
}
