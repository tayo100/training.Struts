package org.iita.trainingunit.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.iita.crm.model.Organization;
import org.iita.entity.VersionedEntity;

/**
 * Trainee and Group training funding record. A trainee or group training may be funded by several {@link Organization}s
 */
@Entity
public class Funding extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9027520926541175055L;

	/** The sponsor type. */
	private SponsorType sponsorType;

	/** The organization. */
	private Organization organization;

	/** The cost center. */
	private String costCenter;
	
	/** Estimated cost */
	private Double estimatedCost;
	
	/**
	 * The Enum SponsorType.
	 */
	public enum SponsorType {
		/** Core sponsored */
		CORE,
		/** Project sponsored */
		SPECIALPROJECT,
		/** Self sponsored */
		SELF,
		/** Other */
		OTHER,
		/** Donor sponsored */
		DONOR
	}

	/**
	 * Sets the sponsor type.
	 * 
	 * @param sponsorType the sponsor type
	 */
	public void setSponsorType(SponsorType sponsorType) {
		this.sponsorType = sponsorType;
	}

	/**
	 * Gets the sponsor type.
	 * 
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	public SponsorType getSponsorType() {
		return sponsorType;
	}

	/**
	 * Sets the organization.
	 * 
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * Gets the organization.
	 * 
	 * @return the organization
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * Sets the cost center.
	 * 
	 * @param costCenter the costCenter to set
	 */
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	/**
	 * Gets the cost center.
	 * 
	 * @return the costCenter
	 */
	public String getCostCenter() {
		return costCenter;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Double getEstimatedCost() {
		return estimatedCost;
	}
}
