package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.CallAuditLog;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CallAuditLogRepository extends MongoRepository<CallAuditLog, Binary> {

    @Query("{$and : [{sourceClientId: ?0 }, {sourcePetId: ?1}, {targetClientId: ?2},{targetPetId: ?3}]}")
    List<CallAuditLog> getExistingCallAuditLogForCriteria(Binary sourceClientKey, Binary sourcePetKey, Binary targetClientKey, Binary targetPetKey);

}
