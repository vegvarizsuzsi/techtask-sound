package com.codecool.techtask.service;

import com.codecool.techtask.model.SoundEntity;
import com.codecool.techtask.repository.SoundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SoundServiceTest {

    @Mock
    private SoundRepository soundRepository;
    private SoundService serviceTest;
    @BeforeEach
    public void setUp(){
        serviceTest = new SoundService(soundRepository);
    }

    @Test
    void getAllSounds() {
        when(soundRepository.findAll()).thenReturn(List.of());
        List<SoundEntity> testResult = serviceTest.getAllSounds();
        assertEquals(0, testResult.size());
    }

    @Test
    void createSound() {
        byte[] data = "newData".getBytes();
        SoundEntity sound = new SoundEntity("sound1", data, ".mp3", LocalDateTime.now());

        when(soundRepository.save(any(SoundEntity.class))).thenReturn(sound);

        SoundEntity testResult = serviceTest.createSound(sound);
        verify(soundRepository, times(1)).save(any(SoundEntity.class));
        assertNotNull(testResult);
        assertEquals(sound.getSoundId(), testResult.getSoundId());
    }

    @Test
    void modifySound() {
        int soundId = 1;
        byte[] data = "newData".getBytes();
        SoundEntity existingSound = new SoundEntity("existingSound", data, ".mp3", LocalDateTime.now());
        SoundEntity modifiedSound = new SoundEntity("modifiedSound", data, ".mp3", LocalDateTime.now());

        when(soundRepository.findById(eq(soundId))).thenReturn(Optional.of(existingSound));
        when(soundRepository.save(any(SoundEntity.class))).thenReturn(modifiedSound);

        SoundEntity testResult = serviceTest.modifySound(soundId, modifiedSound);

        verify(soundRepository, times(1)).findById(eq(soundId));
        verify(soundRepository, times(1)).save(any(SoundEntity.class));
        assertNotNull(testResult);
        assertEquals(testResult.getSoundName(), modifiedSound.getSoundName());
    }

    @Test
    void deleteSoundById() {
        doNothing().when(soundRepository).deleteById(anyInt());
        boolean testResult = serviceTest.deleteSoundById(1);
        verify(soundRepository, atLeastOnce()).deleteById(eq(1));
        assertTrue(testResult);
    }


}