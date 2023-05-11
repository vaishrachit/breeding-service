package com.ideathon.breedingservice.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;

import java.util.Date;

public class PhoneNumber {

    private Binary phoneKey;
    private String phoneTypeCode;
    private String number;
    private String extension;
    private String ituNumber;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean isDeleted;
    private Boolean messaging;
    
    public PhoneNumber() {}

    public PhoneNumber(Binary phoneKey, String phoneTypeCode, String number, String extension, String ituNumber, Date createdDate, Date modifiedDate, Boolean isDeleted, Boolean messaging) {
        this.phoneKey = phoneKey;
        this.phoneTypeCode = phoneTypeCode;
        this.number = number;
        this.extension = extension;
        this.ituNumber = ituNumber;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.isDeleted = isDeleted;
        this.messaging = messaging;
    }

    public Binary getPhoneKey() {
        return phoneKey;
    }

    public void setPhoneKey(Binary phoneKey) {
        this.phoneKey = phoneKey;
    }

    public String getPhoneTypeCode() {
        return phoneTypeCode;
    }

    public void setPhoneTypeCode(String phoneTypeCode) {
        this.phoneTypeCode = phoneTypeCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getItuNumber() {
        return ituNumber;
    }

    public void setItuNumber(String ituNumber) {
        this.ituNumber = ituNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getMessaging() {
        return messaging;
    }

    public void setMessaging(Boolean messaging) {
        this.messaging = messaging;
    }
}
