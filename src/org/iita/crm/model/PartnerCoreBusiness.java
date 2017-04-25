/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;
import org.iita.util.StringUtil;

/**
 * {@link Partner}s can be linked to {@link partnerCategorie}s. This class holds the category information.
 * 
 * @author KOraegbunam
 */
@Entity
public class PartnerCoreBusiness extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 770865809545775053L;

	/** The partner. */
	private Partner partner;

	/** The type. */
	private String type;


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


	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	@Column(length = 200)
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = StringUtil.nullOrString(type);
	}
}
