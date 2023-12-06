package com.codecool.techtask.service;

import com.codecool.techtask.model.SoundEntity;
import com.codecool.techtask.repository.SoundRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SoundService {

    private final SoundRepository soundRepository;

    @Autowired
    public SoundService(SoundRepository soundRepository) {
        this.soundRepository = soundRepository;
    }

    public List<SoundEntity> getAllSounds(){
        return soundRepository.findAll();
    }
    public SoundEntity createSound(SoundEntity entity) {
        return soundRepository.save(entity);
    }
    @Transactional
    public SoundEntity modifySound(Integer id, SoundEntity soundEntity){
        SoundEntity soundEntityToModify = soundRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        soundEntityToModify.setSoundName(soundEntity.getSoundName());
        soundEntityToModify.setSoundData(soundEntity.getSoundData());
        soundEntityToModify.setSoundExtension(soundEntity.getSoundExtension());
        soundEntityToModify.setSoundUpdatedDatetime(LocalDateTime.now());
        soundRepository.save(soundEntityToModify);
        return soundEntityToModify;
    }

    public boolean deleteSoundById(Integer id){
        soundRepository.deleteById(id);
        return true;
    }



}