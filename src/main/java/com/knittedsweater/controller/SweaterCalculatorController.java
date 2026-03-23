package com.knittedsweater.controller;

import com.knittedsweater.dto.SweaterCalculationRequest;
import com.knittedsweater.dto.SweaterCalculationResponse;
import com.knittedsweater.service.SweaterCalculationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for sweater calculation endpoints.
 */
@RestController
@RequestMapping("/api/sweater")
public class SweaterCalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(SweaterCalculatorController.class);

    private final SweaterCalculationService calculationService;

    public SweaterCalculatorController(SweaterCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<SweaterCalculationResponse> calculate(
            @Valid @RequestBody SweaterCalculationRequest request
    ) {
        LOG.info("Calculation request received");
        SweaterCalculationResponse response = calculationService.calculate(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Service is running");
    }
}
