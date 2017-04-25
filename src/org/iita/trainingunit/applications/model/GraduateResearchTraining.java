package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;


@Entity
@Indexed
public class GraduateResearchTraining extends Application {
	
	private ProjectSummary projectSummaries;
	private TimeSchedule timeSchedules;
	private List<Milestone> milestones = new ArrayList<Milestone>();
	private SupportType supportTypes;
	private List<ApplicationTag> tags;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5981417998275512404L;
	/**
	 * 
	 */
	public GraduateResearchTraining() {

	}

	/**
	 * Copy constructor
	 * 
	 * @param GraduateResearchTraining
	 */
	public GraduateResearchTraining(Application application) {
		super(application);
	}

	//public void setProjectSummary(ProjectSummary projectSummaries) {
	//	this.projectSummaries = projectSummaries;
	//}
	
	/**
	 * List of education and training on this biodata
	 * 
	 * @return
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "application")
	public ProjectSummary getProjectSummaries() {
		return projectSummaries;
	}
	
	public void setTimeSchedules(TimeSchedule timeSchedules) {
		this.timeSchedules = timeSchedules;
	}
	
	/**
	 * List of timeschedule on this application
	 * 
	 * @return
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "application")
	public TimeSchedule getTimeSchedules() {
		return timeSchedules;
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
	 * @param projectSummaries the projectSummaries to set
	 */
	public void setProjectSummaries(ProjectSummary projectSummaries) {
		this.projectSummaries = projectSummaries;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}
	
	/**
	 * List of education and training on this application
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public List<Milestone> getMilestones() {
		return milestones;
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
	public boolean hasAccess(User user) {
		// TODO Auto-generated method stub
		return false;
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