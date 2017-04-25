/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class AdministrativeExperience extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String position;
	private String nameOfEmployer;
	private CONDITION empCondition;
	private Date startingDate;
	private Date finishingDate;
	private String adminResponsibility;
	private String adminDescription;
	private String scientificResponsibility;
	private String scientificDescription;
	private String experience;
	private Application application;
	

	public enum CONDITION {Permanent, Temporary}
	
	/**
	 * @return the position
	 */
	@Column(length = 255)
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the nameOfEmployer
	 */
	@Column(length = 255)
	public String getNameOfEmployer() {
		return nameOfEmployer;
	}

	/**
	 * @param nameOfEmployer the nameOfEmployer to set
	 */
	public void setNameOfEmployer(String nameOfEmployer) {
		this.nameOfEmployer = nameOfEmployer;
	}

	/**
	 * @return the empCondition
	 */
	@Column(length = 20)
	public CONDITION getEmpCondition() {
		return empCondition;
	}

	/**
	 * @param empCondition the empCondition to set
	 */
	public void setEmpCondition(CONDITION empCondition) {
		this.empCondition = empCondition;
	}

	/**
	 * @return the startingDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getStartingDate() {
		return startingDate;
	}

	/**
	 * @param startingDate the startingDate to set
	 */
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	/**
	 * @return the finishingDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getFinishingDate() {
		return finishingDate;
	}

	/**
	 * @param finishingDate the finishingDate to set
	 */
	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}

	/**
	 * @return the adminResponsibility
	 */
	@Column(length = 10)
	public String getAdminResponsibility() {
		return adminResponsibility;
	}

	/**
	 * @param adminResponsibility the adminResponsibility to set
	 */
	public void setAdminResponsibility(String adminResponsibility) {
		this.adminResponsibility = adminResponsibility;
	}

	/**
	 * @param adminDescription the adminDescription to set
	 */
	public void setAdminDescription(String adminDescription) {
		this.adminDescription = adminDescription;
	}

	/**
	 * @return the adminDescription
	 */
	@Column(length = 400)
	public String getAdminDescription() {
		return adminDescription;
	}

	/**
	 * @return the scientificResponsibility
	 */
	@Column(length = 10)
	public String getScientificResponsibility() {
		return scientificResponsibility;
	}

	/**
	 * @param scientificResponsibility the scientificResponsibility to set
	 */
	public void setScientificResponsibility(String scientificResponsibility) {
		this.scientificResponsibility = scientificResponsibility;
	}
	
	/**
	 * @param scientificDescription the scientificDescription to set
	 */
	public void setScientificDescription(String scientificDescription) {
		this.scientificDescription = scientificDescription;
	}

	/**
	 * @return the scientificDescription
	 */
	@Column(length = 400)
	public String getScientificDescription() {
		return scientificDescription;
	}

	/**
	 * @return the experience
	 */
	@Column(length = 400)
	public String getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}

	/**
	 * @return the application
	 */
	@OneToOne(cascade = {}, optional = false)
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Application application) {
		this.application = application;
	}


}
