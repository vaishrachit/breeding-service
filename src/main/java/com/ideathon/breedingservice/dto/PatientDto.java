package com.ideathon.breedingservice.dto;

import com.ideathon.breedingservice.model.Clients;
import org.bson.types.Binary;

import java.util.Date;
import java.util.List;

public class PatientDto {
		
	 private String id;
     private Integer version;
     private Binary practiceKey;
     private String name;
     private List<Clients> clients;
     private String speciesCode;
     private String weight;
     private String weightUnitCode;
     private String sexCode;
     private Boolean isAltered;
     private Date dateOfBirth;
     private Binary primaryVeterinarianKey;
     private Boolean isActive;
     private String breedCode;
     private String knownAllergies;
     private String otherMedications;
     private String healthConditions;
     private Date createdDate;
     private Date modifiedDate;
     private String documentVersion;
     private String alteredStatusCode;
     private String originTypeCode;

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Binary getPracticeKey() {
        return practiceKey;
    }

    public void setPracticeKey(Binary practiceKey) {
        this.practiceKey = practiceKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode;
    }

    public String getSexCode() {
        return sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public Boolean getAltered() {
        return isAltered;
    }

    public void setAltered(Boolean altered) {
        isAltered = altered;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Binary getPrimaryVeterinarianKey() {
        return primaryVeterinarianKey;
    }

    public void setPrimaryVeterinarianKey(Binary primaryVeterinarianKey) {
        this.primaryVeterinarianKey = primaryVeterinarianKey;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    public String getOtherMedications() {
        return otherMedications;
    }

    public void setOtherMedications(String otherMedications) {
        this.otherMedications = otherMedications;
    }

    public String getHealthConditions() {
        return healthConditions;
    }

    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
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

    public String getDocumentVersion() {
        return documentVersion;
    }

    public void setDocumentVersion(String documentVersion) {
        this.documentVersion = documentVersion;
    }

    public String getAlteredStatusCode() {
        return alteredStatusCode;
    }

    public void setAlteredStatusCode(String alteredStatusCode) {
        this.alteredStatusCode = alteredStatusCode;
    }

    public String getOriginTypeCode() {
        return originTypeCode;
    }

    public void setOriginTypeCode(String originTypeCode) {
        this.originTypeCode = originTypeCode;
    }

}