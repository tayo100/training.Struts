package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * Email contact
 */
@Entity
@Indexed
public class EmailContact extends Contact {

	/** The Constant E_MAIL. */
	private static final String E_MAIL = "E-mail: ";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8505536733367841859L;

	/** The email. */
	private String email;

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	@Column(length = 200, nullable = false)
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email. The value needs to be valid RFC822 email address
	 * 
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
		return E_MAIL + this.email;
	}
}
