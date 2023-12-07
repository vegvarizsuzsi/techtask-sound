package com.codecool.techtask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;




@Entity
@Table(name = "sound")
@Getter
@Setter
public class SoundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer soundId;

    @Column(nullable = false)
    private String soundName;

    @Lob
    @Column(nullable = false)
    private byte[] soundData;

    @Column(nullable = false)
    private String soundExtension;

    @Column(nullable = false)
    private LocalDateTime soundCreatedDatetime;
    private LocalDateTime soundUpdatedDatetime;

    public SoundEntity() {
    }


    public SoundEntity(String soundName, byte[] soundData, String soundExtension, LocalDateTime soundCreatedDatetime) {
        this.soundName = soundName;
        this.soundData = soundData;
        this.soundExtension = soundExtension;
        this.soundCreatedDatetime = LocalDateTime.now();
    }


}

