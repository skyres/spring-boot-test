package com.example.app1.service;

import com.example.app1.util.StringUtils;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppServiceTest {


    @Autowired
    private AppService appService;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Summary Test: ")
    void sum() {

        assertEquals(11, appService.sum(5, 6));
        assertEquals(-3, appService.sum(5, -8));

    }

    @Test
    void multiply() {

        assertTrue(StringUtils.isEmpty(StringUtils.emptyString()));

    }
}