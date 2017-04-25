package org.iita.trainingunit.model;

import java.util.Date;

import org.iita.crm.model.Person;
import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;

public class CFAApplications extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5524413855017064320L;
	private User user;
	private CallForApplication callForApplication;
	private Person person;
	private Date dateSubmitted;
	private String additionalNotes;
	
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param callForApplication the callForApplication to set
	 */
	public void setCallForApplication(CallForApplication callForApplication) {
		this.callForApplication = callForApplication;
	}
	/**
	 * @return the callForApplication
	 */
	public CallForApplication getCallForApplication() {
		return callForApplication;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param dateSubmitted the dateSubmitted to set
	 */
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	/**
	 * @return the dateSubmitted
	 */
	public Date getDateSubmitted() {
		return dateSubmitted;
	}
	/**
	 * @param additionalNotes the additionalNotes to set
	 */
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	/**
	 * @return the additionalNotes
	 */
	public String getAdditionalNotes() {
		return additionalNotes;
	}

}
