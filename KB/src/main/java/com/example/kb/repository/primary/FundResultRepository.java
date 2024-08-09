package com.example.kb.repository.primary;

import com.example.kb.entity.spring.report.FundResult;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface FundResultRepository extends JpaRepository<FundResult, Long> {
    Optional<FundResult> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}