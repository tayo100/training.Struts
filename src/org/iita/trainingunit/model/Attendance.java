package org.iita.trainingunit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.crm.model.Person;
import org.iita.entity.VersionedEntity;

/**
 * <p>
 * Any group training will usually have several participants. Attending participant information is valuable reporting data and is required for reporting to
 * donors.
 * </p>
 * <p>
 * Attendance record holds information about one person attending a group training session. Attendee information is by default not converted to {@link Person}
 * (too much data), but it can be linked to an existing {@link Person} where so required.
 * </p>
 * 
 * @author koraegbunam
 */
@Entity
public class Attendance extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2533023829124114159L;

	/**
	 * The Enum Gender.
	 */
	public enum Gender {
		/** Male */
		MALE,
		/** Female */
		FEMALE
	}

	/** The last name. */
	private String lastName;

	/** The first name. */
	private String firstName;

	/** The email. */
	private String email;

	/** The phone. */
	private String phone;

	/** The address. */
	private String address;

	/** The education. */
	private String education;

	/** The institute affiliation. */
	private String instituteAffiliation;

	/** The gender. */
	private Gender gender;

	/** The nationality. */
	private String nationality;

	/** The country of residence. */
	private String countryOfResidence;

	/** The attendance date. */
	private Date attendanceDate;

	/** The dob. */
	private Date dob;

	/** The other. */
	private String other;

	/** The designation. */
	private String designation;

	/** The training program. */
	private TrainingProgram trainingProgram;

	/** The attendee. */
	private Person attendee;

	/** The present. */
	private boolean present = false;
	
	/** The background. */
	private String background;
	
	/**
	 * Gets the last name.
	 * 
	 * @return the lastName
	 */
	@Column(length = 35, nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the firstName
	 */
	@Column(length = 35, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 * 
	 * @return the phone
	 */
	@Column(length = 80)
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 * 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	@Lob
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the education.
	 * 
	 * @return the education
	 */
	@Column(length = 250)
	public String getEducation() {
		return education;
	}

	/**
	 * Sets the education.
	 * 
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * Gets the institute affiliation.
	 * 
	 * @return the instituteAffiliation
	 */
	@Column(length = 250)
	public String getInstituteAffiliation() {
		return instituteAffiliation;
	}

	/**
	 * Sets the institute affiliation.
	 * 
	 * @param instituteAffiliation the instituteAffiliation to set
	 */
	public void setInstituteAffiliation(String instituteAffiliation) {
		this.instituteAffiliation = instituteAffiliation;
	}

	/**
	 * Gets the other.
	 * 
	 * @return the other
	 */
	@Lob
	public String getOther() {
		return other;
	}

	/**
	 * Sets the other.
	 * 
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * Gets the designation.
	 * 
	 * @return the other
	 */
	@Lob
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 * 
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the nationality.
	 * 
	 * @return the nationality
	 */
	@Column(length = 50)
	public String getNationality() {
		return nationality;
	}

	/**
	 * Sets the nationality.
	 * 
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * Gets the country of residence.
	 * 
	 * @return the countryOfResidence
	 */
	@Column(length = 50)
	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	/**
	 * Sets the country of residence.
	 * 
	 * @param countryOfResidence the countryOfResidence to set
	 */
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	/**
	 * Gets the attendance date.
	 * 
	 * @return the attendanceDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAttendanceDate() {
		return attendanceDate;
	}

	/**
	 * Sets the attendance date.
	 * 
	 * @param attendanceDate the attendanceDate to set
	 */
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	/**
	 * Gets the dob.
	 * 
	 * @return the dob
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 * 
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the training program.
	 * 
	 * @return the training program
	 */
	@ManyToOne(cascade = {}, optional = false)
	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}

	/**
	 * Sets the training program.
	 * 
	 * @param trainingProgram the new training program
	 */
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}

	/**
	 * Gets the attendee. This allows us to link attendee to a {@link Person} record in the system and also display attendance to group trainings in personal
	 * profile
	 * 
	 * @return the attendee
	 */
	@ManyToOne(cascade = {}, optional = true)
	public Person getAttendee() {
		return attendee;
	}

	/**
	 * Sets the attendee.
	 * 
	 * @param attendee the new attendee
	 */
	public void setAttendee(Person attendee) {
		this.attendee = attendee;
	}

	/**
	 * Checks if attendee was present
	 * 
	 * @return true, if is present
	 */
	public boolean isPresent() {
		return present;
	}

	/**
	 * Sets that attendee was present at session
	 * 
	 * @param present the new present
	 */
	public void setPresent(boolean present) {
		this.present = present;
	}

	/**
	 * Sets the background.
	 * 
	 * @param background the background to set
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	
	/**
	 * Gets the background.
	 * 
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}
}
