package com.ideathon.breedingservice.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.ideathon.breedingservice.dto.CallAuditLogDto;
import com.ideathon.breedingservice.dto.ClientDataDto;
import com.ideathon.breedingservice.dto.ClientInfoDto;
import com.ideathon.breedingservice.dto.ClientRatingDto;
import com.ideathon.breedingservice.dto.ClientRatingInfo;
import com.ideathon.breedingservice.dto.CredentialDto;
import com.ideathon.breedingservice.dto.ImageDataDto;
import com.ideathon.breedingservice.dto.PatientDataDto;
import com.ideathon.breedingservice.dto.PatientDto;
import com.ideathon.breedingservice.mapper.ImageDataMapper;
import com.ideathon.breedingservice.mapper.PatientMapper;
import com.ideathon.breedingservice.model.Address;
import com.ideathon.breedingservice.model.CallAuditLog;
import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.ClientLoginInfo;
import com.ideathon.breedingservice.model.ClientRating;
import com.ideathon.breedingservice.model.Clients;
import com.ideathon.breedingservice.model.ImageData;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.model.PetBreedingRequest;
import com.ideathon.breedingservice.repo.BreedingRequestRepository;
import com.ideathon.breedingservice.repo.CallAuditLogRepository;
import com.ideathon.breedingservice.repo.ClientLoginRepository;
import com.ideathon.breedingservice.repo.ClientRatingRepository;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.ImageDataRepository;
import com.ideathon.breedingservice.repo.PatientRepository;
import com.ideathon.breedingservice.util.IdConverter;
import com.mongodb.client.result.UpdateResult;

import lombok.extern.slf4j.Slf4j;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;

@Component
@Slf4j
public class CentralService {

	private ClientRepository clientRepository;
	private PatientRepository patientRepository;
	private BreedingRequestRepository breedingRequestRepository;
	private ClientRatingRepository clientRatingRepository;
	private ClientLoginRepository clientLoginRepository;
	private ImageDataRepository imageDataRepository;
	private CallAuditLogRepository callAuditLogRepository;

	private String userName = null;
	private String password = null;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Autowired
	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Autowired
	public void setBreedingRequestRepository(BreedingRequestRepository breedingRequestRepository) {
		this.breedingRequestRepository = breedingRequestRepository;
	}

	@Autowired
	public void setClientRatingRepository(ClientRatingRepository clientRatingRepository) {
		this.clientRatingRepository = clientRatingRepository;
	}

	@Autowired
	public void setClientLoginRepository(ClientLoginRepository clientLoginRepository) {
		this.clientLoginRepository = clientLoginRepository;
	}

	@Autowired
	public void setImageDataRepository(ImageDataRepository imageDataRepository) {
		this.imageDataRepository = imageDataRepository;
	}

	@Autowired
	public void setCallAuditLogRepository(CallAuditLogRepository callAuditLogRepository) {
		this.callAuditLogRepository = callAuditLogRepository;
	}

	public ClientDataDto authenticateUser(CredentialDto credentialDto) {

		if (clientLoginRepository.getClientByEmail(credentialDto.getEmail()) == null)
			return null;

		ClientLoginInfo clientLoginInfo = clientLoginRepository.getClientByEmail(credentialDto.getEmail());

		if (!clientLoginInfo.getPassword().equals(credentialDto.getPassword()))
			return null;
		this.userName = credentialDto.getEmail();
		this.password = credentialDto.getPassword();

		return getClientData(credentialDto.getEmail());

	}

//	@Override
//	protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
//			Map<String, Object> attributes) {
//		final String randomId = UUID.randomUUID().toString();
//		SecurityProperties.User user = new User();
//		user.setName(userName);
//		user.setPassword(password);
//	
//		return new UserPrincipal(user.getName());
//	}

	public ClientDataDto getClientData(String email) {
		List<Client> clientList = clientRepository.getClientByEmail(email);

		if (clientList.size() == 0) {
			// Logger.info("No Client Exist with client email : " + email);
			return null;
		}

		Client targetClient = clientList.stream().findFirst().get();

		ClientDataDto clientDataDto = new ClientDataDto();

		clientDataDto.setClientId(IdConverter.fromStandardBinaryUUID(targetClient.getId()).toString());
		clientDataDto.setFirstName(targetClient.getGivenName());
		clientDataDto.setLastName(targetClient.getFamilyName());
		clientDataDto.setClientEmail(targetClient.getEmailAddresses().get(0).getAddress());
		if (targetClient.getAddresses().size() != 0) {
			clientDataDto.setAddress(targetClient.getAddresses().stream().findFirst().get());
			String[] latAndLong = getLatitudeAndLongitude(targetClient);
			clientDataDto.setLatitude(latAndLong[0]);
			clientDataDto.setLongitude(latAndLong[1]);
		}

		List<Patient> pets = getPatientsByClientId(targetClient.getId());

		if (pets.size() == 0) {
			// log.info("Client with email : " + email + " has no pets ");
			return clientDataDto;
		}
		List<PatientDataDto> patientDataDtoList = new ArrayList<>();
		for (Patient patient : pets) {
			PatientDataDto patientDataDto = new PatientDataDto();
			patientDataDto.setPatientId(IdConverter.fromStandardBinaryUUID(patient.getId()).toString());
			patientDataDto.setName(patient.getName());
			patientDataDto.setSexCode(patient.getSexCode());
			patientDataDto.setSpecieCode(patient.getSpeciesCode());
			patientDataDto.setBreedCode(patient.getBreedCode());
			patientDataDto.setHealthCondition(patient.getHealthConditions());
			patientDataDto.setAllergies(patient.getKnownAllergies());
			patientDataDto.setWeight(patient.getWeight());
			patientDataDto.setAge(getAgeFromDateOfBirth(patient.getDateOfBirth()));
			if (patient.getId() != null) {
				List<ImageData> imageDataList = imageDataRepository.findByPatientId(patient.getId());
				List<ImageDataDto> imageDataDtoList = ImageDataMapper.INSTANCE.map(imageDataList);
				patientDataDto.setImages(imageDataDtoList);
			}

			patientDataDtoList.add(patientDataDto);
		}

		clientDataDto.setPets(patientDataDtoList);

		return clientDataDto;
	}

	public List<Patient> getPatientsByClientId(Binary clientId) {
		return patientRepository.getPatientsByClientId(clientId);
	}

	public List<Client> getClientsByClientKey(Binary clientKey) {
		return clientRepository.getClientsByClientKey(clientKey);
	}

	private int getAgeFromDateOfBirth(Date dob) {

		LocalDate curDate = LocalDate.now();
		int age = Period.between(dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), curDate).getYears();

		return age;
	}

	/**
	 * This method will return Patient Data with required information.
	 * 
	 * @param breedCode
	 * @param age
	 * @param weightCriteria
	 * @param healthCondition
	 * @return
	 */
	public List<PatientDataDto> getPatientData(String specieCode, String breedCode, String age, String weightCriteria,
			String healthCondition, String patientId, String clientId, String sexCode) {

		Query query = new Query();

		if (breedCode != null && !breedCode.isEmpty())
			query.addCriteria(Criteria.where("breedCode").is(breedCode));;
		if (specieCode != null && !specieCode.isEmpty())
			query.addCriteria(Criteria.where("speciesCode").is(specieCode.toUpperCase()));
		if (healthCondition != null && !healthCondition.isEmpty())
			query.addCriteria(Criteria.where("healthConditions").is(healthCondition));
		
		  if (sexCode != null && !sexCode.isEmpty()) { 
			  if(sexCode.equalsIgnoreCase("FEMALE")) 
				  query.addCriteria(Criteria.where("sexCode").is("MALE")); 
			  else 
				  query.addCriteria(Criteria.where("sexCode").is("FEMALE")); 
		  }
		 
		  query.limit(200);
		

		List<Patient> listPatient = mongoTemplate.find(query, Patient.class);
		Collections.sort(listPatient, (p,q) -> q.getCreatedDate().compareTo(p.getCreatedDate()));
		if (weightCriteria.contains("-")) {
			listPatient = getPatientWithWeightCriteria(listPatient, weightCriteria);
		}
		List<Patient> patientWithAgeCheck = (age.contains("-")) ? getPatientsWithAgeCriteria(listPatient, age)
				: listPatient;

		List<PatientDataDto> patientDataDtoList = new ArrayList<PatientDataDto>();
		for (Patient patient : patientWithAgeCheck) {
			PatientDataDto patientDataDto = new PatientDataDto();

			patientDataDto.setPatientId(IdConverter.fromStandardBinaryUUID(patient.getId()).toString());
			patientDataDto.setAllergies(patient.getKnownAllergies());
			patientDataDto.setAge(getAgeFromDateOfBirth(patient.getDateOfBirth()));
			patientDataDto.setBreedCode(patient.getBreedCode());
			patientDataDto.setWeight(patient.getWeight());
			patientDataDto.setSexCode(patient.getSexCode());
			patientDataDto.setSpecieCode(patient.getSpeciesCode());
			patientDataDto.setName(patient.getName());
			patientDataDto.setHealthCondition(patient.getHealthConditions());
			if(patient.getId() != null){
				List<ImageData> imageDataList = imageDataRepository.findByPatientId(patient.getId());
				List<ImageDataDto> imageDataDtoList = ImageDataMapper.INSTANCE.map(imageDataList);
				patientDataDto.setImages(imageDataDtoList);
			}
			patientDataDtoList.add(patientDataDto);
		}

		return patientDataDtoList;

	}

	public boolean processBreedingRequest(String senderClientId, String senderPatientId, String receiverClientId,
			String receiverPatientId) {

		try {
			PetBreedingRequest petBreedingRequest = new PetBreedingRequest();

			petBreedingRequest.setId(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
			petBreedingRequest.setSenderClientId(IdConverter.toStandardBinaryUUID(UUID.fromString(senderClientId)));
			petBreedingRequest.setSenderPatientId(IdConverter.toStandardBinaryUUID(UUID.fromString(senderPatientId)));
			petBreedingRequest.setReceiverClientId(IdConverter.toStandardBinaryUUID(UUID.fromString(receiverClientId)));
			petBreedingRequest
					.setReceiverPatientId(IdConverter.toStandardBinaryUUID(UUID.fromString(receiverPatientId)));

			breedingRequestRepository.save(petBreedingRequest);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean submitRatingForClient(ClientRatingDto clientRatingDto) {

		try {
			ClientRating clientRating = new ClientRating();

			clientRating.setId(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
			clientRating.setValue(clientRatingDto.getValue());
			clientRating.setRatingMessage(clientRatingDto.getRatingMsg());
			clientRating.setSourceClientId(
					IdConverter.toStandardBinaryUUID(UUID.fromString(clientRatingDto.getSourceClientId())));
			clientRating.setTargetClientId(
					IdConverter.toStandardBinaryUUID(UUID.fromString(clientRatingDto.getTargetClientId())));

			clientRatingRepository.save(clientRating);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public List<ClientRatingInfo> getAllRatingsOfClient(String clientKey) {

		List<ClientRating> ratings = clientRatingRepository
				.getClientRatingByClientId(IdConverter.toStandardBinaryUUID(UUID.fromString(clientKey)));

		List<ClientRatingInfo> transformedResponse = new ArrayList<>();
		for (ClientRating rating : ratings) {
			ClientRatingInfo clientRatingInfo = new ClientRatingInfo();
			clientRatingInfo.setValue(rating.getValue());
			clientRatingInfo.setRatingMsg(rating.getRatingMessage());
			clientRatingInfo
					.setSourceClientId(IdConverter.fromStandardBinaryUUID(rating.getSourceClientId()).toString());

			Client client = clientRepository.getClientsByClientKey(rating.getSourceClientId()).get(0);

			clientRatingInfo.setSourceClientEmail(client.getEmailAddresses().get(0).getAddress());
			clientRatingInfo.setSourceClientName(client.getGivenName() + " " + client.getFamilyName());

			transformedResponse.add(clientRatingInfo);
		}

		return transformedResponse;
	}

	public Integer getAverageRatingOfClient(String clientKey) {

		int averageRating = 0;
		List<ClientRating> ratings = clientRatingRepository
				.getClientRatingByClientId(IdConverter.toStandardBinaryUUID(UUID.fromString(clientKey)));

		if (ratings.size() == 0)
			return averageRating;

		int sum = 0;
		for (ClientRating clientRating : ratings)
			sum += clientRating.getValue();

		double sumOfAllRating = sum;

		averageRating = (int) Math.round(sumOfAllRating / ratings.size());

		return averageRating;
	}

	public PatientDto savePatient(String name, String speciesCode, String weight, String sexCode, Date dateOfBirth,
			String breedCode, String knownAllergies, String healthConditions, String clientId) {

		Patient patient = new Patient();

		PatientDto patientDto;

		try {

			patient.setId(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
			patient.setName(name);
			patient.setSpeciesCode(speciesCode.toUpperCase());
			patient.setWeight(weight);
			patient.setSexCode(sexCode.toUpperCase());
			patient.setDateOfBirth(dateOfBirth);
			patient.setBreedCode(breedCode);
			patient.setKnownAllergies(knownAllergies);
			patient.setHealthConditions(healthConditions);
			patient.setCreatedDate(new Date());
			patient.setModifiedDate(new Date());
			patient.setVersion(34);
			patient.setPracticeKey(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
			patient.setWeightUnitCode("LBS");
			patient.setPrimaryVeterinarianKey(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
			patient.setActive(true);
			patient.setOtherMedications("");
			patient.setDocumentVersion("1");
			patient.setOriginTypeCode("DEMO");

			Clients clients = new Clients();
			clients.setClientKey(IdConverter.toStandardBinaryUUID(UUID.fromString(clientId)));
			clients.setRoleTypeCode("PRIMARY");

			patient.setClients(Collections.singletonList(clients));

			patient = patientRepository.save(patient);

			patientDto = PatientMapper.INSTANCE.map(patient);

		} catch (Exception e) {
			return null;
		}
		return patientDto;
	}

	public ClientInfoDto getClientInformationFromPatient(String sourceClientKey, String sourcePetKey,
			String targetPetKey) {
		Patient patient = patientRepository
				.getPatientById(IdConverter.toStandardBinaryUUID(UUID.fromString(targetPetKey)));

		Binary clientKey = null;
		Client client = null;

		if (patient.getClients() != null)
			clientKey = patient.getClients().stream().findFirst().get().getClientKey();

		if (clientKey != null)
			client = getClientsByClientKey(clientKey).stream().findFirst().get();

		if (client != null) {
			ClientInfoDto clientInfoDto = new ClientInfoDto();

			clientInfoDto.setAssociatedClientId(IdConverter.fromStandardBinaryUUID(client.getId()).toString());
			clientInfoDto.setAssociatedClientName(client.getGivenName() + " " + client.getFamilyName());

			Address address = client.getAddresses().stream().findFirst().get();
			clientInfoDto.setAssociatedClientAddress(address);
			String[] latAndLong = getLatAndLongFromAddress(address);
			clientInfoDto.setClientAddressLatitude(latAndLong[0]);
			clientInfoDto.setClientAddressLongitude(latAndLong[1]);

			if (client.getEmailAddresses() != null && client.getEmailAddresses().stream().findFirst().isPresent())
				clientInfoDto
						.setAssociatedClientEmail(client.getEmailAddresses().stream().findFirst().get().getAddress());

			if (client.getPhoneNumbers() != null && client.getPhoneNumbers().stream().findFirst().isPresent())
				clientInfoDto.setAssociatedClientPhone(client.getPhoneNumbers().stream().findFirst().get().getNumber());

			List<CallAuditLog> callAuditLogs = callAuditLogRepository.getExistingCallAuditLogForCriteria(
					IdConverter.toStandardBinaryUUID(UUID.fromString(sourceClientKey)),
					IdConverter.toStandardBinaryUUID(UUID.fromString(sourcePetKey)), clientKey,
					IdConverter.toStandardBinaryUUID(UUID.fromString(targetPetKey)));

			if (callAuditLogs == null || callAuditLogs.isEmpty())
				clientInfoDto.setCallAuditLogs(null);
			else
				clientInfoDto.setCallAuditLogs(callAuditLogs);

			return clientInfoDto;
		}

		return null;
	}

	public boolean saveCallAuditLog(CallAuditLogDto callAuditLogDto) {

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			CallAuditLog callAuditLog = new CallAuditLog();

			callAuditLog.setId(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
			callAuditLog.setSourceClientId(
					IdConverter.toStandardBinaryUUID(UUID.fromString(callAuditLogDto.getSourceClientId())));
			callAuditLog.setSourcePetId(
					IdConverter.toStandardBinaryUUID(UUID.fromString(callAuditLogDto.getSourcePetId())));
			callAuditLog.setTargetClientId(
					IdConverter.toStandardBinaryUUID(UUID.fromString(callAuditLogDto.getTargetClientId())));
			callAuditLog.setTargetPetId(
					IdConverter.toStandardBinaryUUID(UUID.fromString(callAuditLogDto.getTargetPetId())));
			callAuditLog.setStartDateTime(sdfDate.parse(callAuditLogDto.getStartDateTime()));
			callAuditLog.setEndDateTime(sdfDate.parse(callAuditLogDto.getEndDateTime()));

			callAuditLogRepository.save(callAuditLog);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private String[] getLatitudeAndLongitude(Client targetClient) {
		String[] values = new String[2];

		if (targetClient.getAddresses().size() != 0) {
			String line1 = targetClient.getAddresses().get(0).getLine1();
			String line2 = targetClient.getAddresses().get(0).getLine2();
			String line3 = targetClient.getAddresses().get(0).getLine3();
			String city = targetClient.getAddresses().get(0).getCity();
			String postalCode = targetClient.getAddresses().get(0).getPostalCode();
			String address = line1 + "+" + line2 + "+" + line3 + "+" + city + "+" + postalCode;
			try {
				Map<String, String> map = getLatLong(address);
				values[0] = (map.get("lat"));
				values[1] = (map.get("long"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return values;
	}

	private String[] getLatAndLongFromAddress(Address address) {
		String[] values = new String[2];
		String line1 = address.getLine1();
		String line2 = address.getLine2();
		String line3 = address.getLine3();
		String city = address.getCity();
		String postalCode = address.getPostalCode();
		String addressString = line1 + "+" + line2 + "+" + line3 + "+" + city + "+" + postalCode;
		try {
			Map<String, String> map = getLatLong(addressString);
			values[0] = (map.get("lat"));
			values[1] = (map.get("long"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return values;
	}

	private List<Patient> getPatientWithWeightCriteria(List<Patient> listPatients, String weightCriteria) {
		String[] weightRange = weightCriteria.split("-");
		double startWeight = Double.parseDouble(weightRange[0]);
		double endWeight = Double.parseDouble(weightRange[1]);
		return listPatients.stream().filter(
				p -> Double.parseDouble(p.getWeight()) >= startWeight && Double.parseDouble(p.getWeight()) <= endWeight)
				.collect(Collectors.toList());
	}

	private List<Patient> getPatientsWithAgeCriteria(List<Patient> listPatient, String age) {
		String[] ageArray = age.split("-");
		int startAge = Integer.parseInt(ageArray[0]);
		int endAge = Integer.parseInt(ageArray[1]);
		LocalDate localDate = LocalDate.now();

		return listPatient.stream().filter(p -> Period
				.between(p.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), localDate)
				.getYears() >= startAge
				&& Period
						.between(p.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), localDate)
						.getYears() <= endAge)
				.collect(Collectors.toList());

	}

	public List<ClientDataDto> getLocation(String patientId, double miles) throws Exception {
		Patient patient = patientRepository
				.getPatientById(IdConverter.toStandardBinaryUUID(UUID.fromString(patientId)));

		String sexCode = patient.getSexCode();
		String speciesCode = patient.getSpeciesCode();
		List<ClientDataDto> listClientDataDto = new ArrayList<>();

		Map<String, String> map = getClientsLatLong(patientId);
		double clientLat = Double.valueOf(map.get("lat"));
		double clientLong = Double.valueOf(map.get("long"));

		Query query = new Query();
		query.limit(100);
		if (sexCode != null && !sexCode.isEmpty()) {
			if (sexCode.equalsIgnoreCase("FEMALE"))
				query.addCriteria(Criteria.where("sexCode").is("MALE"));
			else
				query.addCriteria(Criteria.where("sexCode").is("FEMALE"));
		}
		query.addCriteria(Criteria.where("speciesCode").is(speciesCode));
		List<Patient> patientList = mongoTemplate.find(query, Patient.class);
		List<Address> listAddress = getAllAddresses(patientList);
		ClientDataDto cdd = new ClientDataDto();
		int i = 0;
		for (Patient pets : patientList) {
			if (!speciesCode.equalsIgnoreCase(patient.getSpeciesCode()))
				continue;
			if (i == listAddress.size() || listAddress.get(i) == null) {
				break;
			}
			cdd = getClientDataDtop(speciesCode, pets.getId(), listAddress.get(i));
			double otherClientsLat = Double.valueOf(cdd.getLatitude());
			double otherClientsLong = Double.valueOf(cdd.getLongitude());

			GeodesicData result = Geodesic.WGS84.Inverse(clientLat, clientLong, otherClientsLat, otherClientsLong);

			double distanceInMeters = result.s12;
			double distanceInMiles = distanceInMeters / 1609.34;

			if (distanceInMiles <= miles) {
				listClientDataDto.add(cdd);
			}
			i++;

		}
		return listClientDataDto;
	}

	private List<Address> getAllAddresses(List<Patient> patientList) {
		List<Address> listAddress = new ArrayList<>();
		Set<Clients> set = new HashSet<>();
		for (Patient patient : patientList) {
			set.addAll(patient.getClients());
		}
		List<Client> listClient = new ArrayList<>();
		for (Clients clients : set) {
			listClient.addAll(clientRepository.getClientsByClientKey(clients.getClientKey()));
		}
		for (Client client : listClient) {
			listAddress.addAll(client.getAddresses());
		}

		return listAddress;
	}

	public ClientDataDto getClientDataDtop(String speciesCode, Binary patientId, Address address) {
		Patient patient = patientRepository.getPatientById(patientId);

		Binary clientKey = null;
		Client client = null;

		if (patient.getClients() != null)
			clientKey = patient.getClients().stream().findFirst().get().getClientKey();

		if (clientKey != null)
			client = getClientsByClientKey(clientKey).stream().findFirst().get();

		if (client != null) {
			ClientDataDto clientInfoDto = new ClientDataDto();
			List<PatientDataDto> list = new ArrayList<>();
			PatientDataDto pdd = new PatientDataDto();

			clientInfoDto.setClientId(String.valueOf(client.getId()));
			clientInfoDto.setFirstName(client.getGivenName());
			clientInfoDto.setLastName(client.getFamilyName());
			if (address != null) {
				String line1 = address.getLine1();
				String line2 = address.getLine2();
				String line3 = address.getLine3();
				String city = address.getCity();
				String postalCode = address.getPostalCode();
				String combinedAddress = line1 + "+" + line2 + "+" + line3 + "+" + city + "+" + postalCode;
				clientInfoDto.setAddress(address);
				try {
					Map<String, String> maps = getLatLong(combinedAddress);
					clientInfoDto.setLatitude(maps.get("lat"));
					clientInfoDto.setLongitude(maps.get("long"));
				} catch (Exception e) {
					System.err.println("Exception occured at getClientDataDtop():" + e);
				}
			}

			pdd.setAge(getAgeFromDateOfBirth(patient.getDateOfBirth()));
			pdd.setSpecieCode(speciesCode);
			pdd.setHealthCondition(patient.getHealthConditions());
			pdd.setName(patient.getName());
			pdd.setPatientId(String.valueOf(patient.getId()));
			pdd.setSexCode(patient.getSexCode());
			pdd.setBreedCode(patient.getBreedCode());
			pdd.setAllergies(patient.getKnownAllergies());
			pdd.setWeight(patient.getWeight());
			// adding image data
			if (patient.getId() != null) {
				List<ImageData> imageDataList = imageDataRepository.findByPatientId(patient.getId());
				List<ImageDataDto> imageDataDtoList = ImageDataMapper.INSTANCE.map(imageDataList);
				pdd.setImages(imageDataDtoList);
			}
			list.add(pdd);
			clientInfoDto.setPets(list);
			return clientInfoDto;
		}

		return null;
	}

	public Map<String, String> getLatLong(String address) throws Exception {
		Map<String, String> map = new HashMap<>();
		String api = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8")
				+ "&key=AIzaSyA5_Og6E44J_7rxJ7ptlTFb8t8TPz1f5LQ";
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		httpConnection.connect();
		int responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String) expr.evaluate(document, XPathConstants.STRING);
			if (status.equals("OK")) {
				expr = xpath.compile("//geometry/location/lat");
				String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
				map.put("lat", latitude);
				map.put("long", longitude);
			} else {
				// throw new Exception("Error from the API - response status: "+status);
			}
		}
		return map;
	}

	/**
	 * Get recommended Patients
	 * 
	 * @param patientId
	 * @return
	 */
	public List<PatientDataDto> getRecommendedInfo(String patientId) {
		List<PetBreedingRequest> patientsFromHistory = breedingRequestRepository
				.findBySenderPatientId(IdConverter.toStandardBinaryUUID(UUID.fromString(patientId)));
		List<Binary> patiendIdList = new ArrayList<>();
		for (PetBreedingRequest petBreedReq : patientsFromHistory) {
			patiendIdList.add(petBreedReq.getReceiverPatientId());
		}
		Set<Patient> listSearchedPatients = new HashSet<>();
		// query.limit(200);

		for (Binary patientIds : patiendIdList) {
			Query query = new Query();

			Patient patient = patientRepository.getPatientById(patientIds);

			int age = getAgeFromDateOfBirth(patient.getDateOfBirth());
			query.addCriteria(Criteria.where("breedCode").is(patient.getBreedCode()));
			query.addCriteria(Criteria.where("healthConditions").is(patient.getHealthConditions()));
			query.addCriteria(Criteria.where("speciesCode").is(patient.getSpeciesCode()));
			query.addCriteria(Criteria.where("sexCode").is(patient.getSexCode()));
			query.addCriteria(Criteria.where("_id").ne(IdConverter.fromStandardBinaryUUID(patient.getId())));
			query.limit(100);

			List<Patient> patientLists = mongoTemplate.find(query, Patient.class);

			double weight = Double.parseDouble(patient.getWeight());

			String weightRange = (weight - 1) + "-" + (weight + 1);
			String ageRange = (age - 1) + "-" + (age + 1);
			patientLists = getPatientWithWeightCriteria(patientLists, weightRange);
			patientLists = getPatientsWithAgeCriteria(patientLists, ageRange);
			listSearchedPatients.addAll(patientLists);
		}
		listSearchedPatients = listSearchedPatients.stream().limit(50).collect(Collectors.toSet());
		List<PatientDataDto> patientDataDto = new ArrayList<>();
		for (Patient pets : listSearchedPatients) {
			PatientDataDto pdd = new PatientDataDto();
			int age = getAgeFromDateOfBirth(pets.getDateOfBirth());
			pdd.setAge(age);
			pdd.setName(pets.getName());
			pdd.setSexCode(pets.getSexCode());
			pdd.setAllergies(pets.getKnownAllergies());
			pdd.setHealthCondition(pets.getHealthConditions());
			pdd.setPatientId(IdConverter.fromStandardBinaryUUID(pets.getId()).toString());
			pdd.setSpecieCode(pets.getSpeciesCode());
			pdd.setWeight(pets.getWeight());
			pdd.setBreedCode(pets.getBreedCode());
			if (pets.getId() != null) {
				List<ImageData> imageDataList = imageDataRepository.findByPatientId(pets.getId());
				List<ImageDataDto> imageDataDtoList = ImageDataMapper.INSTANCE.map(imageDataList);
				pdd.setImages(imageDataDtoList);
			}
			patientDataDto.add(pdd);
		}

		return patientDataDto;

	}

	private Map<String, String> getClientsLatLong(String patientId) {
		Patient patient = patientRepository
				.getPatientById(IdConverter.toStandardBinaryUUID(UUID.fromString(patientId)));
		Map<String, String> map = new HashMap<>();
		Clients clients = patient.getClients().stream().findFirst().get();
		Client client = clientRepository.getClientsByClientKey(clients.getClientKey()).stream().findFirst().get();
		Address address = client.getAddresses().stream().findFirst().get();
		if (address != null) {
			String line1 = address.getLine1();
			String line2 = address.getLine2();
			String line3 = address.getLine3();
			String city = address.getCity();
			String postalCode = address.getPostalCode();
			String combinedAddress = line1 + "+" + line2 + "+" + line3 + "+" + city + "+" + postalCode;
			try {
				map.putAll(getLatLong(combinedAddress));
			} catch (Exception e) {
				System.err.println("Exception occured at getClientDataDtop():" + e);
			}
		}
		return map;
	}

	public void updateClientAdd() {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id")
				.is(IdConverter.toStandardBinaryUUID(UUID.fromString("2e852d2c-455b-49f0-a887-8a3b71abb7a2"))));
		Address address = new Address();
		address.setAddressKey(IdConverter.toStandardBinaryUUID(UUID.randomUUID()));
		address.setAddressVerified(true);
		address.setAddressTypeCode("HOME");
		address.setCity("Chicago");
		address.setStateOrProvince("il");
		address.setCountry("US");
		address.setLine1("3 W 30th Place");
		address.setLine2(null);
		address.setLine3(null);
		address.setPhoneItuNumber("1233113");
		address.setPhoneExtension("+22");
		address.setPhoneItuNumber("+1");
		address.setPostalCode("60621");

		UpdateResult add = mongoTemplate
				.updateFirst(
						Query.query(Criteria.where("_id")
								.is(IdConverter.toStandardBinaryUUID(
										UUID.fromString("2e852d2c-455b-49f0-a887-8a3b71abb7a2")))),
						new Update().setOnInsert("addresses.$", address), "client");
		System.out.println(add);
	}
}