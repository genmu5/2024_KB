package com.example.kb.controller.django.report;

import com.example.kb.dto.spring.FundReportResponse;
import com.example.kb.service.spring.report.FundApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundReportDataApiController {

    @Autowired
    private FundApiService fundApiService;

    @GetMapping("/api/fund-report")
    public FundReportResponse getFundReportData(
            @RequestParam String fundName,
            @RequestParam String operationPeriod) {

        return fundApiService.getFundReportData(fundName, operationPeriod);
    }
}
