package com.reliefgenerator.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReliefPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "class_period_id", nullable = false)
    private ClassPeriod classPeriod;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
