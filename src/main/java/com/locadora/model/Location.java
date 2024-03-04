package com.locadora.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<MovieLocation> movies;
    
    @Column(nullable = false, name = "start_date")
    private String startDate;

    @Column(nullable = false, name = "expected_date")
    private String expectedDate;

    @Column(nullable = true, name = "finish_date")
    private String finishDate;

}