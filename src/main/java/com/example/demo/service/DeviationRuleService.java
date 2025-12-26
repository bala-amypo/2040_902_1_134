package com.example.demo.service;

import com.example.demo.model.DeviationRule;
import java.util.List;

public interface DeviationRuleService {
    DeviationRule updateRule(Long id, DeviationRule rule);
    String getMessage();
    List<DeviationRule> getAllRules();
}
