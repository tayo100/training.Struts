package org.iita.trainingunit.announcements.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.ActionLog;
import org.iita.crm.model.TrainingProposalDocument;
import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;
import org.iita.trainingunit.model.Trainer;
import org.joda.time.Period;
import org.joda.time.PeriodType;

@Entity
@Indexed
@ClassBridge(impl = org.iita.crm.lucene.TrainingProposalBridge.class)
public class TrainingProposal extends VersionedEntity {
	private static final long serialVersionUID = 894103699487157361L;
	private User owner;
	private User requester;
	private User programDirector;
	private String type;
	private String unit;
	private String projectInformation;
	private String crp;
	private String costCenter;
	private String activity;
	
	private String title;
	private String introduction;
	private String targetGroup;
	private String objective;
	private String learningMethod;
	private String expectedOutcome;
	private String courseContents;
	private String duration;

	private Double trainingFee = 0.0d;
	private String accommodation;
	private String payment;
	private String keywords;
	private Date deadline;
	private String numberOfParticipants;
	private int numberOfFemale = 0;
	private int numberOfMale = 0;
	
	
	private Announcement announcement;
	private List<Trainer> trainers;
	private List<TrainingLocation> trainingLocations;
	private List<TrainingProposalDocument> documents;
	private List<ActionLog> actionLog = new ArrayList<ActionLog>();
	private STATUS status = STATUS.DRAFT;
	
	public enum STATUS{DRAFT, SUBMITTED, AMMEND}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}

	@ManyToOne(cascade = {}, optional = true)
	public User getOwner() {
		return owner;
	}
	
	public void setRequester(User requester) {
		this.requester = requester;
	}

	@ManyToOne(cascade = {}, optional = true)
	public User getRequester() {
		return requester;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Column(length = 100)
	public String getType() {
		return type;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(length = 100)
	public String getUnit() {
		return unit;
	}

	public void setProgramDirector(User programDirector) {
		this.programDirector = programDirector;
	}

	@ManyToOne(cascade = {}, optional = true)
	public User getProgramDirector() {
		return programDirector;
	}

	public void setProjectInformation(String projectInformation) {
		this.projectInformation = projectInformation;
	}

	@Lob
	public String getProjectInformation() {
		return projectInformation;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	@Lob
	public String getCrp() {
		return crp;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	@Column(length = 100)
	public String getCostCenter() {
		return costCenter;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Lob
	public String getActivity() {
		return activity;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 255)
	public String getTitle() {
		return title;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Lob
	public String getIntroduction() {
		return introduction;
	}

	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}
	
	@Column(length = 500)
	public String getTargetGroup() {
		return targetGroup;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	@Lob
	public String getObjective() {
		return objective;
	}

	public void setLearningMethod(String learningMethod) {
		this.learningMethod = learningMethod;
	}
	
	@Lob
	public String getLearningMethod() {
		return learningMethod;
	}

	public void setExpectedOutcome(String expectedOutcome) {
		this.expectedOutcome = expectedOutcome;
	}

	@Lob
	public String getExpectedOutcome() {
		return expectedOutcome;
	}

	public void setCourseContents(String courseContents) {
		this.courseContents = courseContents;
	}

	@Lob
	public String getCourseContents() {
		return courseContents;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Column(length = 500)
	public String getDuration() {
		return duration;
	}

	public void setTrainingFee(Double trainingFee) {
		this.trainingFee = trainingFee;
	}

	public Double getTrainingFee() {
		return trainingFee;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	@Lob
	public String getAccommodation() {
		return accommodation;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	@Lob
	public String getPayment() {
		return payment;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Lob
	public String getKeywords() {
		return keywords;
	}

	public void setNumberOfParticipants(String numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	
	@Column(length = 255)
	public String getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfFemale(int numberOfFemale) {
		this.numberOfFemale = numberOfFemale;
	}

	public int getNumberOfFemale() {
		return numberOfFemale;
	}

	public void setNumberOfMale(int numberOfMale) {
		this.numberOfMale = numberOfMale;
	}

	public int getNumberOfMale() {
		return numberOfMale;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "trainingProposal")
	public List<Trainer> getTrainers() {
		return trainers;
	}
	
	public void setTrainingLocations(List<TrainingLocation> trainingLocations) {
		this.trainingLocations = trainingLocations;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "trainingProposal")
	public List<TrainingLocation> getTrainingLocations() {
		return trainingLocations;
	}
	
	/**
	 * @return the documents
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<TrainingProposalDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<TrainingProposalDocument> documents) {
		this.documents = documents;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public STATUS getStatus() {
		return status;
	}
	
	/**
	 * @return the actionLog
	 */
	@OneToMany(cascade = {}, mappedBy = "trainingProposal")
	public List<ActionLog> getActionLog() {
		return this.actionLog;
	}
	
	/**
	 * @param actionLog the actionLog to set
	 */
	public void setActionLog(List<ActionLog> actionLog) {
		this.actionLog = actionLog;
	}
	
	@Transient
	public String getProposalLocations(){
		StringBuffer sb = new StringBuffer();
		
		for (TrainingLocation loc : this.trainingLocations) {
			if(loc != null){
				if(!sb.toString().isEmpty())
					sb.append("<br/>Country: ").append(loc.getCountry()).append(", Venue: ").append(loc.getVenue()).append(", Start date: ")
					.append(loc.getStartDate()).append(", End date: ").append(loc.getEndDate()).append(", Duration: ").append(getActualDuration(loc.getStartDate(), loc.getEndDate())).append(";");
				else
					sb.append("Country: ").append(loc.getCountry()).append(", Venue: ").append(loc.getVenue()).append(", Start date: ")
					.append(loc.getStartDate()).append(", End date: ").append(loc.getEndDate()).append(", Duration: ").append(getActualDuration(loc.getStartDate(), loc.getEndDate())).append(";");
			}
		}
		return sb.toString();
	}

	
	@Transient
	public String getProposalTrainers(){
		StringBuffer sb = new StringBuffer();
		
		for (Trainer trainer : this.trainers) {
			//if(trainer.getType()==Trainer.TrainerType.EXTERNAL){
			if(trainer != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(trainer.getPerson().getFullName());
				else
					sb.append(trainer.getPerson().getFullName());
			}
			//}
		}
		return sb.toString();
	}
	
	@Transient
	public String getProposalDocuments(){
		StringBuffer sb = new StringBuffer();
		String link = "http://cdo.iita.org/training/announcement/document-download.jspx?id=";
		String filelink = "&file=";
		for (TrainingProposalDocument doc : this.documents) {
			if(doc != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(link).append(id).append(filelink).append(doc.getDocument().getFilePath()).append(doc.getDocument().getFilePath());
				else
					sb.append(link).append(id).append(filelink).append(doc.getDocument().getFilePath()).append(doc.getDocument().getFilePath());
			}
		}
		return sb.toString();
	}
	
	/**
	 * Get duration of training
	 */
	@Transient
	private String getActualDuration(Date startDate, Date endDate) {
		if(endDate != null && startDate != null){
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