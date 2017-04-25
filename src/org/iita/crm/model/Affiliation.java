/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.model;

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
import org.iita.util.StringUtil;

/**
 * {@link Person}s can be affiliated to {@link Organization}s. This class holds the affiliation information.
 * 
 * @author mobreza
 */
@Entity
public class Affiliation extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 770865843045775053L;

	/** The organization. */
	private Organization organization;

	/** The person. */
	private Person person;

	/** The department. */
	private String department;

	/** The job title. */
	private String jobTitle;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The type. */
	private AffiliationType type;

	/** Staff ID within organization **/
	private String staffId;
	
	private String channel;
	private String subject;
	private String text;
	private String contactedby;
	

	/**
	 * The Enum AffiliationType.
	 */
	public enum AffiliationType {
		/** Employee at organization */
		EMPLOYEE,
		/** Manager at organization */
		MANAGER,
		/** Trainee at organization */
		TRAINEE,
		/** Consultant at organization */
		CONSULTANT
	}

	/**
	 * Gets the organization.
	 * 
	 * @return the organization
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Organization getOrganization() {
		return this.organization;
	}

	/**
	 * Sets the organization.
	 * 
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * Gets the person.
	 * 
	 * @return the person
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Person getPerson() {
		return this.person;
	}

	/**
	 * Sets the person.
	 * 
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	public AffiliationType getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the type to set
	 */
	public void setType(AffiliationType type) {
		this.type = type;
	}

	/**
	 * Gets the department.
	 * 
	 * @return the department
	 */
	@Column(length = 200)
	public String getDepartment() {
		return this.department;
	}

	/**
	 * Sets the department.
	 * 
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = StringUtil.nullOrString(department);
	}

	/**
	 * Gets the job title.
	 * 
	 * @return the jobTitle
	 */
	@Column(length = 200)
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Sets the job title.
	 * 
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = StringUtil.nullOrString(jobTitle);
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the startDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 * 
	 * @return the endDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Get staff ID within the organization
	 * 
	 * @return the staffID
	 */
	@Column(nullable = true, length = 50)
	public String getStaffId() {
		return this.staffId;
	}

	/**
	 * @param staffID the staffID to set
	 */
	public void setStaffId(String staffId) {
		this.staffId = StringUtil.nullOrString(staffId);
	}

	@Transient
	public boolean isExpired() {
		if (this.endDate != null && this.endDate.before(new Date()))
			return true;
		return false;
	}

	@Column(length = 255)
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Column(length = 255)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(length = 100)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(length = 255)
	public String getContactedby() {
		return contactedby;
	}

	public void setContactedby(String contactedby) {
		this.contactedby = contactedby;
	}
}
