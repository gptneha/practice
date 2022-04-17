package com.ledger.loansysystem.exceptions;

public class InvalidRequestInput extends RuntimeException {

    private String message;
    public InvalidRequestInput(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
