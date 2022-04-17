package com.ledger.loansysystem;


import java.math.BigDecimal;
import java.util.Map;

public class LoanEntity {
    private BigDecimal payableAmount;
    private int totalEmis;
    private String name;
    private String bankName;
    private BigDecimal pAmount;
    private BigDecimal rate;
    private Integer years;
    private BigDecimal emiAmount;
    private BigDecimal remainingAmount;
    private Map<Integer, BigDecimal> lumpSumpayments;

    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public BigDecimal getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(BigDecimal emiAmount) {
        this.emiAmount = emiAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public int getTotalEmis() {
        return totalEmis;
    }

    public void setTotalEmis(int totalEmis) {
        this.totalEmis = totalEmis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getpAmount() {
        return pAmount;
    }

    public void setpAmount(BigDecimal pAmount) {
        this.pAmount = pAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Map<Integer, BigDecimal> getLumpSumpayments() {
        return lumpSumpayments;
    }

    public void setLumpSumpayments(Map<Integer, BigDecimal> lumpSumpayments) {
        this.lumpSumpayments = lumpSumpayments;
    }
}
