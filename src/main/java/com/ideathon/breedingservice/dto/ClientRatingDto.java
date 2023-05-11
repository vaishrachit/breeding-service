package com.ideathon.breedingservice.dto;

public class ClientRatingDto {

    private Integer value;
    private String ratingMsg;
    private String targetClientId;
    private String sourceClientId;

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

    public String getTargetClientId() {
        return targetClientId;
    }

    public void setTargetClientId(String targetClientId) {
        this.targetClientId = targetClientId;
    }

    public String getSourceClientId() {
        return sourceClientId;
    }

    public void setSourceClientId(String sourceClientId) {
        this.sourceClientId = sourceClientId;
    }
}
