/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class OtherDegreesObtained extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1877379594063773977L;
	private Long id;
	private String nameOfInstitution;
	private String majorFieldOfStudy;
	private String certificateObtained;
	
	private int startMonthOfCertification;
	private int startYearOfCertification;
	
	private int stopMonthOfCertification;	
	private int stopYearOfCertification;
	
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
	
	public void setStartMonthOfCertification(int startMonthOfCertification) {
		this.startMonthOfCertification = startMonthOfCertification;
	}
	
	//@Column(length = 500)
	//@Temporal(TemporalType.DATE)
	public int getStartMonthOfCertification() {
		return startMonthOfCertification;
	}
	
	public void setStopMonthOfCertification(int stopMonthOfCertification) {
		this.stopMonthOfCertification = stopMonthOfCertification;
	}
	
	//@Column(length = 500)
	//@Temporal(TemporalType.DATE)
	public int getStopMonthOfCertification() {
		return stopMonthOfCertification;
	}
	
	public void setStartYearOfCertification(int startYearOfCertification) {
		this.startYearOfCertification = startYearOfCertification;
	}
	
	//@Column(length = 500)
	//@Temporal(TemporalType.DATE)
	public int getStartYearOfCertification() {
		return startYearOfCertification;
	}
	
	public void setStopYearOfCertification(int stopYearOfCertification) {
		this.stopYearOfCertification = stopYearOfCertification;
	}
	
	//@Column(length = 500)
	//@Temporal(TemporalType.DATE)
	public int getStopYearOfCertification() {
		return stopYearOfCertification;
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
