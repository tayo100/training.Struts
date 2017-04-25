package org.iita.trainingunit.action;

import org.iita.crm.model.AnnouncementTag;
import org.iita.crm.model.ApplicationTag;
import org.iita.struts.BaseAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TraineeTag;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.TrainingProgramTag;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class TagsAction extends BaseAction {
	private TrainingUnitService service;
	private AnnouncementService announcementService;
	private CDOApplicationService cdoApplicationService;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	
	private Announcement announcement;
	private Application application;	
	
	private String tag;
	private Long traineeId;
	private Long tagId;
	private Long programId;
	
	private Long announcementId;
	private Long applicationId;
	
	public TagsAction(TrainingUnitService trainingUnitService, AnnouncementService announcementService, CDOApplicationService cdoApplicationService) {
		this.service = trainingUnitService;
		this.announcementService = announcementService;
		this.cdoApplicationService = cdoApplicationService;
	}

	/**
	 * @return the trainee
	 */
	public Trainee getTrainee() {
		return trainee;
	}

	/**
	 * @return the trainingProgram
	 */
	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}
	
	/**
	 * @return the announcement
	 */
	public Announcement getAnnouncement() {
		return announcement;
	}
	
	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}
	
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	
	/**
	 * @param traineeId the traineeId to set
	 */
	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}
	
	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	
	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String execute() {
		String resultType = Action.SUCCESS;
		
		if (this.traineeId != null)
			this.trainee = this.service.loadTrainee(this.traineeId);
		if (this.programId != null)
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);
		if (this.announcementId != null)
			this.announcement = this.announcementService.find(this.announcementId);
		if (this.applicationId != null)
			this.application = this.cdoApplicationService.find(this.applicationId);

		if (this.tag != null) {
			if (this.trainee != null) {
				this.service.createTag(this.tag, this.trainee);
				resultType = "trainee";
			} else if (this.trainingProgram != null) {
				this.service.createTag(this.tag, this.trainingProgram);
				resultType = "program";
			} else if (this.announcement != null) {
				this.service.createTag(this.tag, this.announcement);
				resultType = "announcement";
			} else if (this.application != null) {
				this.service.createTag(this.tag, this.application);
				resultType = "application";
			}
		}

		return resultType;
	}
	
	public String remove() {
		String resultType = "unknown";
		
		if (this.traineeId != null)
			this.trainee = this.service.loadTrainee(this.traineeId);
		if (this.programId != null)
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);
		if (this.announcementId != null)
			this.announcement = this.announcementService.find(this.announcementId);
		if (this.applicationId != null)
			this.application = this.cdoApplicationService.find(this.applicationId);
		
		if (this.trainee != null) {
			TraineeTag tag = new TraineeTag();
			tag = (TraineeTag) this.service.find(TraineeTag.class, this.tagId);
			this.service.removeTag(tag);
			resultType = "trainee";
		}else if(this.trainingProgram != null){
			TrainingProgramTag tag = new TrainingProgramTag();
			tag = (TrainingProgramTag) this.service.find(TrainingProgramTag.class, this.tagId);
			this.service.removeTag(tag);
			resultType = "program";
		} else if (this.announcement != null) {
			this.service.createTag(this.tag, this.announcement);
			resultType = "announcement";
		} else if (this.application != null) {
			this.service.createTag(this.tag, this.application);
			resultType = "application";
		}

		return resultType;
	}
	
	public String update() {
		String resultType = "unknown";
		
		if (this.tagId != null){
			if (this.traineeId != null)
				this.trainee = this.service.loadTrainee(this.traineeId);
			
			if (this.programId != null)
				this.trainingProgram = this.service.loadTrainingProgram(this.programId);
			
			if (this.announcementId != null)
				this.announcement = this.announcementService.find(this.announcementId);
			
			if (this.applicationId != null)
				this.application = this.cdoApplicationService.find(this.applicationId);
			
			if (this.trainee != null) {
				TraineeTag tagEntity = new TraineeTag();
				tagEntity = (TraineeTag) this.service.find(TraineeTag.class, this.tagId);
				
				tagEntity.setTag(this.tag);
				
				this.service.updateTag(tagEntity);
				resultType = "trainee";
				
			}else if(this.trainingProgram != null){
				TrainingProgramTag tagEntity = new TrainingProgramTag();
				tagEntity = (TrainingProgramTag) this.service.find(TrainingProgramTag.class, this.tagId);
				
				tagEntity.setTag(this.tag);
				
				this.service.updateTag(tagEntity);
				resultType = "program";
			}else if(this.announcement != null){
				AnnouncementTag tagEntity = new AnnouncementTag();
				tagEntity = (AnnouncementTag) this.service.find(AnnouncementTag.class, this.tagId);
				
				tagEntity.setTag(this.tag);
				
				this.service.updateTag(tagEntity);
				resultType = "announcement";
			}else if(this.application != null){
				ApplicationTag tagEntity = new ApplicationTag();
				tagEntity = (ApplicationTag) this.service.find(ApplicationTag.class, this.tagId);
				
				tagEntity.setTag(this.tag);
				
				this.service.updateTag(tagEntity);
				resultType = "application";
			}
		}
		return resultType;
	}
}
