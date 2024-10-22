package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.repository.WeekdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekdayService {
    @Autowired
    private WeekdayRepository weekdayRepository;

    public List<Weekday> getAllWeekdays() {
        return weekdayRepository.findAll();
    }

    public Weekday saveWeekday(Weekday weekday) {
        return weekdayRepository.save(weekday);
    }
}
