package com.locadora.service;

import com.locadora.exception.BusinessException;
import com.locadora.mock.LocationMock;
import com.locadora.mock.MovieLocationMock;
import com.locadora.mock.MovieMock;
import com.locadora.model.Location;
import com.locadora.model.Movie;
import com.locadora.model.MovieLocation;
import com.locadora.repository.LocationRepository;
import com.locadora.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static com.locadora.mock.ConstantsMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

class LocationServiceTest {

    @InjectMocks
    LocationService service;

    @Mock
    LocationRepository repository;

    @Mock
    MovieRepository mRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void startLocation() {

        Movie movie = MovieMock.getMock();
        Location location = LocationMock.getMock();
        List<MovieLocation> movies = Arrays.asList(MovieLocationMock.getMock(movie, location));
        location.setMovies(movies);

        doReturn(movie)
                .when(mRepository)
                .getOne(anyLong());

        doReturn(movie)
                .when(mRepository)
                .save(any(Movie.class));

        doReturn(location)
                .when(repository)
                .save(any(Location.class));


        Location response = service.startLocation(location);


        assertNotNull(response);

    }

    @Test
    void finishLocation() {
        Movie movie = MovieMock.getMock();
        Location location = LocationMock.getMock();
        List<MovieLocation> movies = Arrays.asList(MovieLocationMock.getMock(movie, location));
        location.setMovies(movies);
        location.setFinishDate(null);

        doReturn(location)
                .when(repository)
                .getOne(anyLong());

        doReturn(movie)
                .when(mRepository)
                .getOne(anyLong());

        doReturn(movie)
                .when(mRepository)
                .save(any(Movie.class));

        doReturn(location)
                .when(repository)
                .save(any(Location.class));


        Location response = service.finishLocation(LOCATION_ID);


        assertNotNull(response);
    }

    @Test
    void finishLocation_throwBusinessException() {
        Location location = LocationMock.getMock();

        doReturn(location)
                .when(repository)
                .getOne(anyLong());


        assertThrows(BusinessException.class, () -> service.finishLocation(LOCATION_ID));
    }
}