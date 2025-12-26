package com.example.demo.service.impl;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;

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
        return repository.findAll().stream()
                .map(DeviationRule::getMessage)
                .findFirst().orElse("");
    }
}
