package com.ideathon.breedingservice.dto;

public class PatientDataDto {

    private String patientId;
    private String name;
    private String specieCode;
    private String sexCode;
    private int age;
    private String breedCode;
    private String healthCondition;
    private String allergies;
    private String weight;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecieCode() {
        return specieCode;
    }

    public void setSpecieCode(String specieCode) {
        this.specieCode = specieCode;
    }

    public String getSexCode() {
        return sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public String getBreedCode() {
		return breedCode;
	}

	public void setBreedCode(String breedCode) {
		this.breedCode = breedCode;
	}

	public String getHealthCondition() {
		return healthCondition;
	}

	public void setHealthCondition(String healthCondition) {
		this.healthCondition = healthCondition;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
    
 }
