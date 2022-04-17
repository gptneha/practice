package com.ledger.loansysystem.interest;

public class InterestFactory {

    public static Interest getInterestService() {
        return new SimpleInterestCalculator();
    }
}
