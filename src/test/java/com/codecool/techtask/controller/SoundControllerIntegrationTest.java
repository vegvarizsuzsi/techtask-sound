package com.codecool.techtask.controller;

import com.codecool.techtask.model.SoundEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SoundControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void handleSelectAllSoundRequest() {
        List<SoundEntity> soundEntities = List.of(
                restTemplate.getForObject("http://localhost:" + port + "/api/sounds/selectAllSound", SoundEntity[].class)
        );
        assertEquals(1, soundEntities.size());
    }


    @Test
    void handleCreateSoundRequest() {
        byte[] data = "newData".getBytes();
        SoundEntity soundEntity = new SoundEntity("sound1", data, ".mp3", LocalDateTime.now());

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<SoundEntity> request = new HttpEntity<>(soundEntity, headers);


        ResponseEntity<SoundEntity> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/api/sounds/createSound",
                HttpMethod.POST,
                request,
                SoundEntity.class
        );

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        SoundEntity createdSound = responseEntity.getBody();
        assertNotNull(createdSound);


    }

    @Test
    void handleModifySoundRequest() {
    }

    @Test
    void handleDeleteSoundRequest() {
        byte[] data = "newData".getBytes();
        SoundEntity soundEntity = new SoundEntity("soundToDelete", data, ".mp3", LocalDateTime.now());
        ResponseEntity<SoundEntity> createResponseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/sounds/createSound",
                soundEntity,
                SoundEntity.class
        );
        assertEquals(HttpStatus.CREATED, createResponseEntity.getStatusCode());

        int soundIdToDelete = createResponseEntity.getBody().getSoundId();
        ResponseEntity<Boolean> deleteResponseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/api/sounds/deleteSound/" + soundIdToDelete,
                HttpMethod.POST,
                null,
                Boolean.class
        );
        assertEquals(HttpStatus.OK, deleteResponseEntity.getStatusCode());
        assertTrue(deleteResponseEntity.getBody());
    }
}