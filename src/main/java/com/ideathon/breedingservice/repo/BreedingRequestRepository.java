package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.PetBreedingRequest;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BreedingRequestRepository extends MongoRepository<PetBreedingRequest, UUID> {
	
	List<PetBreedingRequest> findBySenderPatientId(Binary senderPatientId);
}
