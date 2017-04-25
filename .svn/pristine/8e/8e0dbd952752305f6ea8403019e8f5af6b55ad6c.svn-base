package org.iita.trainingunit.applications.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.lucene.SabbaticalBridge;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;

@Entity
@Indexed
@ClassBridge(impl = SabbaticalBridge.class)
public class SabbaticalTraining extends Application {
	private static final long serialVersionUID = 7858052793249329131L;

	private String activityType;
	private String specifyOther;
	private List<ApplicationTag> tags;
	private SabbaticalProjectSummary sabProjectSummaries;
	private SupportType supportTypes;
	private AdministrativeExperience adminExperiences;
	
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	/**
	 * @return the activityType
	 */
	@Column(length = 20)
	public String getActivityType() {
		return activityType;
	}

	/**
	 * @param specifyOther the specifyOther to set
	 */
	public void setSpecifyOther(String specifyOther) {
		this.specifyOther = specifyOther;
	}

	/**
	 * @return the specifyOther
	 */

	@Column(length = 255)
	public String getSpecifyOther() {
		return specifyOther;
	}

	public void setSabProjectSummaries(SabbaticalProjectSummary sabProjectSummaries) {
		this.sabProjectSummaries = sabProjectSummaries;
	}
	
	/**
	 * List of education and training on this biodata
	 * 
	 * @return
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "application")
	public SabbaticalProjectSummary getSabProjectSummaries() {
		return sabProjectSummaries;
	}
	
	public void setAdminExperiences(AdministrativeExperience adminExperiences) {
		this.adminExperiences = adminExperiences;
	}
	
	/**
	 * List of education and training on this biodata
	 * 
	 * @return
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "application")
	public AdministrativeExperience getAdminExperiences() {
		return adminExperiences;
	}
	
	/**
	 * @return the supportTypes
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "application")
	public SupportType getSupportTypes() {
		return supportTypes;
	}

	/**
	 * @param supportTypes the supportTypes to set
	 */
	public void setSupportTypes(SupportType supportTypes) {
		this.supportTypes = supportTypes;
	}
	
	/**
	 * @see org.iita.cdo.model.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {		
		if(super.getStatus()==APPLICATIONSTATUS.APPROVED)
			return true;
		
		if (super.getBiodata().getId().equals(user.getId())) {
			return true;
		}
		return false;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<ApplicationTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<ApplicationTag> tags) {
		this.tags = tags;
	}

	@Override
	@Transient
	public Class<? extends EntityTag<Application>> getTagClass() {
		return ApplicationTag.class;
	}

	@Override
	public EntityTag<Application> createTag() {
		return new ApplicationTag();
	}
}