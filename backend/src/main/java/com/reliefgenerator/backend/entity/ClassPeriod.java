package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_entity_id", nullable = false)
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "weekday_id", nullable = false)
    private Weekday weekday;

    @ManyToOne
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @OneToOne(mappedBy = "classPeriod")
    private ReliefPeriod reliefPeriod;

    @OneToOne(mappedBy = "classPeriod")
    private TeacherPeriod teacherPeriods;

}
