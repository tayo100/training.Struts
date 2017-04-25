package org.iita.trainingunit.announcements.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.entity.VersionedEntity;

@Entity
@Indexed
@ClassBridge(impl = org.iita.crm.lucene.TrainTheTrainerBridge.class)
public class TrainTheTrainer extends VersionedEntity {
	private static final long serialVersionUID = 894103699487157361L;
	private String requestor;
	private String unit;
	private String programDirector;
	private String projectInformation;
	private String crp;
	private String trainingTitle;
	private Date startTrainingDate;
	private Date stopTrainingDate;
	private String activity;
	private String duration;
	private String country;
	private String locations;
	private String venue;
	private String costCenter;
	private String trainingBudget;
	private String background;
	private String budgetOfficer;
	private String trainingMaterials;
	private String targetParticipants;
	private String resourcePersons;
	private String trainingObjectives;
	private String expectedTrainingOutcome;
	private Date deadline;

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Lob
	public String getActivity() {
		return activity;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	@Column(length = 255)
	public String getRequestor() {
		return requestor;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(length = 100)
	public String getUnit() {
		return unit;
	}

	public void setProgramDirector(String programDirector) {
		this.programDirector = programDirector;
	}

	@Column(length = 100)
	public String getProgramDirector() {
		return programDirector;
	}

	public void setProjectInformation(String projectInformation) {
		this.projectInformation = projectInformation;
	}

	@Column(length = 250)
	public String getProjectInformation() {
		return projectInformation;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	@Column(length = 255)
	public String getCrp() {
		return crp;
	}

	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}

	@Column(length = 250)
	public String getTrainingTitle() {
		return trainingTitle;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Column(length = 100)
	public String getDuration() {
		return duration;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(length = 100)
	public String getCountry() {
		return country;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	@Column(length = 100)
	public String getLocations() {
		return locations;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Column(length = 100)
	public String getVenue() {
		return venue;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	@Column(length = 100)
	public String getCostCenter() {
		return costCenter;
	}

	public void setTrainingBudget(String trainingBudget) {
		this.trainingBudget = trainingBudget;
	}

	@Column(length = 100)
	public String getTrainingBudget() {
		return trainingBudget;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	@Column(length = 250)
	public String getBackground() {
		return background;
	}

	public void setBudgetOfficer(String budgetOfficer) {
		this.budgetOfficer = budgetOfficer;
	}

	@Column(length = 100)
	public String getBudgetOfficer() {
		return budgetOfficer;
	}

	public void setTrainingMaterials(String trainingMaterials) {
		this.trainingMaterials = trainingMaterials;
	}

	@Column(length = 250)
	public String getTrainingMaterials() {
		return trainingMaterials;
	}

	public void setTargetParticipants(String targetParticipants) {
		this.targetParticipants = targetParticipants;
	}

	@Column(length = 250)
	public String getTargetParticipants() {
		return targetParticipants;
	}

	public void setResourcePersons(String resourcePersons) {
		this.resourcePersons = resourcePersons;
	}

	@Column(length = 250)
	public String getResourcePersons() {
		return resourcePersons;
	}

	public void setTrainingObjectives(String trainingObjectives) {
		this.trainingObjectives = trainingObjectives;
	}

	@Column(length = 250)
	public String getTrainingObjectives() {
		return trainingObjectives;
	}

	public void setExpectedTrainingOutcome(String expectedTrainingOutcome) {
		this.expectedTrainingOutcome = expectedTrainingOutcome;
	}

	@Column(length = 250)
	public String getExpectedTrainingOutcome() {
		return expectedTrainingOutcome;
	}

	public void setStartTrainingDate(Date startTrainingDate) {
		this.startTrainingDate = startTrainingDate;
	}

	public Date getStartTrainingDate() {
		return startTrainingDate;
	}

	public void setStopTrainingDate(Date stopTrainingDate) {
		this.stopTrainingDate = stopTrainingDate;
	}

	public Date getStopTrainingDate() {
		return stopTrainingDate;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Date getDeadline() {
		return deadline;
	}
}