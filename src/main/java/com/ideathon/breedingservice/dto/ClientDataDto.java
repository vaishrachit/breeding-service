package com.ideathon.breedingservice.dto;

import java.util.List;

import com.ideathon.breedingservice.model.Address;

public class ClientDataDto {

    private String clientId;
    private String clientEmail;
    private String firstName;
    private String lastName;
    private Address address;
    List<PatientDataDto> pets;
    private String latitude;
    private String longitude;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public List<PatientDataDto> getPets() {
        return pets;
    }

    public void setPets(List<PatientDataDto> pets) {
        this.pets = pets;
    }

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
}
