package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekdayRepository extends JpaRepository<Weekday, Long> {

}
