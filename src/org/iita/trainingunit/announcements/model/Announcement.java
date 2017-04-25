package org.iita.trainingunit.announcements.model;

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
import org.iita.crm.lucene.AnnouncementBridge;
import org.iita.crm.model.AnnouncementDocument;
import org.iita.crm.model.AnnouncementTag;
import org.iita.crm.model.EntityTag;
import org.iita.crm.model.Taggable;
import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.model.Trainer;

@Entity
@Indexed
@ClassBridge(impl = AnnouncementBridge.class)
public class Announcement extends VersionedEntity implements Taggable<Announcement> {
	private static final long serialVersionUID = -4558151348705426344L;
	public enum STATUS {Draft, Published, Application}
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
	private Double trainingFee = 0.0d;
	private String accommodation;
	private String payment;
	private String keywords;
	private Date deadline;
	private String numberOfParticipants;
	private int numberOfFemale = 0;
	private int numberOfMale = 0;
	
	private List<Application> applications;
	private List<AnnouncementDocument> documents;
	private List<AnnouncementTag> tags;
	private List<Trainer> trainers;
	private List<TrainingLocation> trainingLocations;
	private TrainingProposal trainingProposal;
	private STATUS status;
	//private List<ActionLog> actionLog = new ArrayList<ActionLog>();
	
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
	
	/**
	 * Gets the applications.
	 * 
	 * @return the applications
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "announcement")
	public List<Application> getApplications() {
		return this.applications;
	}

	/**
	 * Sets the applications.
	 * 
	 * @param applications the applications to set
	 */
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	/**
	 * @return the documents
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<AnnouncementDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<AnnouncementDocument> documents) {
		this.documents = documents;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<AnnouncementTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<AnnouncementTag> tags) {
		this.tags = tags;
	}

	@Override
	@Transient
	public Class<? extends EntityTag<Announcement>> getTagClass() {
		return AnnouncementTag.class;
	}

	@Override
	public EntityTag<Announcement> createTag() {
		return new AnnouncementTag();
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Lob
	public String getKeywords() {
		return keywords;
	}

	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}

	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public TrainingProposal getTrainingProposal() {
		return trainingProposal;
	}
	
	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "announcement")
	public List<Trainer> getTrainers() {
		return trainers;
	}
	
	public void setTrainingLocations(List<TrainingLocation> trainingLocations) {
		this.trainingLocations = trainingLocations;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "announcement")
	public List<TrainingLocation> getTrainingLocations() {
		return trainingLocations;
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
	//@OneToMany(cascade = {}, mappedBy = "announcement")
//	public List<ActionLog> getActionLog() {
//		return this.actionLog;
//	}
	
	/**
	 * @param actionLog the actionLog to set
	 */
//	public void setActionLog(List<ActionLog> actionLog) {
////		this.actionLog = actionLog;
//	}
}