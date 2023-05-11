package com.ideathon.breedingservice.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class EmailAddress {

	@Id
    private Binary emailAddressKey;
    private List<String> emailAddressTypeCodes;
    private String address;
    private Boolean isDeleted;
    private Date createdDate;
    private Date modifiedDate;
    
    public EmailAddress() {
		// TODO Auto-generated constructor stub
	}

    public EmailAddress(Binary emailAddressKey, List<String> emailAddressTypeCodes, String address, Boolean isDeleted, Date createdDate, Date modifiedDate) {
        this.emailAddressKey = emailAddressKey;
        this.emailAddressTypeCodes = emailAddressTypeCodes;
        this.address = address;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Binary getEmailAddressKey() {
        return emailAddressKey;
    }

    public void setEmailAddressKey(Binary emailAddressKey) {
        this.emailAddressKey = emailAddressKey;
    }

    public List<String> getEmailAddressTypeCodes() {
        return emailAddressTypeCodes;
    }

    public void setEmailAddressTypeCodes(List<String> emailAddressTypeCodes) {
        this.emailAddressTypeCodes = emailAddressTypeCodes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
