package com.ideathon.breedingservice.mapper;

import com.ideathon.breedingservice.dto.PatientDto;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.util.IdConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class PatientMapper {

     public static final PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

     @Mapping(target = "id", expression = "java(mapToString(patient))")
     public abstract PatientDto map(Patient patient);

     String mapToString(Patient patient){
          return IdConverter.fromStandardBinaryUUID(patient.getId()).toString();
     }


}
