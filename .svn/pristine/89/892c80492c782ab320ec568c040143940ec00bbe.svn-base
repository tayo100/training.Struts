/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;


/**
 * @author ken
 *
 */
@Entity
public class LanguageSpoken extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5990555823501626173L;
	
	
	private String language;
	private String languageRead;
	private String languageWrite;
	private String languageSpeak;
	private ApplicantsBioData biodata;
	

	public enum LANGUAGE {
		English, French, Portuguese, Others
	}
	
	public enum LANGUAGEREAD {
		Easily, NotEasily
	}
	
	public enum LANGUAGEWRITE {
		Easily, NotEasily
	}
	
	public enum LANGUAGESPEAK {
		Easily, NotEasily
	}
	
	
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the language
	 */
	//@Enumerated(EnumType.STRING)
	@Column(length = 25)
	public String getLanguage() {
		return language;
	}
	
	/**
	 * @return the languageRead
	 */
	//@Enumerated(EnumType.STRING)
	public String getLanguageRead() {
		return languageRead;
	}

	/**
	 * @param languageRead the languageRead to set
	 */
	public void setLanguageRead(String languageRead) {
		this.languageRead = languageRead;
	}

	/**
	 * @return the languageWrite
	 */
	//@Enumerated(EnumType.STRING)
	public String getLanguageWrite() {
		return languageWrite;
	}

	/**
	 * @param languageWrite the languageWrite to set
	 */
	public void setLanguageWrite(String languageWrite) {
		this.languageWrite = languageWrite;
	}

	/**
	 * @return the languageSpeak
	 */
	//@Enumerated(EnumType.STRING)
	public String getLanguageSpeak() {
		return languageSpeak;
	}

	/**
	 * @param languageSpeak the languageSpeak to set
	 */
	public void setLanguageSpeak(String languageSpeak) {
		this.languageSpeak = languageSpeak;
	}

	/**
	 * Get the parent biodata record
	 * 
	 * @see biodata
	 * @return the biodata
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public ApplicantsBioData getBiodata() {
		return this.biodata;
	}

	public void setBiodata(ApplicantsBioData biodata) {
		this.biodata = biodata;
	}
}
