package org.iita.trainingunit.iya.model;

import javax.persistence.Entity;
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
	@OneToOne(cascade = {}, optional = false)
	public IYATrainingAnnouncement getIyaTrainingAnnouncement() {
		return iyaTrainingAnnouncement;
	}
	
	
}