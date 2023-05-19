package com.ideathon.breedingservice.model;

import lombok.Builder;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("imagePathData")
@Builder
public class ImageData {

    @Id
    private Binary id;
    private String name;
    private String imageType;
    private String imagePath;
    private String entityCode;
    private Binary entityId;

    public ImageData() {
    }

    public ImageData(Binary id, String name, String imageType, String imagePath, String entityCode, Binary entityId) {
        this.id = id;
        this.name = name;
        this.imageType = imageType;
        this.imagePath = imagePath;
        this.entityCode = entityCode;
        this.entityId = entityId;
    }

    public Binary getId() {
        return id;
    }

    public void setId(Binary id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public Binary getEntityId() {
        return entityId;
    }

    public void setEntityId(Binary entityId) {
        this.entityId = entityId;
    }
}
