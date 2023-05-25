package com.ideathon.breedingservice.dto;

public class CallAuditLogDto {

    private String sourceClientId;
    private String sourcePetId;
    private String targetClientId;
    private String targetPetId;
    private String startDateTime;
    private String endDateTime;

    public String getSourceClientId() {
        return sourceClientId;
    }

    public void setSourceClientId(String sourceClientId) {
        this.sourceClientId = sourceClientId;
    }

    public String getSourcePetId() {
        return sourcePetId;
    }

    public void setSourcePetId(String sourcePetId) {
        this.sourcePetId = sourcePetId;
    }

    public String getTargetClientId() {
        return targetClientId;
    }

    public void setTargetClientId(String targetClientId) {
        this.targetClientId = targetClientId;
    }

    public String getTargetPetId() {
        return targetPetId;
    }

    public void setTargetPetId(String targetPetId) {
        this.targetPetId = targetPetId;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }
}
