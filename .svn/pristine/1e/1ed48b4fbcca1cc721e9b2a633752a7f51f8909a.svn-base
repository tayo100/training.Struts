/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Biodata extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4020974198438469327L;
	
	/**
	 * The Enum TITLE.
	 */
	public enum TITLE {

		/** Ms. */
		Ms,

		/** Mrs. */
		Mrs,

		/** Mr. */
		Mr,

		/** Dr. */
		Dr,

		/** Chief. */
		Chief,

		/** Prof. */
		Prof,

		/** Engr. */
		Engr,

		/** Rev. */
		Rev
	}
	
	/**
	 * The Enum GENDER.
	 */
	public enum GENDER {

		/** Male. */
		Male,

		/** Female. */
		Female
	}
	
	/**
	 * The Enum UNDERSTANDING.
	 */
	public enum UNDERSTANDING {

		/** Yes. */
		Fluently,
		/** Partially. */
		Partially,
		/** No. */
		No
	}
	
	/**
	 * The Enum MARITALSTATUS.
	 */
	public enum MARITALSTATUS {
		Single, Married, Divorced
	}
	
	public enum Type {
		CDO, PROJECT
	}
	
	private String refNumber;
	
	private String firstName;
	private String lastName;
	private String homeAddress;
	private String apt_steNumber;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String countryOfBirth;
	private String nationality;
	private Date dob;
	private Date startDate;
	private GENDER gender;
	private TITLE title;
	private Type type;
	private String homePhone;
	private String mobilePhone;
	private String email;
	private UNDERSTANDING english;
	private MARITALSTATUS maritalStatus;
	
	/**
	 * @return the refNumber
	 */
	@Column(length = 100)
	public String getRefNumber() {
		return refNumber;
	}
	
	/**
	 * @param refNumber the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	
	/**
	 * @return the firstName
	 */
	@Column(length = 100)
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	@Column(length = 100)
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the homeAddress
	 */
	@Column(length = 500)
	public String getHomeAddress() {
		return homeAddress;
	}
	
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the apt_steNumber
	 */
	@Column(length = 100)
	public String getApt_steNumber() {
		return apt_steNumber;
	}
	
	/**
	 * @param apt_steNumber the apt_steNumber to set
	 */
	public void setApt_steNumber(String apt_steNumber) {
		this.apt_steNumber = apt_steNumber;
	}
	
	/**
	 * @return the city
	 */
	@Column(length = 100)
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	@Column(length = 100)
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the postalCode
	 */
	@Column(length = 100)
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * @return the country
	 */
	@Column(length = 100)
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return the countryOfBirth
	 */
	@Column(length = 100)
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	
	/**
	 * @param countryOfBirth the countryOfBirth to set
	 */
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	
	/**
	 * @return the nationality
	 */
	@Column(length = 100)
	public String getNationality() {
		return nationality;
	}
	
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * @return the dob
	 */
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * @return the startDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the gender
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public GENDER getGender() {
		return gender;
	}
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(GENDER gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the title
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public TITLE getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(TITLE title) {
		this.title = title;
	}
	
	/**
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public Type getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	/**
	 * @return the homePhone
	 */
	@Column(length = 100)
	public String getHomePhone() {
		return homePhone;
	}
	
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
	/**
	 * @return the mobilePhone
	 */
	@Column(length = 100)
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	/**
	 * @return the email
	 */
	@Column(length = 100)
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the english
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public UNDERSTANDING getEnglish() {
		return english;
	}
	
	/**
	 * @param english the english to set
	 */
	public void setEnglish(UNDERSTANDING english) {
		this.english = english;
	}
	
	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(MARITALSTATUS maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the maritalStatus
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public MARITALSTATUS getMaritalStatus() {
		return maritalStatus;
	}
	
	/**
	 * Gets the full name.
	 * 
	 * @return the full name
	 */
	@Transient
	public String getFullName() {
		StringBuffer sb = new StringBuffer();
		if (this.firstName != null)
			sb.append(this.firstName).append(" ");
		sb.append(this.lastName);
		return sb.toString().trim();
	}
}
