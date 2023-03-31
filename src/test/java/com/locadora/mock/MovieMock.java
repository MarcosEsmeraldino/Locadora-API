package com.locadora.mock;

import com.locadora.model.Movie;

import static com.locadora.mock.ConstantsMock.*;

public class MovieMock {

    public static Movie getMock() {
        Movie movie = new Movie();
        movie.setId(MOVIE_ID);
        movie.setStock(MOVIE_STOCK);
        movie.setDirector(MOVIE_DIRECTOR);
        movie.setTitle(MOVIE_TITLE);
        return movie;
    }
}
