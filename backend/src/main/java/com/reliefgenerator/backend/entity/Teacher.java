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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private Integer number;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String role;


    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Attendance> attendance;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<TeacherPeriod> teacherPeriods;

    @JsonIgnore
    @OneToOne(mappedBy = "teacher")
    private ReliefPeriod reliefPeriod;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<ClassPeriod> classPeriod;

}
