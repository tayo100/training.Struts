/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.announcements.model.TrainingLocation;

/**
 * @author ken
 *
 */
@Entity
public class ApplicantTrainingLocation extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2486378391505525588L;
	private Application application;
	private TrainingLocation trainingLocation;
	
	public void setApplication(Application application) {
		this.application = application;
	}
	
	@OneToOne(cascade = {}, optional = true)
	public Application getApplication() {
		return application;
	}
	
	public void setTrainingLocation(TrainingLocation trainingLocation) {
		this.trainingLocation = trainingLocation;
	}
	
	@OneToOne(cascade = {}, optional = true)
	public TrainingLocation getTrainingLocation() {
		return trainingLocation;
	}
	
}
