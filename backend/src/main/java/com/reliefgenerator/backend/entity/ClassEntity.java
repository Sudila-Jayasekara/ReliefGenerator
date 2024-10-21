package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer grade;
    private String classLetter;

    @OneToMany(mappedBy = "classEntity")
    private List<ClassPeriod> classPeriods;

}
