package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.ClientRating;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRatingRepository extends MongoRepository<ClientRating, UUID> {


    @Query("{\"targetClientId\" : ?0}")
    List<ClientRating> getClientRatingByClientId(Binary clientKey);
}
