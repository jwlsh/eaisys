package com.c360.api.domain.location;

import org.springframework.data.neo4j.annotation.Indexed;

public class PhoneNumber extends Location {

	@Indexed private String countryCode;
	@Indexed private String areaCode;
	@Indexed private String number;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}	
	
}
