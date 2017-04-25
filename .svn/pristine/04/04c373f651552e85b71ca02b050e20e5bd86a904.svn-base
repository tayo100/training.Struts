/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class SabbaticalProjectSummary extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Application application;
	private String theme;
	private String summary;
	private int howLong;
	private String startProject;
	private String previousCollaboration;
	private String location;
	private String iitaContacts;
	private String iitaContactEmail;
	
	
	/**
	 * Get the parent application record
	 * 
	 * @see application
	 * @return the application
	 */
	@OneToOne(cascade = {}, optional = false)
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the theme
	 */
	@Column(length = 400)
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the summary
	 */
	@Lob
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the howLong
	 */
	public int getHowLong() {
		return howLong;
	}

	/**
	 * @param howLong the howLong to set
	 */
	public void setHowLong(int howLong) {
		this.howLong = howLong;
	}

	/**
	 * @return the startProject
	 */
	@Column(length = 400)
	public String getStartProject() {
		return startProject;
	}

	/**
	 * @param startProject the startProject to set
	 */
	public void setStartProject(String startProject) {
		this.startProject = startProject;
	}

	/**
	 * @return the previousCollaboration
	 */
	@Column(length = 400)
	public String getPreviousCollaboration() {
		return previousCollaboration;
	}

	/**
	 * @param previousCollaboration the previousCollaboration to set
	 */
	public void setPreviousCollaboration(String previousCollaboration) {
		this.previousCollaboration = previousCollaboration;
	}

	/**
	 * @return the location
	 */
	@Column(length = 400)
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the iitaContacts
	 */
	@Column(length = 400)
	public String getIitaContacts() {
		return iitaContacts;
	}

	/**
	 * @param iitaContacts the iitaContacts to set
	 */
	public void setIitaContacts(String iitaContacts) {
		this.iitaContacts = iitaContacts;
	}

	/**
	 * @return the iitaContactEmail
	 */
	public String getIitaContactEmail() {
		return iitaContactEmail;
	}

	/**
	 * @param iitaContactEmail the iitaContactEmail to set
	 */
	public void setIitaContactEmail(String iitaContactEmail) {
		this.iitaContactEmail = iitaContactEmail;
	}

}
