/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class Milestone extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String milestone;
	private Date startingDate;
	private Date endingDate;
	private GraduateResearchTraining application;
	
	/**
	 * @return the milestone
	 */
	public String getMilestone() {
		return milestone;
	}
	/**
	 * @param milestone the milestone to set
	 */
	public void setMilestone(String milestone) {
		this.milestone = milestone;
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
	 * @return the endingDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getEndingDate() {
		return endingDate;
	}
	/**
	 * @param endingDate the endingDate to set
	 */
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	/**
	 * @return the application
	 */
	@ManyToOne(cascade = {}, optional = false)
	public GraduateResearchTraining getApplication() {
		return application;
	}
	/**
	 * @param application the application to set
	 */
	public void setApplication(GraduateResearchTraining application) {
		this.application = application;
	}	
}
