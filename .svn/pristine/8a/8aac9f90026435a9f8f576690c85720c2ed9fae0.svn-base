/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class ProjectSummary extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String summary;
	private String priorityLink;
	private String keywords;
	private String researchPlan;
	private String researchExperience;
	private String scientificKnowledge;
	private String literature;
	private String expectedOutcomes;
	private String dataProduced;
	private String publicationPlan;
	private Application application;
	
	/**
	 * @return the title
	 */
	@Column(length = 255)
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the summary
	 */
	@Column(length = 400)
	public String getSummary() {
		return summary;
	}
	
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	/**
	 * @return the priorityLink
	 */
	@Column(length = 255)
	public String getPriorityLink() {
		return priorityLink;
	}
	
	/**
	 * @param priorityLink the priorityLink to set
	 */
	public void setPriorityLink(String priorityLink) {
		this.priorityLink = priorityLink;
	}
	
	/**
	 * @return the keywords
	 */
	@Column(length = 100)
	public String getKeywords() {
		return keywords;
	}
	
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * @return the researchPlan
	 */
	@Lob
	public String getResearchPlan() {
		return researchPlan;
	}
	
	/**
	 * @param researchPlan the researchPlan to set
	 */
	public void setResearchPlan(String researchPlan) {
		this.researchPlan = researchPlan;
	}
	
	/**
	 * @return the researchExperience
	 */
	@Lob
	public String getResearchExperience() {
		return researchExperience;
	}
	
	/**
	 * @param researchExperience the researchExperience to set
	 */
	public void setResearchExperience(String researchExperience) {
		this.researchExperience = researchExperience;
	}
	
	/**
	 * @return the scientificKnowledge
	 */
	@Lob
	public String getScientificKnowledge() {
		return scientificKnowledge;
	}
	
	/**
	 * @param scientificKnowledge the scientificKnowledge to set
	 */
	public void setScientificKnowledge(String scientificKnowledge) {
		this.scientificKnowledge = scientificKnowledge;
	}
	
	/**
	 * @return the literature
	 */
	@Lob
	public String getLiterature() {
		return literature;
	}
	
	/**
	 * @param literature the literature to set
	 */
	public void setLiterature(String literature) {
		this.literature = literature;
	}
	
	/**
	 * @return the expectedOutcomes
	 */
	@Lob
	public String getExpectedOutcomes() {
		return expectedOutcomes;
	}
	
	/**
	 * @param expectedOutcomes the expectedOutcomes to set
	 */
	public void setExpectedOutcomes(String expectedOutcomes) {
		this.expectedOutcomes = expectedOutcomes;
	}
	
	/**
	 * @return the dataProduced
	 */
	@Lob
	public String getDataProduced() {
		return dataProduced;
	}
	
	/**
	 * @param dataProduced the dataProduced to set
	 */
	public void setDataProduced(String dataProduced) {
		this.dataProduced = dataProduced;
	}
	
	/**
	 * @return the publicationPlan
	 */
	@Lob
	public String getPublicationPlan() {
		return publicationPlan;
	}
	
	/**
	 * @param publicationPlan the publicationPlan to set
	 */
	public void setPublicationPlan(String publicationPlan) {
		this.publicationPlan = publicationPlan;
	}
	
	/**
	 * Get the parent application record
	 * 
	 * @see application
	 * @return the application
	 */
	@OneToOne(cascade = {}, optional = true)
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
}
