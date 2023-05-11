package com.ideathon.breedingservice.repo;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.ideathon.breedingservice.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Binary> {	

    @Query("{'emailAddresses.address' : ?0}")
    List<Client> getClientByEmail(String email);

    @Query("{\"_id\" : ?0}")
    List<Client> getClientsByClientKey(Binary clientKey);

}
