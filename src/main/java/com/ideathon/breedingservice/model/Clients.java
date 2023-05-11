package com.ideathon.breedingservice.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Clients")
public class Clients{
	
	@BsonProperty("clientKey") private Binary clientKey;
	@BsonProperty("roleTypeCode") private String roleTypeCode;
	
	public Clients() {}
	   	
	public Clients(Binary clientKey, String roleTypeCode) {
		this.clientKey = clientKey;
		this.roleTypeCode = roleTypeCode;
	}

	public Binary getClientKey() {
		return clientKey;
	}
	public void setClientKey(Binary clientKey) {
		this.clientKey = clientKey;
	}
	public String getRoleTypeCode() {
		return roleTypeCode;
	}
	public void setRoleTypeCode(String roleTypeCode) {
		this.roleTypeCode = roleTypeCode;
	}
	  	
}
