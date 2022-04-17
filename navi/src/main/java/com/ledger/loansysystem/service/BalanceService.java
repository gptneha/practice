package com.ledger.loansysystem.service;

import com.ledger.loansysystem.LoanEntity;
import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.repository.LoanRepository;
import com.ledger.loansysystem.response.BalanceResponse;
import com.ledger.loansysystem.response.LoanResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BalanceService implements ILoanRequestProcessor {

    public LoanResponse processRequest(String input) {
        LoanRequest loanRequest = prepareInput(input);
        String key = loanRequest.getBankName() + ":" + loanRequest.getName();

        LoanEntity loanEntity = LoanRepository.loanEntityMap.get(key);

        if (loanEntity == null) {
            throw new InvalidRequestInput("No loan found for given input");
        }
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBankName(loanEntity.getBankName());
        balanceResponse.setName(loanEntity.getName());
        BigDecimal paidAmountByEmi = loanEntity.getEmiAmount().multiply(BigDecimal.valueOf(loanRequest.getEmiNumber()));
        int emiRemaining = loanEntity.getTotalEmis() - loanRequest.getEmiNumber();
        Map<Integer, BigDecimal> payments = loanEntity.getLumpSumpayments();
        if (payments.size() != 0) {
            for (Integer integer : payments.keySet()) {
                if (integer <= loanRequest.getEmiNumber()) {
                    paidAmountByEmi = paidAmountByEmi.add(payments.get(integer));
                    int emiCountCovered = payments.get(integer).divide(loanEntity.getEmiAmount(), RoundingMode.FLOOR).setScale(0, BigDecimal.ROUND_FLOOR).intValue();
                    emiRemaining = emiRemaining - emiCountCovered;
                }
            }
        }
        balanceResponse.setPaidAmount(paidAmountByEmi);
        balanceResponse.setEmiNumber(emiRemaining);
        return LoanResponse.buildSuccess(balanceResponse);
    }

    public LoanRequest prepareInput(String input) {
        try {
            if (input == null) {
                throw new InvalidRequestInput("Request is invalid");
            }

            List<String> inputs = Arrays.asList(input.split(","));

            if (inputs == null || inputs.size() < 4) {
                throw new InvalidRequestInput("Request is invalid");
            }

            LoanRequest loanRequest = new LoanRequest();
            loanRequest.setAction(inputs.get(0));
            loanRequest.setBankName(inputs.get(1));
            loanRequest.setName(inputs.get(2));
            loanRequest.setEmiNumber(Integer.valueOf(inputs.get(3)));
            return loanRequest;
        } catch (Exception e) {
            throw new InvalidRequestInput("Request is invalid");
        }
    }
}
