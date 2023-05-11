package com.ideathon.breedingservice.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clientRating")
public class ClientRating {

    @Id
    private Binary id;
    private Binary sourceClientId;
    private Binary targetClientId;
    private Integer value;
    private String ratingMessage;

    public ClientRating() {
    }

    public ClientRating(Binary id, Binary sourceClientId, Binary targetClientId, Integer value, String ratingMessage) {
        this.id = id;
        this.sourceClientId = sourceClientId;
        this.targetClientId = targetClientId;
        this.value = value;
        this.ratingMessage = ratingMessage;
    }

    public Binary getId() {
        return id;
    }

    public void setId(Binary id) {
        this.id = id;
    }

    public Binary getSourceClientId() {
        return sourceClientId;
    }

    public void setSourceClientId(Binary sourceClientId) {
        this.sourceClientId = sourceClientId;
    }

    public Binary getTargetClientId() {
        return targetClientId;
    }

    public void setTargetClientId(Binary targetClientId) {
        this.targetClientId = targetClientId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRatingMessage() {
        return ratingMessage;
    }

    public void setRatingMessage(String ratingMessage) {
        this.ratingMessage = ratingMessage;
    }
}
