package com.ideathon.breedingservice.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clientLogin")
public class ClientLoginInfo {

    @Id
    private Binary id;
    private Binary clientId;
    private String emailString;
    private String password;

    public ClientLoginInfo() {
    }

    public ClientLoginInfo(Binary id, Binary clientId, String emailString, String password) {
        this.id = id;
        this.clientId = clientId;
        this.emailString = emailString;
        this.password = password;
    }

    public Binary getId() {
        return id;
    }

    public void setId(Binary id) {
        this.id = id;
    }

    public Binary getClientId() {
        return clientId;
    }

    public void setClientId(Binary clientId) {
        this.clientId = clientId;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
