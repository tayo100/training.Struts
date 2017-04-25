package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Unsolicited {

	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private GENDER gender;
	private String emailAddress;
	private String telephoneNumbers;	
	private String subject;
	private String mail;
	
	public enum GENDER {Male, Female}
	
	@Column(length = 50)
	public String getFirstName() {
		return firstName;
	}

	@Column(length = 150)
	public String getLastName() {
		return lastName;
	}

	@Column(length = 150)
	public String getMiddleName() {
		return middleName;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 6)
	public GENDER getGender() {
		return gender;
	}

	@Column(length = 80)
	public String getEmailAddress() {
		return emailAddress;
	}

	@Column(length = 255)
	public String getTelephoneNumbers() {
		return telephoneNumbers;
	}

	@Column(length = 255)
	public String getAddress() {
		return address;
	}

	@Column(length = 255)
	public String getSubject() {
		return subject;
	}

	@Column(length = 255)
	public String getMail() {
		return mail;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTelephoneNumbers(String telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}