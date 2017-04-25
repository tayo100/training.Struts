package org.iita.trainingunit.iya.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.model.Trainer;


/**
 * 
 * @author ooluloko
 */
@Entity
public class IYATrainingAnnouncement extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sponsor;
	
	private String organizer;
	

	private String trainingCourse;
	
	private List<IYAAnnouncementObjective> trainingObjectives;	
	private List<TrainingLocation> trainingLocations;
	private List<Trainer> facilitators;
	private IYARegistration registration;
	
	
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	public String getTrainingCourse() {
		return trainingCourse;
	}
	public void setTrainingCourse(String trainingCourse) {
		this.trainingCourse = trainingCourse;
	}
	
	@OneToMany(cascade = {}, mappedBy = "iyaTrainingAnnouncement")
	public List<Trainer> getFacilitators() {
		return facilitators;
	}
	public void setFacilitators(List<Trainer> facilitators) {
		this.facilitators = facilitators;
	}

	public void setTrainingObjectives(List<IYAAnnouncementObjective> trainingObjectives) {
		this.trainingObjectives = trainingObjectives;
	}
	
	@OneToMany(cascade = {}, mappedBy = "iyaTrainingAnnouncement")
	public List<IYAAnnouncementObjective> getTrainingObjectives() {
		return trainingObjectives;
	}
	
	@OneToMany(cascade = {}, mappedBy = "iyaTrainingAnnouncement")
	public List<TrainingLocation> getTrainingLocations() {
		return trainingLocations;
	}
	
	public void setTrainingLocations(List<TrainingLocation> trainingLocations) {
		this.trainingLocations = trainingLocations;
	}
	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(IYARegistration registration) {
		this.registration = registration;
	}
	/**
	 * @return the registration
	 */
	@OneToOne(cascade = {}, mappedBy = "iyaTrainingAnnouncement")
	public IYARegistration getRegistration() {
		return registration;
	}
	
}
