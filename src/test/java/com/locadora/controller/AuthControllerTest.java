package com.locadora.controller;

import com.locadora.mock.UserMock;
import com.locadora.model.User;
import com.locadora.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

class AuthControllerTest {

    @InjectMocks
    AuthController controller;

    @Mock
    AuthService aService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login() {
        User user = UserMock.getMock();
        doReturn(user)
                .when(aService)
                .login(anyString(), anyString());

        User response = controller.login(user);

        assertNotNull(response);
    }

    @Test
    void logout() {
        doNothing()
                .when(aService)
                .logout();

        controller.logout();
    }
}