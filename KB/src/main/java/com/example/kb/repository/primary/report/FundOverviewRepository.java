package com.example.kb.repository.primary.report;

import com.example.kb.entity.spring.report.FundOverview;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface FundOverviewRepository extends JpaRepository<FundOverview, Integer> {
    Optional<FundOverview> findByFundNameAndOperationPeriod(String fundName, String operationPeriod);
}