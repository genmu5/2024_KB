package com.example.kb.entity.spring.report;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "fund_overview")
public class FundOverview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fund_ID")
    private Integer fundId;

    @Column(name = "fund_name")
    private String fundName;

    @Column(name = "operation_period")
    private String operationPeriod;

    @Column(name = "fund_type")
    private String fundType;

    @Column(name = "initial_setting_date")
    private Date initialSettingDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "operation_size")
    private BigDecimal operationSize;

    @Column(name = "setting_date")
    private Date settingDate;

    @Column(name = "risk_level")
    private String riskLevel;

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getOperationPeriod() {
        return operationPeriod;
    }

    public void setOperationPeriod(String operationPeriod) {
        this.operationPeriod = operationPeriod;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public Date getInitialSettingDate() {
        return initialSettingDate;
    }

    public void setInitialSettingDate(Date initialSettingDate) {
        this.initialSettingDate = initialSettingDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public BigDecimal getOperationSize() {
        return operationSize;
    }

    public void setOperationSize(BigDecimal operationSize) {
        this.operationSize = operationSize;
    }

    public Date getSettingDate() {
        return settingDate;
    }

    public void setSettingDate(Date settingDate) {
        this.settingDate = settingDate;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    // Getters and Setters
}