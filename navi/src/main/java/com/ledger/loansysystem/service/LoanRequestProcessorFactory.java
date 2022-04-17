package com.ledger.loansysystem.service;

import com.ledger.loansysystem.enums.LoanRequestEnum;
import com.ledger.loansysystem.exceptions.InvalidRequestInput;

public class LoanRequestProcessorFactory {

    public static ILoanRequestProcessor getProcessor(String action) {

        LoanRequestEnum loanRequestEnum = LoanRequestEnum.valueOf(action);
        if (loanRequestEnum == null) {
            throw new InvalidRequestInput("Invalid Input");
        }

        switch (loanRequestEnum) {
            case LOAN:
                return new LoanService();
            case PAYMENT:
                return new PaymentService();
            case BALANCE:
                return new BalanceService();
        }
        return null;
    }
}
