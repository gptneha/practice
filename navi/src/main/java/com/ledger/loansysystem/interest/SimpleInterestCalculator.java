package com.ledger.loansysystem.interest;

import com.ledger.loansysystem.model.LoanRequest;

import java.math.BigDecimal;

public class SimpleInterestCalculator implements Interest {

    @Override
    public BigDecimal getInterest(LoanRequest loanRequest) {
        return  ((loanRequest.getRate().multiply(loanRequest.getpAmount())).divide(new BigDecimal(100))).multiply(BigDecimal.valueOf(loanRequest.getYears()));
    }
}
