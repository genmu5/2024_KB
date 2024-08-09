package com.example.kb.dto.django;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FundReportRequest {
    private String fundName;
    private String operationPeriod; // 수정된 부분
    private List<String> newsSummaries;
}
