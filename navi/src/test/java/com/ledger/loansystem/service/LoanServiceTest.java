package com.ledger.loansystem.service;

import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.response.LoanResponse;
import com.ledger.loansysystem.service.LoanService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class LoanServiceTest {

    @Test
    public void prepareInputTest() {
        LoanService loanService = new LoanService();
        // Given
        String inputText = "LOAN,IDIDI,Dale,10000,5,4";

        // When
        LoanRequest loan = loanService.prepareInput(inputText);

        // Then
        assert "IDIDI".equalsIgnoreCase(loan.getBankName());
        assert "Dale".equalsIgnoreCase(loan.getName());
        assert BigDecimal.valueOf(10000).compareTo(loan.getpAmount()) == 0;
        assert 5 == loan.getYears();
        assert BigDecimal.valueOf(4).compareTo(loan.getRate()) == 0;
    }

    @Test
    public void checkForInvalidInput() {
        // Given
        String inputText = "LOAN,IDIDI,Dale,10000,5";

        // When
        LoanService loanService = new LoanService();
        try {
            LoanRequest loan = loanService.prepareInput(inputText);
        } catch (Exception e) {
            Assert.assertEquals(InvalidRequestInput.class, e.getClass());
        }
    }

    @Test
    public void processRequestTest() {
        LoanService loanService = new LoanService();
        // Given
        String inputText = "LOAN,IDIDI,Dale,10000,5,4";

        // When
        LoanResponse loanResponse = loanService.processRequest(inputText);
        Assert.assertEquals(true, loanResponse.isSuccess());
    }

}
