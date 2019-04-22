package com.locadora.model;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public List<MovieLocation> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieLocation> movies) {
        this.movies = movies;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", user=" + user + ", movies=" 
                + movies + ", startDate=" + startDate + ", expectedDate=" 
                + expectedDate + ", finishDate=" + finishDate + '}';
    }

}