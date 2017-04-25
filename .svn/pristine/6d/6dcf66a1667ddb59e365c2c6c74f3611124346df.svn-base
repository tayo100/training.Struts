package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class InternshipEducationAndExperience extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1877379594063773977L;

	private String nameOfInstitution;
	private String country;
	private String majorFieldOfStudy;
	private String certificateObtained;
	
	private String startMonthYearOfCertification;
	
	private String stopMonthYearOfCertification;	
		
	private InternshipTraining application;
	
	public void setNameOfInstitution(String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
	}
	
	@Column(length = 500)
	public String getNameOfInstitution() {
		return nameOfInstitution;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setMajorFieldOfStudy(String majorFieldOfStudy) {
		this.majorFieldOfStudy = majorFieldOfStudy;
	}
	
	@Column(length = 500)
	public String getMajorFieldOfStudy() {
		return majorFieldOfStudy;
	}
	
	public void setCertificateObtained(String certificateObtained) {
		this.certificateObtained = certificateObtained;
	}
	
	@Column(length = 500)
	public String getCertificateObtained() {
		return certificateObtained;
	}
	
	public void setStartMonthYearOfCertification(String startMonthYearOfCertification) {
		this.startMonthYearOfCertification = startMonthYearOfCertification;
	}
	
	//@Column(length = 500)
	//@Temporal(TemporalType.DATE)
	public String getStartMonthYearOfCertification() {
		return startMonthYearOfCertification;
	}
	
	public void setStopMonthYearOfCertification(String stopMonthYearOfCertification) {
		this.stopMonthYearOfCertification = stopMonthYearOfCertification;
	}
	
	//@Column(length = 500)
	//@Temporal(TemporalType.DATE)
	public String getStopMonthYearOfCertification() {
		return stopMonthYearOfCertification;
	}
	
	/**
	 * @return the application
	 */
	@ManyToOne(cascade = {}, optional = false)
	public InternshipTraining getApplication() {
		return this.application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(InternshipTraining application) {
		this.application = application;
	}
}