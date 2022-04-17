package com.ledger.loansysystem.service;

import com.ledger.loansysystem.LoanEntity;
import com.ledger.loansysystem.constants.Constant;
import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.interest.InterestFactory;
import com.ledger.loansysystem.model.LoanRequest;
import com.ledger.loansysystem.repository.LoanRepository;
import com.ledger.loansysystem.response.LoanResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LoanService implements ILoanRequestProcessor {

    public LoanResponse processRequest(String input) {

        LoanRequest loanRequest = prepareInput(input);

        String key = loanRequest.getBankName() + ":" + loanRequest.getName();
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setBankName(loanRequest.getBankName());
        loanEntity.setpAmount(loanRequest.getpAmount());
        loanEntity.setRate(loanRequest.getRate());
        loanEntity.setName(loanRequest.getName());
        loanEntity.setLumpSumpayments(new HashMap<>());
        BigDecimal payableAmount = InterestFactory.getInterestService().getInterest(loanRequest).add(loanRequest.getpAmount())
                .setScale(0, RoundingMode.CEILING);
        int numberOfEmis = loanRequest.getYears()* Constant.NumberOdMonthsInYear;
        BigDecimal perEmiAmount = payableAmount.divide(BigDecimal.valueOf(numberOfEmis), RoundingMode.CEILING).setScale(0, RoundingMode.CEILING);
        loanEntity.setEmiAmount(perEmiAmount);
        loanEntity.setPayableAmount(payableAmount);
        loanEntity.setRemainingAmount(payableAmount);
        loanEntity.setTotalEmis(numberOfEmis);
        LoanRepository.loanEntityMap.put(key, loanEntity);
        return LoanResponse.buildSuccess();
    }

    public LoanRequest prepareInput(String input) {
        try {
            if (input == null) {
                throw new InvalidRequestInput("Request is invalid");
            }

            List<String> inputs = Arrays.asList(input.split(","));

            if (inputs == null || inputs.size() < 6) {
                throw new InvalidRequestInput("Request is invalid");
            }

            LoanRequest loanRequest = new LoanRequest();
            loanRequest.setAction(inputs.get(0));
            loanRequest.setBankName(inputs.get(1));
            loanRequest.setName(inputs.get(2));
            loanRequest.setpAmount(new BigDecimal(inputs.get(3)));
            loanRequest.setYears(Integer.valueOf(inputs.get(4)));
            loanRequest.setRate(new BigDecimal(inputs.get(5)));
            return loanRequest;
        } catch (Exception e) {
            throw new InvalidRequestInput("Request is invalid");
        }
    }
}
