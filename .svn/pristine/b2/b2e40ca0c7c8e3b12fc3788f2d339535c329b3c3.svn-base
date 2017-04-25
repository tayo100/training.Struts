package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

@Entity
public class OtherApplicationDetails extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6869219210546976460L;
	private String nameOfSponsor;
	private String addressofSponsor;
	private Date startDate;


	private Application application;
	//private GraduateResearchTraining graduateResearch;
	//private NonDegreeTraining nonDegree;
	
	
	public void setNameOfSponsor(String nameOfSponsor) {
		this.nameOfSponsor = nameOfSponsor;
	}

	@Column(length = 255)
	public String getNameOfSponsor() {
		return nameOfSponsor;
	}

	public void setAddressofSponsor(String addressofSponsor) {
		this.addressofSponsor = addressofSponsor;
	}

	@Column(length = 500)
	public String getAddressofSponsor() {
		return addressofSponsor;
	}
	
	@OneToOne(optional = true, cascade = {})
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	//@OneToOne(optional = true, cascade = {})
	//public GraduateResearchTraining getGraduateResearch() {
	//	return graduateResearch;
	//}

	//public void setGraduateResearch(GraduateResearchTraining graduateResearch) {
	//	this.graduateResearch = graduateResearch;
	//}
	
	//@OneToOne(optional = true, cascade = {})
	//public NonDegreeTraining getNonDegree() {
	//	return nonDegree;
	//}

	//public void setNonDegree(NonDegreeTraining nonDegree) {
	//	this.nonDegree = nonDegree;
	//}
	
	/**
	 * @return the startDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}