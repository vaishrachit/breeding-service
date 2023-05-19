package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.dto.RegisterClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.service.ClientService;

import java.text.ParseException;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/client")
public class ClientController {

	private ClientService clientService;
	
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping("/registerClient")
	public Client registerClients(@RequestBody RegisterClientDto registerClientDto) throws ParseException {
		
		return clientService.registerClient(registerClientDto);
	}
	
	@PutMapping("/sendTo/{id}")
	public String sendPrivateMessage(@PathVariable String id, String message) {
		
		return "Success";
		
	}
}