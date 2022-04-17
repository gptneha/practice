package com.ledger.loansysystem.service;

import com.ledger.loansysystem.LoanEntity;
import com.ledger.loansysystem.exceptions.InvalidAmountxception;
import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.repository.LoanRepository;
import com.ledger.loansysystem.response.LoanResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PaymentService implements ILoanRequestProcessor {

    public LoanResponse processRequest(String input) {
        LoanRequest loanRequest = prepareInput(input);
        String key = loanRequest.getBankName() + ":" + loanRequest.getName();

        LoanEntity loanEntity = LoanRepository.loanEntityMap.get(key);

        if (loanEntity == null) {
            throw new InvalidRequestInput("No loan found for given input");
        }
        if (loanRequest.getPaymentAmount().compareTo(loanEntity.getRemainingAmount()) > 0) {
            throw new InvalidAmountxception("Pending amount is less than payment request amount");
        }
        //int emiCountCovered = loanRequest.getPaymentAmount().divide(loanEntity.getEmiAmount(), RoundingMode.FLOOR).setScale(0, BigDecimal.ROUND_FLOOR).intValue();
        loanEntity.setRemainingAmount(loanEntity.getRemainingAmount().subtract(loanRequest.getPaymentAmount()));
        Map<Integer, BigDecimal> payments = loanEntity.getLumpSumpayments();
        if (!payments.containsKey(loanRequest.getEmiNumber())) {
            payments.put(loanRequest.getEmiNumber(), BigDecimal.ZERO);
        }

        payments.put(loanRequest.getEmiNumber(), payments.get(loanRequest.getEmiNumber()).add(loanRequest.getPaymentAmount()));
        LoanRepository.loanEntityMap.put(key, loanEntity);
        return LoanResponse.buildSuccess();
    }

    private LoanRequest prepareInput(String input) {
        try {
            if (input == null) {
                throw new InvalidRequestInput("Request is invalid");
            }

            List<String> inputs = Arrays.asList(input.split(","));

            if (inputs == null || inputs.size() < 5) {
                throw new InvalidRequestInput("Request is invalid");
            }

            LoanRequest loanRequest = new LoanRequest();
            loanRequest.setAction(inputs.get(0));
            loanRequest.setBankName(inputs.get(1));
            loanRequest.setName(inputs.get(2));
            loanRequest.setPaymentAmount(new BigDecimal(inputs.get(3)));
            loanRequest.setEmiNumber(Integer.valueOf(inputs.get(4)));
            return loanRequest;
        } catch (Exception e) {
            throw new InvalidRequestInput("Request is invalid");
        }
    }
}
