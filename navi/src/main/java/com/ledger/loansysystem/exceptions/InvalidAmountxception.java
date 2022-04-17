package com.ledger.loansysystem.exceptions;

public class InvalidAmountxception extends RuntimeException {

    private String message;
    public InvalidAmountxception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
