package com.kloudvista.nursingAPI.dto;

public class NewNurseResp {
    private String responseCode;
    private String message;

    public NewNurseResp(String responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
    public NewNurseResp() {

    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

