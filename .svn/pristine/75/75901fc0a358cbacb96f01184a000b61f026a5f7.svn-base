/**
 * 
 */
package org.iita.trainingunit.iya.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class IYAEvaluationObjective extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IYATrainingAnnouncement iyaTrainingAnnouncement;
	private IYAEvaluation iyaEvaluation;
	
	/**
	 * @param iyaTrainingAnnouncement the iyaTrainingAnnouncement to set
	 */
	public void setIyaTrainingAnnouncement(IYATrainingAnnouncement iyaTrainingAnnouncement) {
		this.iyaTrainingAnnouncement = iyaTrainingAnnouncement;
	}
	/**
	 * @return the iyaTrainingAnnouncement
	 */
	@OneToOne(cascade = {}, optional = true)
	public IYATrainingAnnouncement getIyaTrainingAnnouncement() {
		return iyaTrainingAnnouncement;
	}
	
	/**
	 * @param iyaEvaluation the iyaEvaluation to set
	 */
	public void setIyaEvaluation(IYAEvaluation iyaEvaluation) {
		this.iyaEvaluation = iyaEvaluation;
	}
	/**
	 * @return the iyaEvaluation
	 */
	@OneToOne(cascade = {}, optional = true)
	public IYAEvaluation getIyaEvaluation() {
		return iyaEvaluation;
	}
	
}
