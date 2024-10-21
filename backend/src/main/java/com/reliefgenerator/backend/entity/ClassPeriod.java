package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_entity_id")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "weekday_id")
    private Weekday weekday;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "classPeriod")
    private List<TeacherPeriod> teacherPeriods;

    @OneToOne(mappedBy = "classPeriod")
    private ReliefPeriod reliefPeriod;


}
