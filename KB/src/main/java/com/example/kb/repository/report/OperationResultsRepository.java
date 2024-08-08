package com.example.kb.repository.report;

import com.example.kb.entity.spring.report.OperationResults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationResultsRepository extends JpaRepository<OperationResults, Integer> {
    Optional<OperationResults> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}
