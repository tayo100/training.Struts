package org.iita.trainingunit.announcements.action;

import org.iita.trainingunit.action.BioDataAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.OtherApplicationDetails;
import org.iita.trainingunit.applications.service.CDOApplicationService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class ApplicantAnnouncementAction extends BioDataAction implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1417523288661425735L;
	private AnnouncementService announcementService;
	//private Long announcementId;
	private Long applicationId;
	private Application cdoApplication;
	private String refNumber;
	//private ApplicantsBioData cdoBioData;
	private OtherApplicationDetails otherAppDetails;
	private Long otherAppDetailsId;
	
	private Long id;
	private Announcement announcement;
	
	public ApplicantAnnouncementAction(AnnouncementService announcementService, CDOApplicationService cdoApplicationService) {
		super(cdoApplicationService);
		this.announcementService = announcementService;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param announcementId the announcementId to set
	 */
	//public void setAnnouncementId(Long announcementId) {
	//	this.announcementId = announcementId;
	//}

	/**
	 * @return the announcementId
	 */
	//public Long getAnnouncementId() {
	//	return announcementId;
	//}
	
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the applicationId
	 */
	public Long getApplicationId() {
		return applicationId;
	}
	
	
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}
	
	
	public void setCdoApplication(Application cdoApplication) {
		this.cdoApplication = cdoApplication;
	}

	public Application getCdoApplication() {
		return cdoApplication;
	}
	
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getRefNumber() {
		return refNumber;
	}
	
	public void setCdoBioData(ApplicantsBioData cdoBioData) {
		this.cdoBioData = cdoBioData;
	}
	
	public void setOtherAppDetails(OtherApplicationDetails otherAppDetails) {
		this.otherAppDetails = otherAppDetails;
	}

	public OtherApplicationDetails getOtherAppDetails() {
		return otherAppDetails;
	}
	
	/**
	 * @return the otherAppDetailsId
	 */
	public Long getOtherAppDetailsId() {
		return otherAppDetailsId;
	}

	/**
	 * @param otherAppDetailsId the otherAppDetailsId to set
	 */
	public void setOtherAppDetailsId(Long otherAppDetailsId) {
		this.otherAppDetailsId = otherAppDetailsId;
	}
	
	@Override
	public void prepare(){
		super.prepare();
		
		if(this.id!=null)
			this.announcement =this.announcementService.find(this.id);

		if(this.applicationId!=null)
			this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
	}
	
	@Override
	public String execute() {
		super.execute();
		return Action.SUCCESS;
	}
	/*
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "announcement.type", trim=true, message = "Select announcement type"),
			@RequiredStringValidator(fieldName = "announcement.title", trim=true, message = "Enter announcement title"),
			@RequiredStringValidator(fieldName = "announcement.introduction", trim=true, message = "Enter announcement introduction")})
	public String save(){
		
		if(cdoApplication == null){					
				this.cdoApplication.setAnnouncement(this.announcement);
				//this.cdoApplication.setType(TYPE.GROUP);
				this.cdoApplication.setSubmissionStatus(SUBMISSIONSTATUS.Submitted);
				this.cdoApplication.setBiodata(this.cdoBioData);
			
				try {
					//Saving application
					this.cdoApplication = this.cdoApplicationService.save(this.cdoApplication);
				}catch(Exception e){
					addActionError("Error saving CDO application! " + e.getMessage());
				}
		}else{
			this.cdoApplication.setAnnouncement(this.announcement);
			//this.cdoApplication.setType(TYPE.GROUP);
			this.cdoApplication.setSubmissionStatus(SUBMISSIONSTATUS.Submitted);
			this.cdoApplication.setBiodata(this.cdoBioData);
			try {
				//Saving application
				this.cdoApplication = this.cdoApplicationService.save(this.cdoApplication);
			}catch(Exception e){
				addActionError("Error saving CDO application! " + e.getMessage());
			}
		}

		//Check if other app details were not null
		if(this.cdoApplication!=null){
			if(this.otherAppDetails.getNameOfSponsor().length() > 0 || this.otherAppDetails.getStartDate()!=null){
				OtherApplicationDetails otherAppD = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId); 
				
				if(otherAppD == null){
					if(this.otherAppDetailsId == null){
						this.otherAppDetails.setApplication(this.cdoApplication);
						this.cdoApplicationService.save(this.otherAppDetails);
					}else{
						this.cdoApplicationService.save(this.otherAppDetails);
					}
				}else{
					this.otherAppDetails.setId(otherAppDetailsId);
					this.cdoApplicationService.save(this.otherAppDetails);
				}
			}
		}
		
		if(this.cdoApplication!=null){
			if(this.cdoApplication.getId()!=null)
				addActionMessage("Application updated successfully! But yet to be submitted.");
			else
				addActionMessage("Application saved successfully! But yet to be submitted.");
		}else{
			addActionError("Error saving CDO application! Application is empty.");
		}
		
		return Action.SUCCESS;
	}*/
}