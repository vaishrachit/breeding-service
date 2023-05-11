package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.ClientLoginInfo;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClientLoginRepository extends MongoRepository<ClientLoginInfo, Binary> {

    @Query("{\"emailString\" : ?0}")
    ClientLoginInfo getClientByEmail(String email);
}
