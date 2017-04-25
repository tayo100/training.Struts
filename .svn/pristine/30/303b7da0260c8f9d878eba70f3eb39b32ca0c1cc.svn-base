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
public class ClassInteraction extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IYAEvaluation iyaEvaluation;
	private InteractionType classInteraction;
	
	public enum InteractionType {
		UseCaseStudy, Energizers, GroupWorkPresentation, Practicals, AudioVisuals
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

	/**
	 * @param classInteraction the classInteraction to set
	 */
	public void setClassInteraction(InteractionType classInteraction) {
		this.classInteraction = classInteraction;
	}

	/**
	 * @return the classInteraction
	 */
	public InteractionType getClassInteraction() {
		return classInteraction;
	}
	
	

}
