package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

@Entity
public class ApplicantsChildren extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5665321325473880644L;
	private Long id;
	private String childName;
	private Date dateOfBirth;
	private ApplicantsBioData biodata;
	
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
	
	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	@Column(length = 500)
	public String getChildName() {
		return this.childName;
	}
	
	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	/**
	 * Get the parent ApplicantsBioData record
	 * 
	 * @see biodata
	 * @return the biodata
	 */
	@ManyToOne(cascade = {}, optional = false)
	public ApplicantsBioData getBiodata() {
		return this.biodata;
	}

	public void setBiodata(ApplicantsBioData biodata) {
		this.biodata = biodata;
	}
}