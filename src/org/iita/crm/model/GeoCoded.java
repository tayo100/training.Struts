/**
 * promisCRM.Struts Apr 18, 2010
 */
package org.iita.crm.model;

/**
 * Interface to declare classes that provide geo-coding information
 * 
 * @author mobreza
 */
public interface GeoCoded {

	/**
	 * @return the latitude
	 */
	public abstract Double getLatitude();

	/**
	 * @param latitude the latitude to set
	 */
	public abstract void setLatitude(Double latitude);

	/**
	 * @return the longitude
	 */
	public abstract Double getLongitude();

	/**
	 * @param longitude the longitude to set
	 */
	public abstract void setLongitude(Double longitude);

}