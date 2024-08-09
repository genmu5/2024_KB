package com.example.kb.service.spring.report;
import com.example.kb.entity.spring.report.*;

import com.example.kb.repository.primary.report.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundService {

    private final FundOverviewRepository fundOverviewRepository;
    private final FundNamesRepository fundNamesRepository;
    private final FundResultRepository fundResultRepository;
    private final AnnualReturnsRepository annualReturnsRepository;
    private final ClassPriceStatusRepository classPriceStatusRepository;
    private final MarketStatusRepository marketRepository;
    private final OperationPlanRepository operationPlanRepository;
    private final OperationResultsRepository operationResultsRepository;

    public FundService(FundOverviewRepository fundOverviewRepository, FundNamesRepository fundNamesRepository, FundResultRepository fundResultRepository, AnnualReturnsRepository annualReturnsRepository, ClassPriceStatusRepository classPriceStatusRepository, MarketStatusRepository marketRepository, OperationPlanRepository operationPlanRepository, OperationResultsRepository operationResultsRepository) {
        this.fundOverviewRepository = fundOverviewRepository;
        this.fundNamesRepository = fundNamesRepository;
        this.fundResultRepository = fundResultRepository;
        this.annualReturnsRepository = annualReturnsRepository;
        this.classPriceStatusRepository = classPriceStatusRepository;
        this.marketRepository = marketRepository;
        this.operationPlanRepository = operationPlanRepository;
        this.operationResultsRepository = operationResultsRepository;
    }

    public FundOverview getFundOverview(String fundName, String operationPeriod) {
        return fundOverviewRepository.findByFundNameAndOperationPeriod(fundName, operationPeriod)
                .orElse(null);
    }

    public FundNames getFundNames(String fundName, String operationPeriod) {
        return fundNamesRepository.findByFundNameAndOperationPeriod(fundName, operationPeriod)
                .orElse(null);
    }

    public FundResult getFundResult(String fundName, String operationPeriod) {
        return fundResultRepository.findByFundNameAndOperationPeriod(fundName, operationPeriod)
                .orElse(null);
    }

    public AnnualReturns getAnnualReturns(String fundName, String operationPeriod) {
        return annualReturnsRepository.findByFundNameAndOperationPeriod(fundName, operationPeriod)
                .orElse(null);
    }

    public List<ClassPriceStatus> getClassPriceStatusByFundNameAndOperationPeriod(String fundName, String operationPeriod) {
        return classPriceStatusRepository.findClassPriceStatus(fundName, operationPeriod);
    }

    public List<MarketStatus> getMarketStatusByFundNameAndOperationPeriod(String fundName, String operationPeriod) {
        return marketRepository.findByFundNameAndOperationPeriod(fundName, operationPeriod);
    }

    public OperationPlan getOperationPlan(String fundName, String operationPeriod) {
        return operationPlanRepository.findByFundNameAndOperationPeriod(fundName, operationPeriod)
                .orElse(null);
    }

    public OperationResults getOperationResults(String fundName, String operationPeriod) {
        return operationResultsRepository.findByFundNameAndOperationPeriod(fundName,operationPeriod)
                .orElse(null);
    }

}
