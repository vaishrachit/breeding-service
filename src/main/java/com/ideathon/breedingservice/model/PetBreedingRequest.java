package com.ideathon.breedingservice.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("breedingRequest")
public class PetBreedingRequest {

    @Id
    private Binary id;
    private Binary senderClientId;
    private Binary senderPatientId;
    private Binary receiverClientId;
    private Binary receiverPatientId;

    public PetBreedingRequest() {}

    public PetBreedingRequest(Binary id, Binary senderClientId, Binary senderPatientId, Binary receiverClientId, Binary receiverPatientId) {
        this.id = id;
        this.senderClientId = senderClientId;
        this.senderPatientId = senderPatientId;
        this.receiverClientId = receiverClientId;
        this.receiverPatientId = receiverPatientId;
    }

    public Binary getId() {
        return id;
    }

    public void setId(Binary id) {
        this.id = id;
    }

    public Binary getSenderClientId() {
        return senderClientId;
    }

    public void setSenderClientId(Binary senderClientId) {
        this.senderClientId = senderClientId;
    }

    public Binary getSenderPatientId() {
        return senderPatientId;
    }

    public void setSenderPatientId(Binary senderPatientId) {
        this.senderPatientId = senderPatientId;
    }

    public Binary getReceiverClientId() {
        return receiverClientId;
    }

    public void setReceiverClientId(Binary receiverClientId) {
        this.receiverClientId = receiverClientId;
    }

    public Binary getReceiverPatientId() {
        return receiverPatientId;
    }

    public void setReceiverPatientId(Binary receiverPatientId) {
        this.receiverPatientId = receiverPatientId;
    }
}
