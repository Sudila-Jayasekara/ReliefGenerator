package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("SELECT a FROM Attendance a WHERE a.isPresent = false AND DATE(a.dateTime) = DATE(:today)")
    List<Attendance> findAbsentTeachersToday(@Param("today") LocalDate today);

}
