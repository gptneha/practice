package com.ledger.loansystem.service;

import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.response.LoanResponse;
import com.ledger.loansysystem.service.LoanService;
import com.ledger.loansysystem.service.PaymentService;
import org.junit.Assert;
import org.junit.Test;


public class PaymentServiceTest {
    @Test
    public void prepareInputTest() {
        PaymentService paymentService = new PaymentService();
        // Given
        String inputText = "PAYMENT,IDIDI,Dale,1000,5";

        // When
        LoanRequest loan = paymentService.prepareInput(inputText);

        // Then
        assert "IDIDI".equalsIgnoreCase(loan.getBankName());
        assert "Dale".equalsIgnoreCase(loan.getName());
        assert 5 == loan.getEmiNumber();
    }

    @Test
    public void checkForInvalidInput() {
        // Given
        String inputText = "PAYMENT,IDIDI,Dale,10000,5";

        // When
        PaymentService loanService = new PaymentService();
        try {
            LoanRequest loan = loanService.prepareInput(inputText);
        } catch (Exception e) {
            Assert.assertEquals(InvalidRequestInput.class, e.getClass());
        }
    }

    @Test
    public void processRequestTest() {
        LoanService loanService = new LoanService();
        String inputText = "LOAN,IDIDI,Dale,10000,5,4";
        loanService.processRequest(inputText);

        PaymentService paymentService = new PaymentService();
        // Given
        String inputTextPayment = "PAYMENT,IDIDI,Dale,1000,5";

        // When
        LoanResponse loanResponse = paymentService.processRequest(inputTextPayment);
        Assert.assertEquals(true, loanResponse.isSuccess());
    }

}
