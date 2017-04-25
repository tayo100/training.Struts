package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;

@Entity
public class ApplicantsBioData extends VersionedEntity {
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
	private GENDER gender;
	
	private String nationality;
	private Date dateOfBirth;
	
	private String correspondenceEmailAddress;
	private String correspondenceCellular;
	private String correspondenceAddress;
	private String correspondenceCity;
	private String correspondenceState;
	private String correspondencePostalCode;
	private String correspondenceCountry;
	private String correspondenceTelephone;
	
	private String permanentAddress;
	private String permanentCity;
	private String permanentState;
	private String permanentPostalCode;
	private String permanentCountry;
	
	private String nextOfKinName;
	private String nextOfKinAddrs;
	private String nextOfKinRelationship;
	private String nextOfKinTelNo;
	
	private String fileName;
	private String password;

	//private UNDERSTANDING english;
	private String motherTongue;

	private List<EducationAndTraining> educationAndTraining = new ArrayList<EducationAndTraining>();
	private List<PreviousEducationAndTraining> previousEducationAndTraining = new ArrayList<PreviousEducationAndTraining>();
	private List<OtherDegreesObtained> otherDegreesObtained = new ArrayList<OtherDegreesObtained>();
	private List<OtherStudiesAndTraining> otherStudiesAndTraining = new ArrayList<OtherStudiesAndTraining>();
	
	
	private List<EmploymentHistory> employmentHistory = new ArrayList<EmploymentHistory>();
	private List<PreviousEmploymentHistory> previousEmploymentHistory = new ArrayList<PreviousEmploymentHistory>();
	
	private List<LanguageSpoken> languageSpoken = new ArrayList<LanguageSpoken>();
	
	private List<Application> application = new ArrayList<Application>();
	private List<ApplicantsBioDataLog> applicants = new ArrayList<ApplicantsBioDataLog>();
	
	private ApplicationStarter appStarter;
	private STATUS status = STATUS.DRAFT;

	
	public enum STATUS{DRAFT, REGISTERED}
	
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

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(length = 150)
	public String getNationality() {
		return nationality;
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

	public String getCorrespondenceEmailAddress() {
		return correspondenceEmailAddress;
	}

	public void setCorrespondenceEmailAddress(String correspondenceEmailAddress) {
		this.correspondenceEmailAddress = correspondenceEmailAddress;
	}

	public String getCorrespondenceCellular() {
		return correspondenceCellular;
	}

	public void setCorrespondenceCellular(String correspondenceCellular) {
		this.correspondenceCellular = correspondenceCellular;
	}

	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public String getCorrespondenceCity() {
		return correspondenceCity;
	}

	public void setCorrespondenceCity(String correspondenceCity) {
		this.correspondenceCity = correspondenceCity;
	}

	public String getCorrespondenceState() {
		return correspondenceState;
	}

	public void setCorrespondenceState(String correspondenceState) {
		this.correspondenceState = correspondenceState;
	}

	public String getCorrespondencePostalCode() {
		return correspondencePostalCode;
	}

	public void setCorrespondencePostalCode(String correspondencePostalCode) {
		this.correspondencePostalCode = correspondencePostalCode;
	}

	public String getCorrespondenceCountry() {
		return correspondenceCountry;
	}

	public void setCorrespondenceCountry(String correspondenceCountry) {
		this.correspondenceCountry = correspondenceCountry;
	}

	public String getCorrespondenceTelephone() {
		return correspondenceTelephone;
	}

	public void setCorrespondenceTelephone(String correspondenceTelephone) {
		this.correspondenceTelephone = correspondenceTelephone;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentPostalCode() {
		return permanentPostalCode;
	}

	public void setPermanentPostalCode(String permanentPostalCode) {
		this.permanentPostalCode = permanentPostalCode;
	}

	public String getPermanentCountry() {
		return permanentCountry;
	}

	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}

	public void setEducationAndTraining(List<EducationAndTraining> educationAndTraining) {
		this.educationAndTraining = educationAndTraining;
	}
		
	public void setPreviousEducationAndTraining(List<PreviousEducationAndTraining> previousEducationAndTraining) {
		this.previousEducationAndTraining = previousEducationAndTraining;
	}
	
	/**
	 * List of education and training on this biodata
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<PreviousEducationAndTraining> getPreviousEducationAndTraining() {
		return previousEducationAndTraining;
	}
	
	/**
	 * List of education and training on this biodata
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<LanguageSpoken> getLanguageSpoken() {
		return languageSpoken;
	}
	
	public void setLanguageSpoken(List<LanguageSpoken> languageSpoken) {
		this.languageSpoken = languageSpoken;
	}
	
	/**
	 * List of education and training on this biodata
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<EducationAndTraining> getEducationAndTraining() {
		return educationAndTraining;
	}
	
	/**
	 * List of other degrees obtained on this biodata
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<OtherDegreesObtained> getOtherDegreesObtained() {
		return otherDegreesObtained;
	}
	
	public void setOtherDegreesObtained(List<OtherDegreesObtained> otherDegreesObtained) {
		this.otherDegreesObtained = otherDegreesObtained;
	}
	
	public void setOtherStudiesAndTraining(List<OtherStudiesAndTraining> otherStudiesAndTraining) {
		this.otherStudiesAndTraining = otherStudiesAndTraining;
	}
	
	/**
	 * List of other studies and training on this biodata
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<OtherStudiesAndTraining> getOtherStudiesAndTraining() {
		return otherStudiesAndTraining;
	}
	
	/**
	 * @param previousEmploymentHistory the previousEmploymentHistory to set
	 */
	public void setPreviousEmploymentHistory(List<PreviousEmploymentHistory> previousEmploymentHistory) {
		this.previousEmploymentHistory = previousEmploymentHistory;
	}

	/**
	 * @return the previousEmploymentHistory
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<PreviousEmploymentHistory> getPreviousEmploymentHistory() {
		return previousEmploymentHistory;
	}

	public void setEmploymentHistory(List<EmploymentHistory> employmentHistory) {
		this.employmentHistory = employmentHistory;
	}
	
	/**
	 * List of employment history on this biodata
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<EmploymentHistory> getEmploymentHistory() {
		return employmentHistory;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(length = 500)
	public String getPermanentAddress() {
		return permanentAddress;
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
	
	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	@Column(length = 255)
	public String getMotherTongue() {
		return motherTongue;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "biodata")
	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
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
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "biodata")
	public ApplicationStarter getAppStarter() {
		return appStarter;
	}

	public void setAppStarter(ApplicationStarter appStarter) {
		this.appStarter = appStarter;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public STATUS getStatus() {
		return status;
	}
	
	public void setStatus(STATUS status) {
		this.status = status;
	}

	/**
	 * @param applicants the applicants to set
	 */
	public void setApplicants(List<ApplicantsBioDataLog> applicants) {
		this.applicants = applicants;
	}

	/**
	 * @return the applicants
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
	public List<ApplicantsBioDataLog> getApplicants() {
		return applicants;
	}
}