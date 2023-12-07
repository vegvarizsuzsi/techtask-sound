package com.codecool.techtask.controller;

import com.codecool.techtask.service.SoundService;
import com.codecool.techtask.model.SoundEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("api/sounds")
public class SoundController {

    private final SoundService soundService;

    @Autowired
    public SoundController(SoundService soundService) {
        this.soundService = soundService;
    }


    @PostMapping("/selectAllSound")
    public List<SoundEntity> handleSelectAllSoundRequest() {
        return soundService.getAllSounds();
    }

    @PostMapping("/createSound")
    public ResponseEntity<SoundEntity> handleCreateSoundRequest(@RequestBody SoundEntity soundEntity) {
        SoundEntity createdSound = soundService.createSound(soundEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSound);
    }

    @PostMapping("/modifySound/{id}")
    public ResponseEntity<SoundEntity> handleModifySoundRequest(@PathVariable Integer id, @RequestBody SoundEntity soundEntity) {
        try {
            return ResponseEntity.ok(soundService.modifySound(id, soundEntity));
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/deleteSound/{id}")
    public ResponseEntity<Boolean> handleDeleteSoundRequest(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(soundService.deleteSoundById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }


}