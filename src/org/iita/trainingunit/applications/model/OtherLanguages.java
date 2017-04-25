package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class OtherLanguages extends VersionedEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8670870474165653346L;

	private String otherLanguage;
	private LANGUAGEREAD languageRead;
	private LANGUAGEWRITE languageWrite;
	private LANGUAGESPEAK languageSpeak;
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
	
	public void setOtherLanguage(String otherLanguage) {
		this.otherLanguage = otherLanguage;
	}

	@Column(length = 255)
	public String getOtherLanguage() {
		return otherLanguage;
	}
	
	/**
	 * @return the languageRead
	 */
	@Enumerated(EnumType.STRING)
	public LANGUAGEREAD getLanguageRead() {
		return languageRead;
	}

	/**
	 * @param languageRead the languageRead to set
	 */
	public void setLanguageRead(LANGUAGEREAD languageRead) {
		this.languageRead = languageRead;
	}

	/**
	 * @return the languageWrite
	 */
	@Enumerated(EnumType.STRING)
	public LANGUAGEWRITE getLanguageWrite() {
		return languageWrite;
	}

	/**
	 * @param languageWrite the languageWrite to set
	 */
	public void setLanguageWrite(LANGUAGEWRITE languageWrite) {
		this.languageWrite = languageWrite;
	}

	/**
	 * @return the languageSpeak
	 */
	@Enumerated(EnumType.STRING)
	public LANGUAGESPEAK getLanguageSpeak() {
		return languageSpeak;
	}

	/**
	 * @param languageSpeak the languageSpeak to set
	 */
	public void setLanguageSpeak(LANGUAGESPEAK languageSpeak) {
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