package com.ledger.loansysystem.interest;

import com.ledger.loansysystem.model.LoanRequest;

import java.math.BigDecimal;

public interface Interest {

    public BigDecimal getInterest(LoanRequest loanRequest);
}
