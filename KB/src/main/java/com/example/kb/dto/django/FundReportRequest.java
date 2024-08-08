package com.example.kb.dto.django;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FundReportRequest {
    private String fundName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<String> newsSummaries;
}
