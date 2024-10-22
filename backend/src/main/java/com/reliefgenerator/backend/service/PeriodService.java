package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.Period;
import com.reliefgenerator.backend.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {
    @Autowired
    private PeriodRepository periodRepository;

    public List<Period> getAllPeriods() {
        return periodRepository.findAll();
    }

    public Period savePeriod(Period period) {
        return periodRepository.save(period);
    }
}
