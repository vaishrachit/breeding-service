package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.ImageData;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDataRepository extends MongoRepository<ImageData, Binary> {

    @Query("{\"name\" : ?0}")
    ImageData getImageByName(String name);
}
