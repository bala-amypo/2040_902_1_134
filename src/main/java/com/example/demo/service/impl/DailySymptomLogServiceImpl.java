package com.example.demo.service.impl;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.stereotype.Service;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository repository;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public DailySymptomLog createLog(DailySymptomLog log) {
        return repository.save(log);
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog log) {
        log.setId(id);
        return repository.save(log);
    }
}
