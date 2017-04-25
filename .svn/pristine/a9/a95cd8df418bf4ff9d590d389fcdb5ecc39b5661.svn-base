/**
 * 
 */
package org.iita.trainingunit.iya.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class IYAAnnouncementObjective extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IYATrainingAnnouncement iyaTrainingAnnouncement;
	private String objective;
	
	/**
	 * @param iyaTrainingAnnouncement the iyaTrainingAnnouncement to set
	 */
	public void setIyaTrainingAnnouncement(IYATrainingAnnouncement iyaTrainingAnnouncement) {
		this.iyaTrainingAnnouncement = iyaTrainingAnnouncement;
	}
	/**
	 * @return the iyaTrainingAnnouncement
	 */
	@ManyToOne(cascade = {}, optional = true)
	public IYATrainingAnnouncement getIyaTrainingAnnouncement() {
		return iyaTrainingAnnouncement;
	}
	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = objective;
	}
	/**
	 * @return the objective
	 */
	public String getObjective() {
		return objective;
	}
	
	
}
