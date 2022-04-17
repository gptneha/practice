package com.ledger.loansysystem.response;

public class LoanResponse {
    private boolean success;
    private String code;
    private String message;
    private Object data;

    public static LoanResponse buildSuccess(Object data){
        LoanResponse LoanResponse = new LoanResponse();
        LoanResponse.setSuccess(Boolean.TRUE);
        LoanResponse.setData(data);
        return LoanResponse;
    }

    public static LoanResponse buildSuccess(){
        LoanResponse LoanResponse = new LoanResponse();
        LoanResponse.setSuccess(Boolean.TRUE);
        return LoanResponse;
    }

    public static LoanResponse buildFail(String code, String message){
        LoanResponse LoanResponse = new LoanResponse();
        LoanResponse.setSuccess(Boolean.FALSE);
        LoanResponse.setCode(code);
        LoanResponse.setMessage(message);
        return LoanResponse;
    }

    public static LoanResponse buildFailWithData(String code, String message, Object data){
        LoanResponse LoanResponse = new LoanResponse();
        LoanResponse.setSuccess(Boolean.FALSE);
        LoanResponse.setCode(code);
        LoanResponse.setMessage(message);
        LoanResponse.setData(data);
        return LoanResponse;
    }

    public boolean isSuccess() {
        return success;
    }

    private void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    private void setData(Object data) {
        this.data = data;
    }
}
