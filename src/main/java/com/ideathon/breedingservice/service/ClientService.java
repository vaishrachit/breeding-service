package com.ideathon.breedingservice.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ideathon.breedingservice.dto.RegisterClientDto;
import com.ideathon.breedingservice.model.ClientLoginInfo;
import com.ideathon.breedingservice.repo.ClientLoginRepository;
import com.ideathon.breedingservice.repo.ClientRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.ideathon.breedingservice.model.Address;
import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.EmailAddress;
import com.ideathon.breedingservice.model.PhoneNumber;
import com.ideathon.breedingservice.util.IdConverter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClientService {

	private ClientRepository clientRepository;
	private ClientLoginRepository clientLoginRepository;

	@Autowired
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Autowired
	public void setClientLoginRepository(ClientLoginRepository clientLoginRepository) {
		this.clientLoginRepository = clientLoginRepository;
	}

	public Client registerClient(RegisterClientDto registerClientDto) throws ParseException {

		if(clientLoginRepository.getClientByEmail(registerClientDto.getEmailAddress()) != null)
			return null;

		// Save Client Information

		Client client = new Client();

		Binary clientId = IdConverter.toStandardBinaryUUID(UUID.randomUUID());
		Binary addressId = IdConverter.toStandardBinaryUUID(UUID.randomUUID());
		Binary emailAddressId = IdConverter.toStandardBinaryUUID(UUID.randomUUID());
		Binary phoneId = IdConverter.toStandardBinaryUUID(UUID.randomUUID());

		client.setId(clientId);
		client.setTitle(registerClientDto.getTitle());
		client.setGivenName(registerClientDto.getFirstName());
		client.setMiddleName(registerClientDto.getLastName());
		client.setFamilyName(registerClientDto.getLastName());
		client.setOnline(true);

		client.setDateOfBirth(null);
		client.setCreatedDate(new Date());
		client.setModifiedDate(new Date());

		Address address = new Address();
		address.setAddressKey(addressId);
		address.setLine1(registerClientDto.getAddressLine1());
		address.setLine2(registerClientDto.getAddressLine2());
		address.setLine3(registerClientDto.getAddressLine3());
		address.setCity(registerClientDto.getCity());
		address.setStateOrProvince(registerClientDto.getState());
		address.setPostalCode(registerClientDto.getPostalCode());
		address.setCountry(registerClientDto.getCountry());
		address.setCreatedDate(new Date());
		address.setModifiedDate(new Date());
		// Address Hard-coded Data
		address.setAddressTypeCode("Client_Address");
		address.setDeleted(false);
		address.setAddressVerified(true);
		address.setPhoneItuNumber("NONE");
		address.setPhoneExtension("NONE");

		client.setAddresses(Collections.singletonList(address));
		client.setPrimaryAddressKey(addressId);

		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setEmailAddressKey(emailAddressId);
		emailAddress.setAddress(registerClientDto.getEmailAddress());
		emailAddress.setCreatedDate(new Date());
		emailAddress.setModifiedDate(new Date());
		emailAddress.setDeleted(false);
		emailAddress.setEmailAddressTypeCodes(null);

		client.setEmailAddresses(Collections.singletonList(emailAddress));
		client.setPrimaryEmailAddressKey(emailAddressId);

		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setPhoneKey(phoneId);
		phoneNumber.setNumber(registerClientDto.getPhoneNumber());
		phoneNumber.setCreatedDate(new Date());
		phoneNumber.setModifiedDate(new Date());
		phoneNumber.setDeleted(false);
		phoneNumber.setMessaging(true);
		// Phone Hard-Coded Data
		phoneNumber.setItuNumber("NONE");
		phoneNumber.setExtension("NONE");
		phoneNumber.setPhoneTypeCode("CLIENT_PHONE");

		client.setPhoneNumbers(Collections.singletonList(phoneNumber));
		client.setPrimaryPhoneKey(phoneId);

		// Client Hard-Coded Data
		client.setOriginTypeCode("Created");
		client.setPracticeKey(null);
		client.setPrefix("Client");
		client.setVersion(1);
		client.setAcceptsGenerics(false);
		client.setPreferredContactMethodCode("Phone");
		client.setDocumentVersion("1");
		client.setActive(true);


		// Save Client Password/Login Information

		ClientLoginInfo clientLoginInfo = new ClientLoginInfo();

		clientLoginInfo.setId(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
		clientLoginInfo.setClientId(clientId);
		clientLoginInfo.setEmailString(registerClientDto.getEmailAddress());
		clientLoginInfo.setPassword(registerClientDto.getPassword());
		clientLoginRepository.save(clientLoginInfo);

		return clientRepository.save(client);

	}
		

}
