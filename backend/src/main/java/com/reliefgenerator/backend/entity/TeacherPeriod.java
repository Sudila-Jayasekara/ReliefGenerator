package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean is_free;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "weekday_id", nullable = false)
    private Weekday weekday;

    @ManyToOne
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;

    @OneToOne
    @JoinColumn(name = "class_period_id")
    private ClassPeriod classPeriod;
}
