package com.example.demo.service.impl;

import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    @Override
    public String getMessage() {
        return "Deviation Rule Service is working";
    }
}
