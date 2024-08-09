package com.example.kb.repository.primary;

import com.example.kb.entity.spring.report.OperationResults;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface OperationResultsRepository extends JpaRepository<OperationResults, Integer> {
    Optional<OperationResults> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}
