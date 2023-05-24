package com.ideathon.breedingservice.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("callAuditLog")
public class CallAuditLog {

    @Id
    private Binary id;
    private Binary sourceClientId;
    private Binary sourcePetId;
    private Binary targetClientId;
    private Binary targetPetId;
    private Date startDateTime;
    private Date endDateTime;

    public CallAuditLog() {
    }

    public CallAuditLog(Binary id, Binary sourceClientId, Binary sourcePetId, Binary targetClientId, Binary targetPetId, Date startDateTime, Date endDateTime) {
        this.id = id;
        this.sourceClientId = sourceClientId;
        this.sourcePetId = sourcePetId;
        this.targetClientId = targetClientId;
        this.targetPetId = targetPetId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
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

    public Binary getSourcePetId() {
        return sourcePetId;
    }

    public void setSourcePetId(Binary sourcePetId) {
        this.sourcePetId = sourcePetId;
    }

    public Binary getTargetClientId() {
        return targetClientId;
    }

    public void setTargetClientId(Binary targetClientId) {
        this.targetClientId = targetClientId;
    }

    public Binary getTargetPetId() {
        return targetPetId;
    }

    public void setTargetPetId(Binary targetPetId) {
        this.targetPetId = targetPetId;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
