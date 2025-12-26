package com.example.demo.service.impl;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    @Override
    public String getMessage() {
        // Return some default message for test cases
        return "Deviation rule message";
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return repository.findAll();
    }
}
