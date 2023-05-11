package com.ideathon.breedingservice.dto;

public class BreedingRequestDto {

    private String senderClientId;
    private String senderPatientId;
    private String receiverClientId;
    private String receiverPatientId;

    public String getSenderClientId() {
        return senderClientId;
    }

    public void setSenderClientId(String senderClientId) {
        this.senderClientId = senderClientId;
    }

    public String getSenderPatientId() {
        return senderPatientId;
    }

    public void setSenderPatientId(String senderPatientId) {
        this.senderPatientId = senderPatientId;
    }

    public String getReceiverClientId() {
        return receiverClientId;
    }

    public void setReceiverClientId(String receiverClientId) {
        this.receiverClientId = receiverClientId;
    }

    public String getReceiverPatientId() {
        return receiverPatientId;
    }

    public void setReceiverPatientId(String receiverPatientId) {
        this.receiverPatientId = receiverPatientId;
    }
}
