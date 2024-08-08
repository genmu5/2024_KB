package com.example.kb.repository.report;

import com.example.kb.entity.spring.report.FundOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FundOverviewRepository extends JpaRepository<FundOverview, Integer> {
    Optional<FundOverview> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);

}