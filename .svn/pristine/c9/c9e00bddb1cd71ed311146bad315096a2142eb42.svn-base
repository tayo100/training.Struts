/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class TimeSchedule extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int duration;
	private String startMonthYearPeriod;
	private GraduateResearchTraining application;
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param startMonthYearPeriod the startMonthYearPeriod to set
	 */
	public void setStartMonthYearPeriod(String startMonthYearPeriod) {
		this.startMonthYearPeriod = startMonthYearPeriod;
	}

	/**
	 * @return the startMonthPeriod
	 */
	public String getStartMonthYearPeriod() {
		return startMonthYearPeriod;
	}
	
	/**
	 * Get the parent application record
	 * 
	 * @see application
	 * @return the application
	 */
	@OneToOne(cascade = {}, optional = false)
	public GraduateResearchTraining getApplication() {
		return this.application;
	}

	public void setApplication(GraduateResearchTraining application) {
		this.application = application;
	}

}
