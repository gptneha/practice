package com.ledger.loansystem.service;

import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.service.LoanService;

import java.math.BigDecimal;

public class LoanServiceTest {

    public static void processRequestTest() {
        LoanService loanService = new LoanService();
        // Given
        String inputText = "LOAN,IDIDI,Dale,10000,5,4";

        // When
        LoanRequest loan = loanService.prepareInput(inputText);

        // Then
        assert "IDIDI".equalsIgnoreCase(loan.getBankName());
        assert "Dale".equalsIgnoreCase(loan.getBankName());
        assert BigDecimal.valueOf(10000).compareTo(loan.getPaymentAmount()) == 0;
        assert 5 == loan.getYears();
        assert BigDecimal.valueOf(4).compareTo(loan.getRate()) == 0;
    }
}
