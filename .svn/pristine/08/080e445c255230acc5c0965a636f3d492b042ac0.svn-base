package org.iita.trainingunit.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.applications.model.InternalApprovals;

/**
 * @author ken
 *
 */
@Entity
public class Hub extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3753203198147025257L;
	private String name;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	private InternalApprovals internalApproval;
	
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
	
	/**
	 * @param internalApproval the internalApproval to set
	 */
	public void setInternalApproval(InternalApprovals internalApproval) {
		this.internalApproval = internalApproval;
	}
	/**
	 * @return the internalApproval
	 */
	@ManyToOne(cascade = {})
	public InternalApprovals getInternalApproval() {
		return internalApproval;
	}
	
}
