/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class PreviousEmploymentHistory extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String position;
	private Long id;
	private String nameOfEmployer;
	private String addressOfEmployer;
	private Date startingDate;
	private Date finishingDate;
	private CONDITION empCondition;
	private String responsibilities;
	private String supervisorName;
	private String supervisorEmail;
	private String fullPublicationDetails; 
	
	
	public enum CONDITION {Permanent, Temporary}
	
	private ApplicantsBioData biodata;
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}
	
	/**
	 * @param id the id destination set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNameOfEmployer(String nameOfEmployer) {
		this.nameOfEmployer = nameOfEmployer;
	}

	@Column(length = 255)
	public String getNameOfEmployer() {
		return nameOfEmployer;
	}

	public void setAddressOfEmployer(String addressOfEmployer) {
		this.addressOfEmployer = addressOfEmployer;
	}

	@Column(length = 500)
	public String getAddressOfEmployer() {
		return addressOfEmployer;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(length = 255)
	public String getPosition() {
		return position;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getStartingDate() {
		return startingDate;
	}
	
	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getFinishingDate() {
		return finishingDate;
	}
	
	/**
	 * @param empCondition the empCondition to set
	 */
	public void setEmpCondition(CONDITION empCondition) {
		this.empCondition = empCondition;
	}

	/**
	 * @return the condition
	 */
	@Enumerated(EnumType.STRING)
	public CONDITION getEmpCondition() {
		return empCondition;
	}

	/**
	 * @param responsibilities the responsibilities to set
	 */
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	/**
	 * @return the responsibilities
	 */
	@Column(length = 255)
	public String getResponsibilities() {
		return responsibilities;
	}

	/**
	 * @param supervisorName the supervisorName to set
	 */
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	/**
	 * @return the supervisorName
	 */
	@Column(length = 100)
	public String getSupervisorName() {
		return supervisorName;
	}

	/**
	 * @param supervisorEmail the supervisorEmail to set
	 */
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}

	/**
	 * @return the supervisorEmail
	 */
	@Column(length = 30)
	public String getSupervisorEmail() {
		return supervisorEmail;
	}
	
	public void setFullPublicationDetails(String fullPublicationDetails) {
		this.fullPublicationDetails = fullPublicationDetails;
	}

	@Column(length = 4000)
	public String getFullPublicationDetails() {
		return fullPublicationDetails;
	}

	/**
	 * Get the parent biodata record
	 * 
	 * @see biodata
	 * @return the biodata
	 */
	@ManyToOne(cascade = {}, optional = false)
	public ApplicantsBioData getBiodata() {
		return this.biodata;
	}

	public void setBiodata(ApplicantsBioData biodata) {
		this.biodata = biodata;
	}

}
