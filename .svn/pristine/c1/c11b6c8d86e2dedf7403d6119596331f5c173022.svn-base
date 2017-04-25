package org.iita.trainingunit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.EntityTag;
import org.iita.crm.model.Taggable;
import org.iita.crm.model.TrainingProgramDocument;
import org.iita.entity.VersionedEntity;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * <p>
 * Group training is usually a short term training with several participants. Compared to individual trainees, group training focuses more on the training and
 * trainers than the individual participants of training. A group training contains:
 * </p>
 * <ul>
 * <li>Title and description</li>
 * <li>Trainers (see {@link Trainer})</li>
 * <li>Attendees (see {@link Attendance})</li>
 * <li>Funding information</li>
 * </ul>
 * <p>
 * Group trainings are usually announced before the event. Once finished, attendance records and training evaluation is provided by trainers.
 * </p>
 */
@Entity
@Indexed
@ClassBridge(impl = org.iita.trainingunit.lucene.TrainingProgramBridge.class)
public class TrainingProgram extends VersionedEntity implements Taggable<TrainingProgram> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4697289065357496908L;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The location. */
	private String location;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The trainers. */
	private List<Trainer> trainers;

	/** The status. */
	private ProgramType status;

	/** The female participants. */
	private int femaleParticipants = 0;

	/** The male participants. */
	private int maleParticipants = 0;

	/** The country. */
	private String country;

	/** The keywords. */
	private String keywords;

	/** The fundings. */
	private List<Funding> fundings;

	/** The outcomes. */
	private String outcomes;

	/** The alerts. */
	private List<Alert> alerts;
	
	/** The attendance */
	private List<Attendance> attendance;
	
	/** Tags */
	private List<TrainingProgramTag> tags = new ArrayList<TrainingProgramTag>();
	
	/** The program. */
	private String program;
	
	/** The latitude. */
	private Double latitude;
	
	/** The longitude. */
	private Double longitude;
	
	private String purpose;
	
	/**
	 * The Enum ProgramType.
	 */
	public enum ProgramType {
		/** Group training */
		GROUP, NRS, OTHER, PROGRAMRELATED, STAFFDEVELOPMENT, NARS
	}
	private List<TrainingProgramDocument> documents;

	private List<Hub> hubs = new ArrayList<Hub>();
	private List<Crp> crps = new ArrayList<Crp>();
	private List<CoreCompetency> coreCompetencies = new ArrayList<CoreCompetency>();
	private List<SubProgram> subPrograms = new ArrayList<SubProgram>();
	
	/**
	 * Gets the title of group training
	 * 
	 * @return the title
	 */
	@Column(length = 300, nullable = false)
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of group training
	 * 
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	@Lob
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the trainers.
	 * 
	 * @return the trainers
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "group")
	public List<Trainer> getTrainers() {
		return trainers;
	}

	/**
	 * Sets the trainers.
	 * 
	 * @param trainers the new trainers
	 */
	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(ProgramType status) {
		this.status = status;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	@Enumerated(EnumType.STRING)
	public ProgramType getStatus() {
		return status;
	}

	/**
	 * Gets the female participants.
	 * 
	 * @return the female participants
	 */
	public int getFemaleParticipants() {
		return femaleParticipants;
	}

	/**
	 * Sets the female participants.
	 * 
	 * @param femaleParticipants the new female participants
	 */
	public void setFemaleParticipants(int femaleParticipants) {
		this.femaleParticipants = femaleParticipants;
	}

	/**
	 * Gets the male participants.
	 * 
	 * @return the male participants
	 */
	public int getMaleParticipants() {
		return maleParticipants;
	}

	/**
	 * Sets the male participants.
	 * 
	 * @param maleParticipants the new male participants
	 */
	public void setMaleParticipants(int maleParticipants) {
		this.maleParticipants = maleParticipants;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the startDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 * 
	 * @return the endDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Is this Training Program expired (i.e. already passed)?
	 * 
	 * @return true, if checks if is expired
	 */
	@Transient
	public boolean isExpired() {
		if (this.endDate == null)
			return false;
		return this.endDate.before(new Date());
	}

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	@Column(length = 300)
	public String getLocation() {
		return this.location;
	}

	/**
	 * Sets the location.
	 * 
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	@Column(length = 50)
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the keywords.
	 * 
	 * @return the keywords
	 */
	@Lob
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Sets the keywords.
	 * 
	 * @param keywords the new keywords
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * Gets the fundings.
	 * 
	 * @return the fundings
	 */
	@OneToMany(cascade = { CascadeType.ALL })
	public List<Funding> getFundings() {
		return fundings;
	}

	/**
	 * Sets the fundings.
	 * 
	 * @param fundings the new fundings
	 */
	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	/**
	 * Sets the outcomes.
	 * 
	 * @param outcomes the new outcomes
	 */
	public void setOutcomes(String outcomes) {
		this.outcomes = outcomes;
	}

	/**
	 * Gets the outcomes.
	 * 
	 * @return the outcomes
	 */
	@Lob
	public String getOutcomes() {
		return outcomes;
	}

	/**
	 * Sets the alerts.
	 * 
	 * @param alert the new alerts
	 */
	public void setAlerts(List<Alert> alert) {
		this.alerts = alert;
	}

	/**
	 * Gets the alerts.
	 * 
	 * @return the alerts
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "group")
	@OrderBy("alertDate")
	public List<Alert> getAlerts() {
		return alerts;
	}
	
	/**
	 * Sets the attendance.
	 * 
	 * @param alert the new alerts
	 */
	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	/**
	 * Gets the attendance.
	 * 
	 * @return the attendance
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "trainingProgram")
	@OrderBy("attendanceDate")
	public List<Attendance> getAttendance() {
		return attendance;
	}
	
	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<TrainingProgramTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<TrainingProgramTag> tags) {
		this.tags = tags;
	}
	
	/**
	 * Sets the program.
	 * 
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * Gets the program.
	 * 
	 * @return the program
	 */
	@Column(length = 100)
	public String getProgram() {
		return program;
	}
	
	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the purpose
	 */
	@Lob
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @see org.iita.crm.model.Taggable#createTag()
	 */
	@Override
	public EntityTag<TrainingProgram> createTag() {
		return new TrainingProgramTag();
	}
	
	/**
	 * @return the documents
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<TrainingProgramDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<TrainingProgramDocument> documents) {
		this.documents = documents;
	}
	
	/**
	 * Gets the hubs.
	 * 
	 * @return the hubs
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
	public List<Hub> getHubs() {
		return this.hubs;
	}

	/**
	 * Sets the hubs.
	 * 
	 * @param hubs the hubs to set
	 */
	public void setHubs(List<Hub> hubs) {
		this.hubs = hubs;
	}
	
	/**
	 * Gets the crps.
	 * 
	 * @return the crps
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
	public List<Crp> getCrps() {
		return this.crps;
	}

	/**
	 * Sets the crps.
	 * 
	 * @param crps the crps to set
	 */
	public void setCrps(List<Crp> crps) {
		this.crps = crps;
	}
	
	/**
	 * Gets the coreCompetencies.
	 * 
	 * @return the coreCompetencies
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
	public List<CoreCompetency> getCoreCompetencies() {
		return this.coreCompetencies;
	}

	/**
	 * Sets the coreCompetencies.
	 * 
	 * @param coreCompetencies the coreCompetencies to set
	 */
	public void setCoreCompetencies(List<CoreCompetency> coreCompetencies) {
		this.coreCompetencies = coreCompetencies;
	}
	
	/**
	 * Gets the subPrograms.
	 * 
	 * @return the subPrograms
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
	public List<SubProgram> getSubPrograms() {
		return this.subPrograms;
	}

	/**
	 * Sets the subPrograms.
	 * 
	 * @param subPrograms the subPrograms to set
	 */
	public void setSubPrograms(List<SubProgram> subPrograms) {
		this.subPrograms = subPrograms;
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#getTagClass()
	 */
	@Override
	@Transient
	public Class<? extends EntityTag<TrainingProgram>> getTagClass() {
		return TrainingProgramTag.class;
	}
	
	/**
	 * Is this trainee suppose to receive alert?.
	 * 
	 * @return true, then it should sendAlert
	 */
	@Transient
	public boolean sendAlert() {
		if (this.endDate != null){
			long diff = this.endDate.getTime() - this.startDate.getTime();
			if((diff / (1000 * 60 * 60 * 24))>=365)
				return true;
			else			
				return false;
		}
		
		if(this.endDate == null)
			return true;
		else
			return false;
	}
	
	@Transient
	public String getCostCenters(){
		StringBuffer sb = new StringBuffer();
		
		for (Funding funding : this.fundings) {
			if(funding != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(funding.getCostCenter());
				else
					sb.append(funding.getCostCenter());
			}
		}
		return sb.toString();
	}

	
	@Transient
	public String getExternalTrainers(){
		StringBuffer sb = new StringBuffer();
		
		for (Trainer trainer : this.trainers) {
			if(trainer.getType()==Trainer.TrainerType.EXTERNAL){
				if(trainer != null){
					if(!sb.toString().isEmpty())
						sb.append(", ").append(trainer.getPerson().getFullName());
					else
						sb.append(trainer.getPerson().getFullName());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getIitaTrainers(){
		StringBuffer sb = new StringBuffer();
		
		for (Trainer trainer : this.trainers) {
			if(trainer.getType()==Trainer.TrainerType.INTERNAL){
				if(trainer != null){
					if(!sb.toString().isEmpty())
						sb.append(", ").append(trainer.getPerson().getFullName());
					else
						sb.append(trainer.getPerson().getFullName());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportHubs(){
		StringBuffer sb = new StringBuffer();
		
		for (Hub hub : this.hubs) {
			if(hub != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(hub.getName());
				else
					sb.append(hub.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportCrps(){
		StringBuffer sb = new StringBuffer();
		
		for (Crp crp : this.crps) {
			if(crp != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(crp.getName());
				else
					sb.append(crp.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportCoreCompetencies(){
		StringBuffer sb = new StringBuffer();
		
		for (CoreCompetency core : this.coreCompetencies) {
			if(core != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(core.getName());
				else
					sb.append(core.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportSubPrograms(){
		StringBuffer sb = new StringBuffer();
		
		for (SubProgram sub : this.subPrograms) {
			if(sub != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(sub.getName());
				else
					sb.append(sub.getName());
			}
		}
		return sb.toString();
	}
	
	/**
	 * Get duration of training
	 */
	@Transient
	public String getDuration() {
		if(this.endDate != null && startDate != null){
			Period period = new Period(startDate.getTime(), endDate.getTime(), PeriodType.days());
			int years = period.getYears();
			int months = period.getMonths();
			int weeks = period.getWeeks();
			int days = period.getDays()+1;
			
			if (years > 0)
				return years + (years == 1 ? " year" : " years");
			else if (months > 0)
				return months + (months == 1 ? " month" : " months");
			else if (weeks > 0)
				return weeks + (weeks == 1 ? " week" : " weeks");
			else if (days > 0)
				return days + (days == 1 ? " day" : " days");
			else {
				int hours = period.getHours();
				return hours + (hours == 1 ? " hour" : " hours");
			}
		} else
			return "N/A";
	}
}
