package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer number;
    private String subject;
    private String role;

    @OneToMany(mappedBy = "teacher")
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "teacher")
    private List<ClassPeriod> classPeriods;

    @OneToMany(mappedBy = "teacher")
    private List<TeacherPeriod> teacherPeriods;

    @OneToOne(mappedBy = "teacher")
    private ReliefPeriod reliefPeriod;

}
