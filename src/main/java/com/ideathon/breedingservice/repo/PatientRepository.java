package com.ideathon.breedingservice.repo;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideathon.breedingservice.model.Clients;
import com.ideathon.breedingservice.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Binary> {

    @Query("{\"clients.clientKey\" : ?0}")
    List<Patient> getPatientsByClientId(Binary clientId);

    @Query("{\"_id\" : ?0}")
    Patient getPatientById(Binary id);

    @Query("{speciesCode : ?0}")
    List<Patient> getPatientBySpecie(String specie);
  
}

