/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

/**
 * {@link Partner}s can be linked to {@link partnerCategorie}s. This class holds the category information.
 * 
 * @author KOraegbunam
 */
@Entity
public class PartnerIITAHub extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 770865809545775053L;

	/** The partner. */
	private Partner partner;

	/** The type. */
	private IITAHub hub;


	/**
	 * Gets the partner.
	 * 
	 * @return the partner
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Partner getPartner() {
		return this.partner;
	}

	/**
	 * Sets the partner.
	 * 
	 * @param partner the partner to set
	 */
	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public enum IITAHub {
		WESTERNAFRICA, EASTERNAFRICA, CENTRALAFRICA, SOUTHERNAFRICA, UNSPECIFIED
	}
	
	/**
	 * @return the hub
	 */
	@Enumerated(EnumType.STRING)
	public IITAHub gethub() {
		return this.hub;
	}

	/**
	 * @param hub the type to set
	 */
	public void setHub(IITAHub hub) {
		this.hub = hub;
	}
}
