package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * Phone contact
 */
@Entity
@Indexed
public class PhoneContact extends Contact {
	
	/** The Constant PHONE. */
	private static final String PHONE = "Phone: ";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5326404661759319285L;
	
	/** The phone number. */
	private String phoneNumber;

	/**
	 * Gets the phone number.
	 * 
	 * @return the phone number
	 */
	@Column(length = 255)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 * 
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		return PHONE + this.phoneNumber;
	}
}
