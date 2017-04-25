/**
 * 
 */
package org.iita.trainingunit.iya.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
public class Language{

	private String languageCode;
	private String languageDisplay;
	
	//getter and setter methods
	
	public Language(String languageCode, String languageDisplay) {
		this.setLanguageCode(languageCode);
		this.setLanguageDisplay(languageDisplay);
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageDisplay the languageDisplay to set
	 */
	public void setLanguageDisplay(String languageDisplay) {
		this.languageDisplay = languageDisplay;
	}

	/**
	 * @return the languageDisplay
	 */
	public String getLanguageDisplay() {
		return languageDisplay;
	}
}
