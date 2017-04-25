/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class InternshipWorkExperience extends VersionedEntity {
	//SELECT startMonthYearOfCertification, CONCAT('01/',startMonthYearOfCertification) as period FROM training.EducationAndTraining WHERE DATE_FORMAT(STR_TO_DATE(CONCAT('01/',startMonthYearOfCertification), '%d/%m/%Y'), '%Y-%m-%d')<CURDATE();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String workExperience;
	private String institution;
	private String country;
	private String periodMonthYear;
	
	private String duration;
	private Date startDate;
	private Date endDate;
	
	private InternshipTraining application;
	
	/**
	 * @return the workExperience
	 */
	@Lob
	public String getWorkExperience() {
		return workExperience;
	}

	/**
	 * @param workExperience the workExperience to set
	 */
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}

	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}

	/**
	 * @return the country
	 */
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
	 * @return the periodMonthYear
	 */
	public String getPeriodMonthYear() {
		return periodMonthYear;
	}

	/**
	 * @param periodMonthYear the periodMonthYear to set
	 */
	public void setPeriodMonthYear(String periodMonthYear) {
		this.periodMonthYear = periodMonthYear;
	}
	
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
	 * @return the endDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the application
	 */
	@ManyToOne(cascade = {}, optional = false)
	public InternshipTraining getApplication() {
		return this.application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(InternshipTraining application) {
		this.application = application;
	}
}
