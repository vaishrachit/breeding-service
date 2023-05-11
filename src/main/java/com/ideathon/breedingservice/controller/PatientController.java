package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.service.CentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private CentralService centralService;

    @Autowired
    public void setCentralService(CentralService centralService) {
        this.centralService = centralService;
    }

    @GetMapping("/addPatient")
    public Patient sendBreedingRequestToClient(@RequestParam("name") String name,
                                               @RequestParam("speciesCode") String speciesCode,
                                               @RequestParam("weight") String weight,
                                               @RequestParam("sexCode") String sexCode,
                                               @RequestParam("dateOfBirth") String dateOfBirth,
                                               @RequestParam("breedCode") String breedCode,
                                               @RequestParam("knownAllergies") String knownAllergies,
                                               @RequestParam("healthConditions") String healthConditions,
                                               @RequestParam("clientId") String clientId) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedDateOfBirth = formatter.parse(dateOfBirth);

        return centralService.savePatient(name, speciesCode, weight, sexCode, formattedDateOfBirth, breedCode, knownAllergies, healthConditions, clientId);
    }
}
