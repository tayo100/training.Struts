package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class MajorDuties extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1209824965396292172L;
	private String duties;
	private String responsibilities;
	private NonDegreeTraining nonDegree;

	public void setDuties(String duties) {
		this.duties = duties;
	}

	@Column(length=255)
	public String getDuties() {
		return duties;
	}
	
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	@Column(length=400)
	public String getResponsibilities() {
		return responsibilities;
	}
	
	public void setNonDegree(NonDegreeTraining nonDegree) {
		this.nonDegree = nonDegree;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public NonDegreeTraining getNonDegree() {
		return nonDegree;
	}
}