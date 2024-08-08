package com.example.kb.repository.report;

import com.example.kb.entity.spring.report.MarketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketStatusRepository extends JpaRepository<MarketStatus, Integer> {
    List<MarketStatus> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}
