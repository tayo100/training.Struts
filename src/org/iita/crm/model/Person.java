package org.iita.crm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;
import org.iita.util.StringUtil;

/**
 * <p>
 * Person information is the core of this system. A person can be a {@link Trainee}, {@link Trainer}, etc. There should be only one Person record per
 * individual.
 * </p>
 */
@Indexed
@Entity
@ClassBridge(impl = org.iita.crm.lucene.PersonBridge.class)
// Disabled unique constraint for now
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id" }) })
public class Person extends VersionedEntity {

	/**
	 * The Enum Gender.
	 */
	public enum Gender {

		/** Male. */
		MALE,

		/** Female. */
		FEMALE
	}

	/**
	 * The Enum MaritalStatus.
	 */
	public enum MaritalStatus {

		/** Married. */
		MARRIED,

		/** Single. */
		SINGLE
	}
	
	/**
	 * The Enum AlumniStatus.
	 */
	public enum AlumniStatus {

		/** YES. */
		YES,

		/** NO. */
		NO
	}


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2458298099856790650L;

	/** The user. */
	private User user;

	/** The title. */
	private String title;

	/** The last name. */
	private String lastName;

	/** The first name. */
	private String firstName;

	/** The other names. */
	private String otherNames;

	/** The gender. */
	private Gender gender;

	/** The country. */
	private String country;

	/** The dob. */
	private Date dob;

	/** The last address. */
	private AddressContact lastAddress = null;

	/** The last email. */
	private EmailContact lastEmail = null;

	/** The last phone. */
	private PhoneContact lastPhone = null;

	/** The last affiliation. */
	private Affiliation lastAffiliation = null;

	/** The contacts. */
	private List<Contact> contacts = new ArrayList<Contact>();

	/** The affiliations. */
	private List<Affiliation> affiliations;
	
	/** The partners. */
	private List<PartnerPersonContact> partnerPersonContacts;

	/** The marital status. */
	private MaritalStatus maritalStatus;

	/** The country of residence. */
	private String countryOfResidence;

	private List<PersonMail> mails;
	
	private List<PersonDocument> documents;
	
	/** The alumni status. */
	private AlumniStatus alumniStatus;

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	@ManyToOne(cascade = {}, optional = true)
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	@Column(length = 200, nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	@Column(length = 100, nullable = true)
	public String getFirstName() {
		return firstName;
	} 

	/**
	 * Sets the first name.
	 * 
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the other names.
	 * 
	 * @return the other names
	 */
	@Column(length = 100)
	public String getOtherNames() {
		return otherNames;
	}

	/**
	 * Sets the other names.
	 * 
	 * @param otherNames the new other names
	 */
	public void setOtherNames(String otherNames) {
		this.otherNames = StringUtil.nullOrString(otherNames);
	}

	/**
	 * @return the title
	 */
	@Column(length = 30)
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = StringUtil.nullOrString(title);
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 6)
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	@Column(length = 50)
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = StringUtil.nullOrString(country);
	}

	/**
	 * Get date of birth.
	 * 
	 * @return the dob
	 */
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 * 
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the contacts.
	 * 
	 * @return the contacts
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "person")
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * Sets the contacts.
	 * 
	 * @param contacts the new contacts
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
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
		if (this.otherNames != null)
			sb.append(this.otherNames).append(" ");
		sb.append(this.lastName);
		return sb.toString().trim();
	}

	/**
	 * Gets the legal name.
	 * 
	 * @return the legal name
	 */
	@Transient
	public String getLegalName() {
		StringBuffer sb = new StringBuffer();
		if (this.title != null){
			if (!this.title.contains("."))
				sb.append(this.title).append(". ");
			else
				sb.append(this.title).append(" ");
		}
		sb.append(this.lastName).append(",");
		if (this.firstName != null)
			sb.append(" ").append(this.firstName);
		if (this.otherNames != null)
			sb.append(" ").append(this.otherNames);

		return sb.toString().trim().replaceAll(",$", "");
	}

	@Transient
	public String getAddressContacts(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAddress!=null){
			if(this.lastAddress.getAddress()!=null)
				sb.append(this.lastAddress.getAddress());
			if(this.lastAddress.getCity()!=null)
				sb.append(", ").append(this.lastAddress.getCity());
			if(this.lastAddress.getState()!=null)
				sb.append(", ").append(this.lastAddress.getState());
		}	
		
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressContact(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAddress!=null)
			if(this.lastAddress.getAddress()!=null)
				sb.append(this.lastAddress.getAddress());		
		
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressCity(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAddress!=null)
			if(this.lastAddress.getCity()!=null)
				sb.append(", ").append(this.lastAddress.getCity());
		
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressState(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAddress!=null)
			if(this.lastAddress.getState()!=null)
				sb.append(", ").append(this.lastAddress.getState());
		
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressCountry(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAddress!=null){
			if(this.lastAddress.getCountry()!=null)
				sb.append(", ").append(this.lastAddress.getCountry());
		}	
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getEmailContacts(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastEmail!=null){
			if(this.lastEmail.getEmail()!=null)
				sb.append(this.lastEmail.getEmail());
		}	
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getPhoneContacts(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastPhone!=null){
			if(this.lastPhone.getPhoneNumber()!=null)
				sb.append(this.lastPhone.getPhoneNumber());
		}	
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAffiliationContacts(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAffiliation!=null){
			if(this.lastAffiliation.getOrganization()!=null){
				if(this.lastAffiliation.getOrganization().getShortName()!=null)
					sb.append(this.lastAffiliation.getOrganization().getShortName());
				else if(this.lastAffiliation.getOrganization().getTitle()!=null)
					sb.append(this.lastAffiliation.getOrganization().getTitle());
			}
		}	
		return sb.toString().trim().replaceAll(",$", "");
	}
	@Transient
	public String getDesignation(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this person
		if(this.lastAffiliation!=null){
			if(this.lastAffiliation.getOrganization()!=null){
				if(this.lastAffiliation.getJobTitle()!=null)
					sb.append(this.lastAffiliation.getJobTitle());
			}
		}	
		return sb.toString().trim().replaceAll(",$", "");
	}
	/**
	 * Gets the last address.
	 * 
	 * @return the lastAddress
	 */
	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public AddressContact getLastAddress() {
		return this.lastAddress;
	}

	/**
	 * Sets the last address.
	 * 
	 * @param lastAddress the lastAddress to set
	 */
	public void setLastAddress(AddressContact lastAddress) {
		this.lastAddress = lastAddress;
	}

	/**
	 * Gets the last email.
	 * 
	 * @return the lastEmail
	 */
	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public EmailContact getLastEmail() {
		return this.lastEmail;
	}

	/**
	 * Sets the last email.
	 * 
	 * @param lastEmail the lastEmail to set
	 */
	public void setLastEmail(EmailContact lastEmail) {
		this.lastEmail = lastEmail;
	}

	/**
	 * Gets the last phone.
	 * 
	 * @return the lastPhone
	 */
	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public PhoneContact getLastPhone() {
		return this.lastPhone;
	}

	/**
	 * Sets the last phone.
	 * 
	 * @param lastPhone the lastPhone to set
	 */
	@OneToOne(cascade = {}, optional = true)
	public void setLastPhone(PhoneContact lastPhone) {
		this.lastPhone = lastPhone;
	}

	/**
	 * Gets the affiliations.
	 * 
	 * @return the affiliations
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "person")
	public List<Affiliation> getAffiliations() {
		return this.affiliations;
	}

	/**
	 * Sets the affiliations.
	 * 
	 * @param affiliations the affiliations to set
	 */
	public void setAffiliations(List<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}
	
	/**
	 * Gets the partnerPersonContacts.
	 * 
	 * @return the partnerPersonContacts
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "person")
	public List<PartnerPersonContact> getPartnerPersonContacts() {
		return this.partnerPersonContacts;
	}

	/**
	 * Sets the partners.
	 * 
	 * @param partnerPersonContacts the partnerPersonContacts to set
	 */
	public void setPartnerPersonContacts(List<PartnerPersonContact> partnerPersonContacts) {
		this.partnerPersonContacts = partnerPersonContacts;
	}

	/**
	 * Gets the last affiliation.
	 * 
	 * @return the lastAffiliation
	 */
	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public Affiliation getLastAffiliation() {
		return this.lastAffiliation;
	}

	/**
	 * Sets the last affiliation.
	 * 
	 * @param lastAffiliation the lastAffiliation to set
	 */
	public void setLastAffiliation(Affiliation lastAffiliation) {
		this.lastAffiliation = lastAffiliation;
	}

	/**
	 * Gets the marital status.
	 * 
	 * @return the marital status
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 7)
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Sets the marital status.
	 * 
	 * @param maritalStatus the new marital status
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Gets the country of residence.
	 * 
	 * @return the country of residence
	 */
	@Column(length = 50)
	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	/**
	 * Sets the country of residence.
	 * 
	 * @param countryOfResidence the new country of residence
	 */
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = StringUtil.nullOrString(countryOfResidence);
	}

	/**
	 * Sets the last contact.
	 * 
	 * @param contact the contact
	 */
	public void setLastContact(Contact contact) {
		if (contact instanceof AddressContact)
			this.setLastAddress((AddressContact) contact);
		else if (contact instanceof EmailContact)
			this.setLastEmail((EmailContact) contact);
		else if (contact instanceof PhoneContact)
			this.setLastPhone((PhoneContact) contact);
	}

	/**
	 * @return the mails
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "person")
	public List<PersonMail> getMails() {
		return this.mails;
	}

	/**
	 * @param mails the mails to set
	 */
	public void setMails(List<PersonMail> mails) {
		this.mails = mails;
	}
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Person %1$s", this.getFullName());
	}
	
	/**
	 * @return the documents
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<PersonDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<PersonDocument> documents) {
		this.documents = documents;
	}

	/**
	 * @param alumni the alumni to set
	 */
	public void setAlumniStatus(AlumniStatus alumniStatus) {
		this.alumniStatus = alumniStatus;
	}

	/**
	 * Gets the alumni status.
	 * 
	 * @return the alumni status
	 */
	@Enumerated(EnumType.STRING)
	public AlumniStatus getAlumniStatus() {
		return alumniStatus;
	}
}
