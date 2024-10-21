package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private Boolean isPresent;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
