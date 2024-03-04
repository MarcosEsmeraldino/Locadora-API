package com.locadora.service;

import com.locadora.mock.UserMock;
import com.locadora.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static com.locadora.mock.ConstantsMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @InjectMocks
    AuthService service;

    @Mock
    UserService uService;

    @Mock
    AuthenticationManager authManager;

    @Mock
    Authentication authentication;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpSession httpSession;

    @Mock
    SecurityContext securityContext;

    @Mock
    AnonymousAuthenticationToken anonymousAuthenticationToken;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void login() {
        doReturn(UserMock.getMock())
                .when(uService)
                .findByEmail(anyString());

        doReturn(authentication)
                .when(authManager)
                .authenticate(any(UsernamePasswordAuthenticationToken.class));

        doReturn(httpSession)
                .when(request)
                .getSession(true);


        User response = service.login(USER_EMAIL, USER_PASS);


        assertNotNull(response);
        assertEquals(USER_EMAIL, response.getEmail());
        assertEquals(USER_PASS, response.getPass());
        assertEquals(USER_NAME, response.getName());
        assertEquals(USER_ID, response.getId());
    }

    @Test
    void login_throwUsernameNotFoundException() {
        doReturn(null)
                .when(uService)
                .findByEmail(anyString());


        assertThrows(UsernameNotFoundException.class, () -> service.login(USER_EMAIL, USER_PASS));
    }

    @Test
    void login_tokenIsNotAuthenticated() {
        doReturn(UserMock.getMock())
                .when(uService)
                .findByEmail(anyString());

        doReturn(authentication)
                .when(authManager)
                .authenticate(any(UsernamePasswordAuthenticationToken.class));

        try (MockedConstruction<UsernamePasswordAuthenticationToken> mocked = mockConstruction(UsernamePasswordAuthenticationToken.class,
                (mock, context) -> {
            when(mock.isAuthenticated()).thenReturn(false);
        })) {

            User response = service.login(USER_EMAIL, USER_PASS);

            assertNull(response);
        }
    }

    @Test
    void logout() {
        doReturn(httpSession)
                .when(request)
                .getSession(true);

        service.logout();
    }

    @Test
    void logout_throwUsernameNotFoundException() {
        mockStatic(SecurityContextHolder.class);
        when(SecurityContextHolder.getContext())
                .thenReturn(securityContext);

        doReturn(anonymousAuthenticationToken)
                .when(securityContext)
                .getAuthentication();


        assertThrows(UsernameNotFoundException.class, () -> service.logout());
    }
}