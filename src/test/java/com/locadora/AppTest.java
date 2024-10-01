package com.locadora;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = App.class)
@ActiveProfiles("test")
class AppTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void shouldStartSuccessfully() {
        assertNotNull(applicationContext.getId());
    }
}