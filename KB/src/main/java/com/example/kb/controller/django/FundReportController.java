package com.example.kb.controller.django;

import com.example.kb.dto.django.FundReportRequest;
import com.example.kb.service.spring.report.OperationPlanService;
import com.example.kb.service.spring.report.OperationResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funds")
public class FundReportController {

    private final OperationPlanService operationPlanService;
    private final OperationResultsService operationResultsService;

    @Autowired
    public FundReportController(OperationPlanService operationPlanService, OperationResultsService operationResultsService) {
        this.operationPlanService = operationPlanService;
        this.operationResultsService = operationResultsService;
    }

    @PostMapping("/generate-plan")
    public ResponseEntity<String> generateOperationPlan(@RequestBody FundReportRequest request) {
        try {
            String planDetails = operationPlanService.generateAndSaveOperationPlan(
                    request.getFundName(),
                    request.getOperationPeriod(),
                    request.getNewsSummaries()
            );
            return ResponseEntity.ok(planDetails);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating operation plan: " + e.getMessage());
        }
    }

    @PostMapping("/generate-results")
    public ResponseEntity<String> generateOperationResults(@RequestBody FundReportRequest request) {
        try {
            String commentary = operationResultsService.generateAndSaveOperationResults(
                    request.getFundName(),
                    request.getOperationPeriod(),
                    request.getNewsSummaries()
            );
            return ResponseEntity.ok(commentary);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating operation results: " + e.getMessage());
        }
    }
}
