package com.example.demo.controller;

import com.example.demo.service.DeviationRuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviationRuleController {

    private final DeviationRuleService deviationRuleService;

    public DeviationRuleController(DeviationRuleService deviationRuleService) {
        this.deviationRuleService = deviationRuleService;
    }

    @GetMapping("/test")
    public String test() {
        return deviationRuleService.getMessage();
    }
}
