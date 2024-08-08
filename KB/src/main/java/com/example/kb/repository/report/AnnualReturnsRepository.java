package com.example.kb.repository.report;

import com.example.kb.entity.spring.report.AnnualReturns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnnualReturnsRepository extends JpaRepository<AnnualReturns, Integer> {
    Optional<AnnualReturns> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}