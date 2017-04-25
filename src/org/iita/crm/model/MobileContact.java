package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * Mobile contact
 */
@Entity
@Indexed
public class MobileContact extends Contact {
	
	/** The Constant MOBILE. */
	private static final String MOBILE = "Mobile: ";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5326404661759319285L;
	
	/** The mobile number. */
	private String mobileNumber;

	/**
	 * Gets the mobile number.
	 * 
	 * @return the mobile number
	 */
	@Column(length = 255)
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the mobile number.
	 * 
	 * @param mobileNumber the new mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
		return MOBILE + this.mobileNumber;
	}
}
