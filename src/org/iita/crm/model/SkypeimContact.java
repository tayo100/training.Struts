package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * @author tayo
 *
 */
@Entity
@Indexed
public class SkypeimContact extends Contact {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1509838553035063046L;
	
	private String skypeimAddress;

	/**
	 * @return the skypeimAddress
	 */
	@Column(length = 45)
	public String getSkypeimAddress() {
		return skypeimAddress;
	}

	/**
	 * @param skypeimAddress the skypeimAddress to set
	 */
	public void setSkypeimAddress(String skypeimAddress) {
		this.skypeimAddress = skypeimAddress;
	}

}
