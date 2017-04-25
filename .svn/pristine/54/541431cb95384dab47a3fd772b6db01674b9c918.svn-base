/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class SupportType extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sponsorName;
	private String sponsorAddress;
	private boolean signed = false;
	private String typeOfSupport;
	private String fundingSource;
	
	private Application application;

	public enum SUPPORTTYPE {
		FULLSCHOLARSHIP, RESEARCHANDLIVINGSHOTS, RESEARCHCOSTONLY, NONE
	}
	
	public enum FUNDINGSOURCE {
		Employer, Donor, Self, Joint, IITACore, IITAProject
	}
	
	/**
	 * @param sponsorName the sponsorName to set
	 */
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	/**
	 * @return the sponsorName
	 */
	public String getSponsorName() {
		return sponsorName;
	}

	/**
	 * @param sponsorAddress the sponsorAddress to set
	 */
	public void setSponsorAddress(String sponsorAddress) {
		this.sponsorAddress = sponsorAddress;
	}

	/**
	 * @return the sponsorAddress
	 */
	public String getSponsorAddress() {
		return sponsorAddress;
	}

	/**
	 * @param signed the signed to set
	 */
	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	/**
	 * @return the signed
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * @return the typeOfSupport
	 */
	@Column(length = 255)
	public String getTypeOfSupport() {
		return typeOfSupport;
	}
	
	public void setTypeOfSupport(String typeOfSupport) {
		this.typeOfSupport = typeOfSupport;
	}
	
	public void setFundingSource(String fundingSource) {
		this.fundingSource = fundingSource;
	}
	
	/**
	 * @return the fundingSource
	 */
	@Column(length = 255)
	public String getFundingSource() {
		return fundingSource;
	}
	
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
}
