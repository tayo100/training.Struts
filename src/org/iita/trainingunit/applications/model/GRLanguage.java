package org.iita.trainingunit.applications.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

@Entity
public class GRLanguage extends VersionedEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2993784384718659082L;
	private String languageName;
	private LanguageOptions languageOptions;
	private GraduateResearchTraining graduateResearchTraining;
	
	public enum LanguageOptions {NIL, AVERAGE, GOOD, EXCELLENT};
	
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageOptions(LanguageOptions languageOptions) {
		this.languageOptions = languageOptions;
	}
	public LanguageOptions getLanguageOptions() {
		return languageOptions;
	};
	
	public void setGraduateResearchTraining(GraduateResearchTraining graduateResearchTraining) {
		this.graduateResearchTraining = graduateResearchTraining;
	}
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	public GraduateResearchTraining getGraduateResearchTraining() {
		return graduateResearchTraining;
	}
}