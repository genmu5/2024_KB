package com.example.kb.repository.primary;


import com.example.kb.entity.spring.report.FundClassPrice;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface FundClassPriceRepository extends JpaRepository<FundClassPrice, Integer> {
}