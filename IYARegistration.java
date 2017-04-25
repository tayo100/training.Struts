package org.iita.trainingunit.iya.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.iita.crm.model.Person;
import org.iita.entity.VersionedEntity;


/**
 * 
 * @author ooluloko/KOraegbunam
 */
@Entity
public class IYARegistration extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
	private IYATrainingAnnouncement iyaTrainingAnnouncement;
	private IYAEvaluation iyaEvaluation;
	
	
	
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the person
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Person getPerson() {
		return person;
	}
	/**
	 * @param iyaTrainingAnnouncement the iyaTrainingAnnouncement to set
	 */
	public void setIyaTrainingAnnouncement(IYATrainingAnnouncement iyaTrainingAnnouncement) {
		this.iyaTrainingAnnouncement = iyaTrainingAnnouncement;
	}
	/**
	 * @return the announcement
	 */
	@ManyToOne(cascade = {}, optional = false)
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
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "iyaRegistration", cascade = CascadeType.ALL)
	public IYAEvaluation getIyaEvaluation() {
		return iyaEvaluation;
	}
}