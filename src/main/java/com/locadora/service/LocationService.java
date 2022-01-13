package com.locadora.service;

import com.locadora.exception.BusinessException;
import com.locadora.model.Location;
import com.locadora.model.Movie;
import com.locadora.model.MovieLocation;
import com.locadora.repository.LocationRepository;
import com.locadora.repository.MovieRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;
    
    @Autowired
    private MovieRepository mRepository;
    
    public Location startLocation(Location l) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        String now = sdf.format(c.getTime());
        c.add(Calendar.DATE, 7);
        String week = sdf.format(c.getTime());

        // set dates
        l.setStartDate(now);
        l.setExpectedDate(week);
        l.setFinishDate(null);
        
        // update movies copies
        for(MovieLocation ml : l.getMovies()) {
            Movie m = mRepository.getOne(ml.getMovie().getId());
            m.setStock(m.getStock()-ml.getQuant());
            mRepository.save(m);
        }
        
        // set Location in MovieLocation
        for(MovieLocation ml : l.getMovies())
            ml.setLocation(l);
        
        return repository.save(l);
        
    }
    
    public Location finishLocation(long id) {
        
        Location l = repository.getOne(id);
        
        if(l.getFinishDate() != null)
            throw new BusinessException();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        String now = sdf.format(c.getTime());

        // set FinishDate
        l.setFinishDate(now);
        
        // update movies copies
        for(MovieLocation ml : l.getMovies()) {
            Movie m = mRepository.getOne(ml.getMovie().getId());
            m.setStock(m.getStock()+ml.getQuant());
            mRepository.save(m);
        }
        
        return repository.save(l);
        
    }
}
