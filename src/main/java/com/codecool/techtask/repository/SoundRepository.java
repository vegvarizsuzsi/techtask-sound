package com.codecool.techtask.repository;


import com.codecool.techtask.model.SoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundRepository extends JpaRepository<SoundEntity, Integer> {

    
}