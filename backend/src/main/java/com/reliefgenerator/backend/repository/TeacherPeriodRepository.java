package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPeriodRepository extends JpaRepository<TeacherPeriod, Long> {
}
