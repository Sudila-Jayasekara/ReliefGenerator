package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "period")
    private List<ClassPeriod> classPeriods;

    @OneToMany(mappedBy = "period")
    private List<TeacherPeriod> teacherPeriods;
}
