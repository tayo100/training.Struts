package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.announcements.model.Announcement;

@Entity
public class ApplicationStarter extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	ApplicantsBioData biodata;
	Announcement announcement;
	STATUS status = STATUS.INPROGRESS;
	private String appKey;
	private String email;
	private String trainingOption;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}
	
	/**
	 * @param id the id destination set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public enum STATUS{INPROGRESS, COMPLETED}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public STATUS getStatus() {
		return status;
	}
	
	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	@OneToOne(cascade = {}, optional = false)
	public ApplicantsBioData getBiodata() {
		return biodata;
	}
	
	public void setBiodata(ApplicantsBioData biodata) {
		this.biodata = biodata;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Announcement getAnnouncement() {
		return announcement;
	}
	
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	@Column(length = 15)
	public String getAppKey() {
		return appKey;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 100)
	public String getEmail() {
		return email;
	}
	
	public void setTrainingOption(String trainingOption) {
		this.trainingOption = trainingOption;
	}

	@Column(length = 100)
	public String getTrainingOption() {
		return trainingOption;
	}
}
