package com.ideathon.breedingservice.dto;

import com.ideathon.breedingservice.model.Address;
import com.ideathon.breedingservice.model.CallAuditLog;

import java.util.List;

public class ClientInfoDto {

    private String associatedClientId;
    private String associatedClientName;
    private String associatedClientEmail;
    private String associatedClientPhone;
    private Address associatedClientAddress;
    private String clientAddressLatitude;
    private String clientAddressLongitude;
    private List<CallAuditLog> callAuditLogs;

    public String getAssociatedClientId() {
        return associatedClientId;
    }

    public void setAssociatedClientId(String associatedClientId) {
        this.associatedClientId = associatedClientId;
    }

    public String getAssociatedClientName() {
        return associatedClientName;
    }

    public void setAssociatedClientName(String associatedClientName) {
        this.associatedClientName = associatedClientName;
    }

    public String getAssociatedClientEmail() {
        return associatedClientEmail;
    }

    public void setAssociatedClientEmail(String associatedClientEmail) {
        this.associatedClientEmail = associatedClientEmail;
    }

    public String getAssociatedClientPhone() {
        return associatedClientPhone;
    }

    public void setAssociatedClientPhone(String associatedClientPhone) {
        this.associatedClientPhone = associatedClientPhone;
    }

    public Address getAssociatedClientAddress() {
        return associatedClientAddress;
    }

    public void setAssociatedClientAddress(Address associatedClientAddress) {
        this.associatedClientAddress = associatedClientAddress;
    }

    public String getClientAddressLatitude() {
        return clientAddressLatitude;
    }

    public void setClientAddressLatitude(String clientAddressLatitude) {
        this.clientAddressLatitude = clientAddressLatitude;
    }

    public String getClientAddressLongitude() {
        return clientAddressLongitude;
    }

    public void setClientAddressLongitude(String clientAddressLongitude) {
        this.clientAddressLongitude = clientAddressLongitude;
    }

    public List<CallAuditLog> getCallAuditLogs() {
        return callAuditLogs;
    }

    public void setCallAuditLogs(List<CallAuditLog> callAuditLogs) {
        this.callAuditLogs = callAuditLogs;
    }
}
