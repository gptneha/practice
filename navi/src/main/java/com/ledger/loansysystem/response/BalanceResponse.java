package com.ledger.loansysystem.response;

import java.math.BigDecimal;

public class BalanceResponse {

    private String name;
    private String bankName;
    private BigDecimal paidAmount;
    private int emiNumber;

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

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getEmiNumber() {
        return emiNumber;
    }

    public void setEmiNumber(int emiNumber) {
        this.emiNumber = emiNumber;
    }
}
