package com.locadora.service;

import com.locadora.exception.BusinessException;
import com.locadora.mock.UserMock;
import com.locadora.model.User;
import com.locadora.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

import static com.locadora.mock.ConstantsMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @Mock
    PasswordEncoder encoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        doReturn(Arrays.asList(UserMock.getMock()))
                .when(repository)
                .findAll();

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    void save() {
        User user = UserMock.getMock();

        doReturn(ENCODER_PASS_ENCODED)
                .when(encoder)
                .encode(any(CharSequence.class));

        doReturn(user)
                .when(repository)
                .save(any(User.class));


        User response = service.save(user);

        assertNotNull(response);
    }

    @Test
    void findByEmail() {
        doReturn(UserMock.getMock())
                .when(repository)
                .findByEmail(anyString());

        User response = service.findByEmail(USER_EMAIL);

        assertNotNull(response);
    }

    @Test
    void loadUserByUsername() {
        doReturn(UserMock.getMock())
                .when(repository)
                .findByEmail(anyString());

        UserDetails response = service.loadUserByUsername(USER_EMAIL);

        assertNotNull(response);
    }

    @Test
    void loadUserByUsername_throwUsernameNotFoundException() {
        doReturn(null)
                .when(repository)
                .findByEmail(anyString());

        assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername(USER_EMAIL));
    }
}