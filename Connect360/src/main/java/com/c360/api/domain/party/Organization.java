package com.c360.api.domain.party;

import org.springframework.data.neo4j.annotation.Indexed;

public class Organization extends Party {
	
	@Indexed private String name;
	@Indexed private String taxId;
	@Indexed private String sicCode;
	@Indexed private String dunsNumber;
	
	public Organization(){
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getSicCode() {
		return sicCode;
	}
	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}
	public String getDunsNumber() {
		return dunsNumber;
	}
	public void setDunsNumber(String dunsNumber) {
		this.dunsNumber = dunsNumber;
	}
	
}
