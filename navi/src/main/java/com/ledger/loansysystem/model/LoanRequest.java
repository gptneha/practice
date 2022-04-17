package com.ledger.loansysystem.model;

import java.math.BigDecimal;

//Request can also have a parent class and then extra fields will be in different child classes
public class LoanRequest {
    private String name;
    private String action;
    private String bankName;
    private BigDecimal pAmount;
    private BigDecimal rate;
    private Integer years;
    private int emiNumber;
    private BigDecimal paymentAmount;

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public int getEmiNumber() {
        return emiNumber;
    }

    public void setEmiNumber(int emiNumber) {
        this.emiNumber = emiNumber;
    }
}
