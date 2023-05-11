package com.ideathon.breedingservice.model;

import com.ideathon.breedingservice.util.IdConverter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;

import java.util.Date;
import java.util.UUID;

public class Address {

    private Binary addressKey;
    private String addressTypeCode;
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String stateOrProvince;
    private String postalCode;
    private String country;
    private Boolean isDeleted;
    private Boolean isAddressVerified;
    private String phoneNumber;
    private String phoneExtension;
    private String phoneItuNumber;
    private Date createdDate;
    private Date modifiedDate;

    public Address() {}  
    
    public Address(Binary addressKey, String addressTypeCode, String line1, String line2, String line3, String city, String stateOrProvince, String postalCode, String country, Boolean isDeleted, Boolean isAddressVerified, String phoneNumber, String phoneExtension, String phoneItuNumber, Date createdDate, Date modifiedDate) {
        this.addressKey = addressKey;
        this.addressTypeCode = addressTypeCode;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
        this.isDeleted = isDeleted;
        this.isAddressVerified = isAddressVerified;
        this.phoneNumber = phoneNumber;
        this.phoneExtension = phoneExtension;
        this.phoneItuNumber = phoneItuNumber;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public UUID getAddressKey() {
        return IdConverter.fromStandardBinaryUUID(addressKey);
    }

    public void setAddressKey(Binary addressKey) {
        this.addressKey = addressKey;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getAddressVerified() {
        return isAddressVerified;
    }

    public void setAddressVerified(Boolean addressVerified) {
        isAddressVerified = addressVerified;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExtension(String phoneExtension) {
        this.phoneExtension = phoneExtension;
    }

    public String getPhoneItuNumber() {
        return phoneItuNumber;
    }

    public void setPhoneItuNumber(String phoneItuNumber) {
        this.phoneItuNumber = phoneItuNumber;
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
}
