package com.ledger.loansysystem.service;

import com.ledger.loansysystem.response.LoanResponse;

public interface ILoanRequestProcessor {

    LoanResponse processRequest(String input);
}
