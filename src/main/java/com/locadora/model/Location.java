package com.locadora.model;

import lombok.Data;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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