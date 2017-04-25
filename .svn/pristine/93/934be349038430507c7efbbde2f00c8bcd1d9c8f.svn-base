package org.iita.trainingunit.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.Person;
import org.iita.entity.VersionedEntity;

@Entity
@Indexed
public class Alumni extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1836423327047389395L;
	private Person person;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	private String supervisor;
	private String sponsor;
	private String costCenter;
	private String department;
	
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the person
	 */
	@OneToOne(cascade = {}, optional = true)
	public Person getPerson() {
		return person;
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
	/**
	 * @return the person
	 */
	@OneToOne(cascade = {}, optional = true)
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
	/**
	 * @return the person
	 */
	@OneToOne(cascade = {}, optional = true)
	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}
	
	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}
	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	/**
	 * @return the sponsor
	 */
	public String getSponsor() {
		return sponsor;
	}
	/**
	 * @param costCenter the costCenter to set
	 */
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	/**
	 * @return the costCenter
	 */
	public String getCostCenter() {
		return costCenter;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
}
