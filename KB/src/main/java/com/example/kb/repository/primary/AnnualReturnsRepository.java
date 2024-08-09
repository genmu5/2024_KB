package com.example.kb.repository.primary;

import com.example.kb.entity.spring.report.AnnualReturns;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface AnnualReturnsRepository extends JpaRepository<AnnualReturns, Integer> {
    Optional<AnnualReturns> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}