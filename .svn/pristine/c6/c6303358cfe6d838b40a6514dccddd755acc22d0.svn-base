package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * Address contact.
 * 
 * @author mobreza
 */
@Entity
@Indexed
public class AddressContact extends Contact implements GeoCoded {

	/** The Constant ADDRESS. */
	private static final String ADDRESS = "Address: ";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3936408588254725939L;

	/** The attn. */
	private String attn;

	/** The address. */
	private String address;

	/** The city. */
	private String city;

	/** The state. */
	private String state;

	/** The country. */
	private String country;

	private Double latitude;
	private Double longitude;
	private String continent;
	private String postalAddress;

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	@Column(length = 250)
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the attn.
	 * 
	 * @return the attn
	 */
	@Column(length = 50)
	public String getAttn() {
		return attn;
	}

	/**
	 * Sets the attn.
	 * 
	 * @param attn the new attn
	 */
	public void setAttn(String attn) {
		this.attn = attn;
	}

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	@Column(length = 50)
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 * 
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	@Column(length = 50)
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	@Column(length = 50)
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @see org.iita.crm.model.GeoCoded#getLatitude()
	 */
	public Double getLatitude() {
		return this.latitude;
	}

	/**
	 * @see org.iita.crm.model.GeoCoded#setLatitude(java.lang.Double)
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @see org.iita.crm.model.GeoCoded#getLongitude()
	 */
	public Double getLongitude() {
		return this.longitude;
	}

	/**
	 * @see org.iita.crm.model.GeoCoded#setLongitude(java.lang.Double)
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Gets the continent.
	 * 
	 * @return the continent
	 */
	@Column(length = 50)
	public String getContinent() {
		return continent;
	}

	/**
	 * Sets the continent.
	 * 
	 * @param continent the new continent
	 */
	public void setContinent(String continent) {
		this.continent = continent;
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
		return ADDRESS + this.attn + " " + this.address + " " + this.city + " " + this.state + " " + this.country;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	@Column(length = 255)
	public String getPostalAddress() {
		return postalAddress;
	}
}
