/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainingLocation;

/**
 * @author ken
 *
 */
@Entity
@Indexed
public class GroupTraining extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6641767037785983344L;
	private List<ApplicationTag> tags;
	private List<TrainingLocation> locations = new ArrayList<TrainingLocation>();
	private String trainingTopic;
	private String trainingGroup;
	private String projectName;
	private String objectives;
	private String resources;
	private String outputs;
	
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
	
	public void setLocations(List<TrainingLocation> locations) {
		this.locations = locations;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public List<TrainingLocation> getLocations() {
		return locations;
	}

	/**
	 * @return the trainingTopic
	 */
	@Column(length=400)
	public String getTrainingTopic() {
		return trainingTopic;
	}

	/**
	 * @param trainingTopic the trainingTopic to set
	 */
	public void setTrainingTopic(String trainingTopic) {
		this.trainingTopic = trainingTopic;
	}

	/**
	 * @return the trainingGroup
	 */
	@Column(length=400)
	public String getTrainingGroup() {
		return trainingGroup;
	}

	/**
	 * @param trainingGroup the trainingGroup to set
	 */
	public void setTrainingGroup(String trainingGroup) {
		this.trainingGroup = trainingGroup;
	}

	/**
	 * @return the projectName
	 */
	@Column(length=255)
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the objectives
	 */
	@Lob
	public String getObjectives() {
		return objectives;
	}

	/**
	 * @param objectives the objectives to set
	 */
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	/**
	 * @return the resources
	 */
	@Lob
	public String getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}

	/**
	 * @return the outputs
	 */
	@Lob
	public String getOutputs() {
		return outputs;
	}

	/**
	 * @param outputs the outputs to set
	 */
	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}
}
