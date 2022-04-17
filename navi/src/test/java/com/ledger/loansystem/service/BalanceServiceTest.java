package com.ledger.loansystem.service;

import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.response.BalanceResponse;
import com.ledger.loansysystem.response.LoanResponse;
import com.ledger.loansysystem.service.BalanceService;
import com.ledger.loansysystem.service.LoanService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceServiceTest {

    @Test
    public void processRequest() {
        //Given
        LoanService loanService = new LoanService();
        String inputText = "LOAN,IDIDI,Dale,10000,5,4";
        loanService.processRequest(inputText);

        BalanceService balanceService = new BalanceService();
        String inputTextBalance = "BALANCE,IDIDI,Dale,5";

        // When
        LoanResponse loan = balanceService.processRequest(inputTextBalance);

        // Then
        Assert.assertEquals(true, loan.isSuccess());
        Assert.assertNotNull(loan.getData());
        Assert.assertEquals(BalanceResponse.class, loan.getData().getClass());
        Assert.assertEquals(BigDecimal.valueOf(1000), ((BalanceResponse)loan.getData()).getPaidAmount());
    }

    @Test
    public void checkForInvalidInput() {
        // Given
        String inputText = "BALANCE,IDIDI,Dale,10000,5";

        // When
        BalanceService balanceService = new BalanceService();
        try {
            LoanRequest loan = balanceService.prepareInput(inputText);
        } catch (Exception e) {
            Assert.assertEquals(InvalidRequestInput.class, e.getClass());
        }
    }

    @Test
    public void checkForValidInput() {
        BalanceService balanceService = new BalanceService();
        // Given
        String inputText = "BALANCE,IDIDI,Dale,5";

        // When
        LoanRequest loanRequest = balanceService.prepareInput(inputText);
        // Then
        assert "IDIDI".equalsIgnoreCase(loanRequest.getBankName());
        assert "Dale".equalsIgnoreCase(loanRequest.getName());
        assert 5 == loanRequest.getEmiNumber();
    }
}
