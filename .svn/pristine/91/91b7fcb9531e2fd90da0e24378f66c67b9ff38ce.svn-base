package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class EducationAndTraining extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1877379594063773977L;
	private Long id;
	private String nameOfInstitution;
	private String country;
	private String majorFieldOfStudy;
	private String certificateObtained;
	
	private String startMonthYearOfCertification;
	
	private String stopMonthYearOfCertification;	
		
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
	 * Get the parent biodata record
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