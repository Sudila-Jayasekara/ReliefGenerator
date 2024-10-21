package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ReliefPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "class_period_id")
    private ClassPeriod classPeriod;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
