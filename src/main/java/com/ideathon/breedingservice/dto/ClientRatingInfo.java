package com.ideathon.breedingservice.dto;

public class ClientRatingInfo {

    private Integer value;
    private String ratingMsg;
    private String sourceClientId;
    private String sourceClientEmail;
    private String sourceClientName;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRatingMsg() {
        return ratingMsg;
    }

    public void setRatingMsg(String ratingMsg) {
        this.ratingMsg = ratingMsg;
    }

    public String getSourceClientId() {
        return sourceClientId;
    }

    public void setSourceClientId(String sourceClientId) {
        this.sourceClientId = sourceClientId;
    }

    public String getSourceClientEmail() {
        return sourceClientEmail;
    }

    public void setSourceClientEmail(String sourceClientEmail) {
        this.sourceClientEmail = sourceClientEmail;
    }

    public String getSourceClientName() {
        return sourceClientName;
    }

    public void setSourceClientName(String sourceClientName) {
        this.sourceClientName = sourceClientName;
    }
}
