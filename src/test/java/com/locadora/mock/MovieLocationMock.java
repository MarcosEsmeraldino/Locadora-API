package com.locadora.mock;

import com.locadora.model.Location;
import com.locadora.model.Movie;
import com.locadora.model.MovieLocation;

import static com.locadora.mock.ConstantsMock.*;

public class MovieLocationMock {

    public static MovieLocation getMock(Movie movie, Location location) {
        MovieLocation movieLocation = new MovieLocation();
        movieLocation.setId(MOVIE_LOCATION_ID);
        movieLocation.setQuant(MOVIE_LOCATION_QUANT);
        movieLocation.setMovie(movie);
        movieLocation.setLocation(location);
        return movieLocation;
    }
}
