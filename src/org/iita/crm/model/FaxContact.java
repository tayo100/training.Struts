package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * Phone contact
 */
@Entity
@Indexed
public class FaxContact extends Contact {
	
	/** The Constant FAX. */
	private static final String FAX = "Fax: ";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5326404661759319285L;
	
	/** The phone number. */
	private String faxNumber;

	/**
	 * Gets the fax number.
	 * 
	 * @return the fax number
	 */
	@Column(length = 255)
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Sets the fax number.
	 * 
	 * @param faxNumber the new fax number
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	/**
	 * To string.
	 * 
	 * @return the string
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return FAX + this.faxNumber;
	}
}
