package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Weekday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "weekday")
    private List<ClassPeriod> classPeriods;

    @OneToMany(mappedBy = "weekday")
    private List<TeacherPeriod> teacherPeriods;
}
