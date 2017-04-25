package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;

@Entity
public class ApplicantsBioDataLog extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6869219210546976460L;
	private User owner;
	private TITLE title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String maidenName;
	private String placeOfBirth;
	private String currentNationality;
	private String nationality;
	private String passportNumber;
	private String emailAddress;
	private String telephoneNumbers;
	private String permanentAddress;
	private String permAddressTelephone;
	private String spouseName;
	private Date dateOfBirth;
	private String nextOfKinName;
	private String nextOfKinAddrs;
	private String nextOfKinRelationship;
	private String nextOfKinTelNo;
	private String fileName;
	private String password;

	private GENDER gender;
	private MARITALSTATUS maritalStatus;
	private UNDERSTANDING english;

	private ApplicantsBioData applicant;
	/**
	 * @return the owner
	 */
	@ManyToOne(optional = false, cascade = {})
	public User getOwner() {
		return this.owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
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
	 * The Enum MARITALSTATUS.
	 */
	public enum MARITALSTATUS {
		Single, Married, Divorced
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
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(length = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(length = 150)
	public String getMiddleName() {
		return middleName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	@Column(length = 150)
	public String getMaidenName() {
		return maidenName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(length = 150)
	public String getLastName() {
		return lastName;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@Column(length = 255)
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setCurrentNationality(String currentNationality) {
		this.currentNationality = currentNationality;
	}

	@Column(length = 150)
	public String getCurrentNationality() {
		return currentNationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(length = 150)
	public String getNationality() {
		return nationality;
	}

	public void setTelephoneNumbers(String telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}

	@Column(length = 255)
	public String getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Column(length = 255)
	public String getPassportNumber() {
		return passportNumber;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(length = 80)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	
	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	/**
	 * @return the maritalStatus
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public GENDER getGender() {
		return gender;
	}

	public void setMaritalStatus(MARITALSTATUS maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the maritalStatus
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public MARITALSTATUS getMaritalStatus() {
		return maritalStatus;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setPermAddressTelephone(String permAddressTelephone) {
		this.permAddressTelephone = permAddressTelephone;
	}

	@Column(length = 15)
	public String getPermAddressTelephone() {
		return permAddressTelephone;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(length = 500)
	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	@Column(length = 255)
	public String getSpouseName() {
		return spouseName;
	}

	public void setNextOfKinName(String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}

	@Column(length = 255)
	public String getNextOfKinName() {
		return nextOfKinName;
	}

	public void setNextOfKinAddrs(String nextOfKinAddrs) {
		this.nextOfKinAddrs = nextOfKinAddrs;
	}

	@Column(length = 500)
	public String getNextOfKinAddrs() {
		return nextOfKinAddrs;
	}

	public void setNextOfKinRelationship(String nextOfKinRelationship) {
		this.nextOfKinRelationship = nextOfKinRelationship;
	}

	@Column(length = 25)
	public String getNextOfKinRelationship() {
		return nextOfKinRelationship;
	}

	public void setNextOfKinTelNo(String nextOfKinTelNo) {
		this.nextOfKinTelNo = nextOfKinTelNo;
	}

	@Column(length = 255)
	public String getNextOfKinTelNo() {
		return nextOfKinTelNo;
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
	
	@ManyToOne(cascade = {}, optional = false)
	public ApplicantsBioData getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantsBioData applicant) {
		this.applicant = applicant;
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

	//public void setGraduateApplication(List<GraduateResearchTraining> graduateApplication) {
	//	this.graduateApplication = graduateApplication;
	//}
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	//public List<GraduateResearchTraining> getGraduateApplication() {
	//	return graduateApplication;
	//}

	//public void setNonDegreeApplication(List<NonDegreeTraining> nonDegreeApplication) {
	//	this.nonDegreeApplication = nonDegreeApplication;
	//}

	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	//public List<NonDegreeTraining> getNonDegreeApplication() {
	//	return nonDegreeApplication;
	//}
	
	/**
	 * @return the name
	 */
	@Column(length = 400)
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * @param name the name to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}