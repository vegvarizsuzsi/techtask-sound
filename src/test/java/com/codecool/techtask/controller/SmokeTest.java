package com.codecool.techtask.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private SoundController soundController;

    @Test
    void contextLoads() throws Exception {
        assertThat(soundController).isNotNull();
    }
}
