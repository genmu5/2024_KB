package com.example.kb.repository.primary.report;

import com.example.kb.entity.spring.report.OperationPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationPlanRepository extends JpaRepository<OperationPlan, Integer> {
    Optional<OperationPlan> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}
