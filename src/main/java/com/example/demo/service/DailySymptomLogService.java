package com.example.demo.service;

import com.example.demo.model.DailySymptomLog;

public interface DailySymptomLogService {

    // matches test case exactly
    DailySymptomLog createLog(DailySymptomLog log);

    DailySymptomLog updateSymptomLog(Long id, DailySymptomLog log);
}
