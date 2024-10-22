package com.reliefgenerator.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weekday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "weekday")
    private List<ClassPeriod> classPeriods;

    @JsonIgnore
    @OneToMany(mappedBy = "weekday")
    private List<TeacherPeriod> teacherPeriods;
}
