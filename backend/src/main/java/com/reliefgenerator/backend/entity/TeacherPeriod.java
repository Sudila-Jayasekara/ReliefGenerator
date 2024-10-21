package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;

@Entity
public class TeacherPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean is_free;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "weekday_id")
    private Weekday weekday;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @ManyToOne
    @JoinColumn(name = "class_period_id")
    private ClassPeriod classPeriod;
}
