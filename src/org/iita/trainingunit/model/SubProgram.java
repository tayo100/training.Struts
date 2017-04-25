/**
 * 
 */
package org.iita.trainingunit.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class SubProgram extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 178145405878054331L;
	private String name;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param trainee the trainee to set
	 */
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	/**
	 * @return the trainee
	 */
	@ManyToOne(cascade = {})
	public Trainee getTrainee() {
		return trainee;
	}
	
	/**
	 * @param trainingProgram the trainingProgram to set
	 */
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}
	/**
	 * @return the trainingProgram
	 */
	@ManyToOne(cascade = {})
	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}
}
