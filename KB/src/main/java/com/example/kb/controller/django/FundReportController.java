package com.example.kb.controller.django;

import com.example.kb.dto.django.FundReportRequest;
import com.example.kb.service.django.FundReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funds")
public class FundReportController {

    private final FundReportService fundReportService;

    @Autowired
    public FundReportController(FundReportService fundReportService) {
        this.fundReportService = fundReportService;
    }

    @PostMapping("/generate-report")
    public ResponseEntity<String> generateFundReport(@RequestBody FundReportRequest request) {
        try {
            String report = fundReportService.generateFundReport(
                    request.getFundName(),
                    request.getStartDate(),
                    request.getEndDate(),
                    request.getNewsSummaries()
            );
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating report: " + e.getMessage());
        }
    }
}
