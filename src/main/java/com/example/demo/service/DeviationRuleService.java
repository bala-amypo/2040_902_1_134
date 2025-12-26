package com.example.demo.service;

import com.example.demo.model.DeviationRule;

public interface DeviationRuleService {
    DeviationRule updateRule(Long id, DeviationRule rule);
    String getMessage();
}
