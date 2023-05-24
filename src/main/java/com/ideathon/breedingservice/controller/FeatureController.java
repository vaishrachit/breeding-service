package com.ideathon.breedingservice.controller;

import java.util.List;

import com.ideathon.breedingservice.dto.CallAuditLogDto;
import com.ideathon.breedingservice.dto.ClientRatingInfo;
import com.ideathon.breedingservice.dto.CredentialDto;
import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.util.IdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideathon.breedingservice.dto.ClientDataDto;
import com.ideathon.breedingservice.dto.ClientInfoDto;
import com.ideathon.breedingservice.dto.ClientRatingDto;
import com.ideathon.breedingservice.dto.PatientDataDto;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;
import com.ideathon.breedingservice.service.CentralService;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/feature")
public class FeatureController {

	private ClientRepository clientRepository;
	private PatientRepository patientRepository;
	private CentralService centralService;

	@Autowired
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Autowired
	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Autowired
	public void setCentralService(CentralService centralService) {
		this.centralService = centralService;
	}

	@GetMapping("/client/email/{email}")
	public ClientDataDto getClientDataByEmail(@PathVariable String email) {
		return centralService.getClientData(email);
	}

	@GetMapping("/searchPatient")
	public List<PatientDataDto> searchPatient(@RequestParam("specieCode") String specieCode,
											  @RequestParam("breedCode") String breedCode,
											  @RequestParam("age") String age, @RequestParam("weight") String weightCriteria,
											  @RequestParam("healthCondition") String healthCondition, @RequestParam("patientId") String patientId,
											  @RequestParam("clientId") String clientId, @RequestParam("sexCode") String sexCode ) {

		return centralService.getPatientData(specieCode, breedCode, age, weightCriteria, healthCondition, patientId, clientId, sexCode);
	}
	
	@GetMapping(value = "/client/location")
	public List<ClientDataDto> getLocation(@RequestParam("patientId") String patientId, @RequestParam("miles") double miles) throws Exception{
		return centralService.getLocation(patientId, miles);
	}

	@GetMapping("/patient/clientInfo/{patientId}")
	public ClientInfoDto getClientInformationFromPatient(@PathVariable String patientId) {
		return centralService.getClientInformationFromPatient(patientId);
	}

	@GetMapping("/patient/recommedation/{patientId}")
	public List<PatientDataDto> getRecommendedInfo(@PathVariable String patientId) {
		return centralService.getRecommendedInfo(patientId);
	}
	
	@GetMapping("/patient/updateClient")
	public String updateClient() {
		centralService.updateClientAdd();
		return "Saved";
	}

	@PostMapping("/login")
	public ClientDataDto loginApp(@RequestBody CredentialDto credentialDto) {
		if(credentialDto.getEmail().isEmpty() || credentialDto.getPassword().isEmpty())
			return null;
		return centralService.authenticateUser(credentialDto);
	}
	
	@GetMapping("/client/requestBreeding")
	public Boolean sendBreedingRequestToClient(@RequestParam("senderClientId") String senderClientId,
											   @RequestParam("senderPatientId") String senderPatientId,
											   @RequestParam("receiverClientId") String receiverClientId,
											   @RequestParam("receiverPatientId") String receiverPatientId) {
		return centralService.processBreedingRequest(senderClientId, senderPatientId, receiverClientId, receiverPatientId);
	}

	@PostMapping("/client/rating/submit")
	public Boolean submitClientRating(@RequestBody ClientRatingDto clientRatingDto) {
		return centralService.submitRatingForClient(clientRatingDto);
	}

	@GetMapping("/client/allRatings/{clientId}")
	public List<ClientRatingInfo> getAllRatingsOfClient(@PathVariable String clientId) {
		return centralService.getAllRatingsOfClient(clientId);
	}

	@GetMapping("/client/rating/{clientId}")
	public Integer getAverageCLientRating(@PathVariable String clientId) {
		return centralService.getAverageRatingOfClient(clientId);
	}

	@PostMapping("/call/auditLogs/submit")
	public Boolean submitCallAuditLog(@RequestBody CallAuditLogDto callAuditLogDto) {
		return centralService.saveCallAuditLog(callAuditLogDto);
	}


	// Test Endpoint ( Not for application Use )

//	@PutMapping("/data/{spc}")
//	public Integer getDetail(@PathVariable String spc) {
//		List<Patient> patients = patientRepository.getPatientBySpecie(spc);
//
//		List<String> givenNames = DemoData.getFirstNames();
//		List<String> familyNames = DemoData.getFamilyNames();
//		List<String> phones = DemoData.getPhoneNumbers();
//
//		int count =0;
//
//		for(Patient patient : patients) {
//			ClientInfoDto clientInfoDto = centralService.getClientInformationFromPatient(IdConverter.fromStandardBinaryUUID(patient.getId()).toString());
//			List<Client> clients = clientRepository.getClientByEmail(clientInfoDto.getAssociatedClientEmail());
//
//			Client client = clients.stream().findFirst().get();
//
//			if(client.getOriginTypeCode() != null && client.getOriginTypeCode().equalsIgnoreCase("DEMO"))
//				continue;
//
//			String firstName = DemoData.randomValue(givenNames);
//			String lastName = DemoData.randomValue(familyNames);
//			String email = DemoData.randomEmail(firstName,lastName);
//			String phone = DemoData.randomValue(phones);
//
//			client.setGivenName(firstName);
//			client.setFamilyName(lastName);
//
//			if(client.getPhoneNumbers() != null && client.getPhoneNumbers().size() != 0) {
//				PhoneNumber phoneNumber = client.getPhoneNumbers().stream().findFirst().get();
//				phoneNumber.setNumber(phone);
//				client.setPhoneNumbers(Collections.singletonList(phoneNumber));
//			} else {
//				PhoneNumber phoneNumber = new PhoneNumber();
//				phoneNumber.setNumber(phone);
//				client.setPhoneNumbers(Collections.singletonList(phoneNumber));
//			}
//
//			if(client.getEmailAddresses() != null && client.getEmailAddresses().size() != 0) {
//				EmailAddress emailAddress = client.getEmailAddresses().stream().findFirst().get();
//				emailAddress.setAddress(email);
//				client.setEmailAddresses(Collections.singletonList(emailAddress));
//			} else {
//				EmailAddress emailAddress = new EmailAddress();
//				emailAddress.setAddress(email);
//				client.setEmailAddresses(Collections.singletonList(emailAddress));
//			}
//
//			client.setOriginTypeCode("DEMO");
//
//			System.out.println(IdConverter.fromStandardBinaryUUID(client.getId()).toString());
//			count++;
//			clientRepository.save(client);
//		}
//
//		return count;
//	}

//	@GetMapping("/addClientLogin/{specie}")
//	public Integer getTopBreeds(@PathVariable String specie) {
//
//		List<Patient> list = patientRepository.getPatientBySpecie(specie);
//		int count =0;
//
//		for(Patient patient : list) {
//
//			ClientInfoDto client = centralService.getClientInformationFromPatient(IdConverter.fromStandardBinaryUUID(patient.getId()).toString());
//
//			Boolean flag = centralService.updateClientLogin(client);
//
//			if(flag) {
//				count++;
//				System.out.println(client.getAssociatedClientEmail());
//			}
//		}
//		return count;
//	}

}