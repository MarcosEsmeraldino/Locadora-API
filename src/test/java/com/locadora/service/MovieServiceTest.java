package com.locadora.service;

import com.locadora.mock.MovieMock;
import com.locadora.model.Movie;
import com.locadora.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.locadora.mock.ConstantsMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

class MovieServiceTest {

    @InjectMocks
    MovieService service;

    @Mock
    MovieRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        doReturn(Arrays.asList(MovieMock.getMock()))
                .when(repository)
                .findAll();

        List<Movie> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void save() {
        doReturn(MovieMock.getMock())
                .when(repository)
                .save(any(Movie.class));

        Movie response = service.save(MovieMock.getMock());

        assertNotNull(response);
    }

    @Test
    void searchAvailable() {
        doReturn(Arrays.asList(MovieMock.getMock()))
                .when(repository)
                .searchAvailable();

        List<Movie> response = service.searchAvailable();

        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void searchByTitle() {
        doReturn(Arrays.asList(MovieMock.getMock()))
                .when(repository)
                .searchByTitle(anyString());

        List<Movie> response = service.searchByTitle(MOVIE_TITLE);

        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void findById() {
        doReturn(Optional.of(MovieMock.getMock()))
                .when(repository)
                .findById(anyLong());

        Optional<Movie> response = service.findById(MOVIE_ID);

        assertTrue(response.isPresent());
    }
}