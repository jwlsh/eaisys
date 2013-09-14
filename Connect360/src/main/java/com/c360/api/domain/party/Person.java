package com.c360.api.domain.party;

import java.util.Date;

import org.springframework.data.neo4j.annotation.Indexed;

public class Person extends Party {
	
	private String title;
	@Indexed private String firstName;
	@Indexed private String middleName;
	@Indexed private String lastName;
	private String suffix;
	@Indexed private String gender;
	@Indexed private String ssn;
	@Indexed private Date dateOfBirth;
	@Indexed private Date dateOfDeath;
	
	public Person(){
		super();
	}
	
	public Person(String firstName, String middleName, String lastName,
			String gender, String ssn, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.ssn = ssn;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfDeath() {
		return dateOfDeath;
	}
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}	

}
