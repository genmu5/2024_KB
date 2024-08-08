package com.example.kb.repository.report;


import com.example.kb.entity.spring.report.FundNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FundNamesRepository extends JpaRepository<FundNames, Long> {
    Optional<FundNames> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}