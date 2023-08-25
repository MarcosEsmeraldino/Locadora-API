package com.locadora.controller;

import com.locadora.mock.LocationMock;
import com.locadora.model.Location;
import com.locadora.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

class LocationControllerTest {

    @InjectMocks
    LocationController controller;

    @Mock
    LocationService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        doReturn(LocationMock.getMock())
                .when(service)
                .startLocation(any(Location.class));

        doReturn(LocationMock.getMock())
                .when(service)
                .finishLocation(anyLong());
    }

    @Test
    void startLocation() {
        Location response = controller.startLocation(LocationMock.getMock());
        assertNotNull(response);
    }

    @Test
    void finishLocation() {
        Location response = controller.finishLocation(LocationMock.getMock());
        assertNotNull(response);
    }
}