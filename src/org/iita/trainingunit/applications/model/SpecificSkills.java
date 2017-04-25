package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class SpecificSkills extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1209824965396292172L;
	private String acquireSkills;
	private NonDegreeTraining nonDegree;

	public void setAcquireSkills(String acquireSkills) {
		this.acquireSkills = acquireSkills;
	}

	public String getAcquireSkills() {
		return acquireSkills;
	}
	
	public void setNonDegree(NonDegreeTraining nonDegree) {
		this.nonDegree = nonDegree;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public NonDegreeTraining getNonDegree() {
		return nonDegree;
	}
}