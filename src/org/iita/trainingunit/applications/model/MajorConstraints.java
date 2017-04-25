package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class MajorConstraints extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String faced;
	private NonDegreeTraining nonDegree;

	public void setFaced(String faced) {
		this.faced = faced;
	}

	public String getFaced() {
		return faced;
	}
	
	public void setNonDegree(NonDegreeTraining nonDegree) {
		this.nonDegree = nonDegree;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public NonDegreeTraining getNonDegree() {
		return nonDegree;
	}
}