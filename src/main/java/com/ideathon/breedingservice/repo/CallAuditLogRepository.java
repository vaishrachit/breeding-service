package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.CallAuditLog;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CallAuditLogRepository extends MongoRepository<CallAuditLog, Binary> {

}
