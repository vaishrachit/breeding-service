package com.ideathon.breedingservice.mapper;

import com.ideathon.breedingservice.dto.ImageDataDto;
import com.ideathon.breedingservice.dto.PatientDto;
import com.ideathon.breedingservice.model.ImageData;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.util.IdConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface ImageDataMapper {

     public static final ImageDataMapper INSTANCE = Mappers.getMapper(ImageDataMapper.class);

     @Mapping(target = "patientId", expression = "java(mapToString(imageData))")
     public abstract ImageDataDto map(ImageData imageData);

     default List<ImageDataDto> map(List<ImageData> imageData){
         List<ImageDataDto> imageDataDtoList = new ArrayList<>();
         for(ImageData image : imageData){
              ImageDataDto imageDataDto = new ImageDataDto();
              imageDataDto.setId(image.getId());
              imageDataDto.setEntityCode(image.getEntityCode());
              imageDataDto.setImagePath(image.getImagePath());
              imageDataDto.setImageType(image.getImageType());
              imageDataDto.setName(image.getName());
              imageDataDto.setPatientId(mapToString(image));
              imageDataDtoList.add(imageDataDto);
         }
         return imageDataDtoList;
     }

     default String mapToString(ImageData imageData){
          return IdConverter.fromStandardBinaryUUID(imageData.getPatientId()).toString();
     }


}
