package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;

@Entity
@Indexed
public class NonDegreeTraining extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7584632841646965072L;
	
	private List<MajorConstraints> constraints = new ArrayList<MajorConstraints>();
	private List<SpecificSkills> listSkills = new ArrayList<SpecificSkills>();
	private List<MajorDuties> majorDuties = new ArrayList<MajorDuties>();
	private PreviousIITATrainings previousTrainings;
	private String trainingReceived;
	private String proposedTrainingDuration;
	private String trainingLocation;
	
	private Affirmation affirmation;
	private List<ApplicationTag> tags;
	
	public enum PreviousIITATrainings {YES, NO};
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nonDegree")
	public List<MajorConstraints> getConstraints() {
		return this.constraints;
	}
	
	public void setConstraints(List<MajorConstraints> constraints) {
		this.constraints = constraints;
	}

	public void setListSkills(List<SpecificSkills> listSkills) {
		this.listSkills = listSkills;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nonDegree")
	public List<SpecificSkills> getListSkills() {
		return this.listSkills;
	}
	
	public void setTrainingReceived(String trainingReceived) {
		this.trainingReceived = trainingReceived;
	}

	public void setProposedTrainingDuration(String proposedTrainingDuration) {
		this.proposedTrainingDuration = proposedTrainingDuration;
	}

	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}

	@Column(length = 400)
	public String getTrainingReceived() {
		return this.trainingReceived;
	}

	public void setMajorDuties(List<MajorDuties> majorDuties) {
		this.majorDuties = majorDuties;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nonDegree")
	public List<MajorDuties> getMajorDuties() {
		return this.majorDuties;
	}
	
	public String getProposedTrainingDuration() {
		return this.proposedTrainingDuration;
	}

	public String getTrainingLocation() {
		return this.trainingLocation;
	}

	public void setPreviousTrainings(PreviousIITATrainings previousTrainings) {
		this.previousTrainings = previousTrainings;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 5)
	public PreviousIITATrainings getPreviousTrainings() {
		return previousTrainings;
	}
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "nonDegree")
	public Affirmation getAffirmation() {
		return affirmation;
	}

	public void setAffirmation(Affirmation affirmation) {
		this.affirmation = affirmation;
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