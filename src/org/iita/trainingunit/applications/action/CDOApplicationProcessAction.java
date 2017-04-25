/**
 * 
 */
package org.iita.trainingunit.applications.action;

import org.iita.trainingunit.action.BioDataAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InternalApprovals;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author ken
 *
 */
public class CDOApplicationProcessAction extends BioDataAction implements Preparable {
	private static final long serialVersionUID = -2642817088143032173L;
	private ApprovalService approvalService;
	private Announcement announcement;
	private Long applicationId;
	private Long announcementId;
	private String projOfficer;
	
	private Application application = null;
	private InternalApprovals internalApprovals = null;

	
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param projOfficer the projOfficer to set
	 */
	public void setProjOfficer(String projOfficer) {
		this.projOfficer = projOfficer;
	}
	
	/**
	 * @return the projOfficer
	 */
	//public String getProjOfficer() {
	//	return projOfficer;
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
	
	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	/**
	 * @return the announcementId
	 */
	public Long getAnnouncementId() {
		return announcementId;
	}
	
	/**
	 * @return the cdoApplication
	 */
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	/**
	 * @return the internalApprovals
	 */
	public InternalApprovals getInternalApprovals() {
		return internalApprovals;
	}

	public void setInternalApprovals(InternalApprovals internalApprovals) {
		this.internalApprovals = internalApprovals;
	}
	
	public void setCdoBioData(ApplicantsBioData cdoBioData) {
		this.cdoBioData = cdoBioData;
	}

	public ApplicantsBioData getCdoBioData() {
		return cdoBioData;
	}
	
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}
	
	public CDOApplicationProcessAction(CDOApplicationService cdoApplicationService, ApprovalService approvalService) {
		super(cdoApplicationService);
		this.approvalService = approvalService;
	}
	
	@Override
	public void prepare(){
		super.prepare();
		if(this.applicationId!=null)
			this.application = this.cdoApplicationService.findApplication(this.applicationId);
		
		if(this.application!=null)
		{
			if(this.application instanceof GraduateResearchTraining)
				this.application = (GraduateResearchTraining) this.application;	
			else if(this.application instanceof GroupTraining)
				this.application = (GroupTraining) this.application;
			else if(this.application instanceof SabbaticalTraining)
				this.application = (SabbaticalTraining) this.application;
			else if(this.application instanceof InternshipTraining)
				this.application = (InternshipTraining) this.application;
			
			this.cdoBioData = this.application.getBiodata();
			
			this.announcement = this.application.getAnnouncement();
			
			this.announcementId = this.application.getAnnouncement().getId();
		}
	}
	
	public String forward() throws CDOApplicationException, ApprovalException{
		
		try{
			if(this.application!=null){
				
				if(this.application instanceof GraduateResearchTraining)
					this.application = (GraduateResearchTraining) this.application;
				else if(this.application instanceof GroupTraining)
					this.application = (GroupTraining) this.application;
				else if(this.application instanceof SabbaticalTraining)
					this.application = (SabbaticalTraining) this.application;
				else if(this.application instanceof InternshipTraining)
					this.application = (InternshipTraining) this.application;
				
				this.internalApprovals.setApplication(this.application);
				this.internalApprovals.setProjOfficer(this.projOfficer);
				
				this.internalApprovals = this.cdoApplicationService.validate(this.internalApprovals);
				
				this.approvalService.approve(this.internalApprovals.getApplication(), this.getUser(), this.internalApprovals.getRemarks());
			}else{
				addActionError("Application process called with no ID!");
				return Action.ERROR;
			}
			addActionMessage("Application forwarded successfully! Awaiting for approval.");
		}
		catch(Exception ex){
			addActionError("Error occurred application.: " + ex.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;		
	}
	
	public String reject(){
		try{
			if(this.application!=null){
				
				if(this.application instanceof GraduateResearchTraining)
					this.application = (GraduateResearchTraining) this.application;
				else if(this.application instanceof GroupTraining)
					this.application = (GroupTraining) this.application;
				else if(this.application instanceof SabbaticalTraining)
					this.application = (SabbaticalTraining) this.application;
				else if(this.application instanceof InternshipTraining)
					this.application = (InternshipTraining) this.application;
				
				this.internalApprovals.setApplication(this.application);
				this.internalApprovals.setProjOfficer(this.projOfficer);
				
				this.internalApprovals = this.cdoApplicationService.validate(this.internalApprovals);
				
				this.approvalService.reject(this.internalApprovals.getApplication(), this.getUser(), this.internalApprovals.getRemarks());
			}else{
				addActionError("Application process called with no ID!");
				return Action.ERROR;
			}
			addActionMessage("Application rejected successfully! Notifying applicant.");
		}
		catch(Exception ex){
			addActionError("Error occurred application.: " + ex.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
		
	}
	
	
	@Override
	public String execute() {
		super.execute();
		return Action.SUCCESS;
	}
}
