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
	//private IYATrainingAnnouncement iyaTrainingAnnouncement;
	private IYAEvaluation iyaEvaluation;
	private String objective;
	

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
