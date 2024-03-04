package com.locadora.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String director;
    
    @Column(nullable = false)
    private int stock;

}
