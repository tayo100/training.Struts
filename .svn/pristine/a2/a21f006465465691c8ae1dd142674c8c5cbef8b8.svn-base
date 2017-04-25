package org.iita.trainingunit.action;

import java.util.List;

import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.trainingunit.applications.model.ApplicationStarter;
import org.iita.trainingunit.applications.model.ApplicationStarter.STATUS;
import org.iita.trainingunit.applications.service.CDOApplicationService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class DashboardActionApplicant extends BioDataAction implements Preparable {
	private AnnouncementService announcementService;	
	private ApplicationStarter appStarter;
	
	private List<Announcement> groups;
	private List<Announcement> graduates;
	private List<Announcement> nonDegrees;
	private List<Announcement> others;
	
	private List<Announcement> sabbatical;
	private List<Announcement> staffDevelopment;
	private List<Announcement> individual;
	private List<Announcement> inhouseGroup;

	public DashboardActionApplicant(CDOApplicationService cdoApplicationService, AnnouncementService announcementService) {
		super(cdoApplicationService);
		this.announcementService = announcementService;
	}
	
	public List<Announcement> getGroups() {
		return groups;
	}
	
	public ApplicationStarter getAppStarter() {
		return appStarter;
	}
	public void setAppStarter(ApplicationStarter appStarter){
		this.appStarter = appStarter;
	}
	
	public List<Announcement> getGraduates() {
		return graduates;
	}
	
	public List<Announcement> getNonDegrees() {
		return nonDegrees;
	}
	
	public List<Announcement> getOthers() {
		return others;
	}
	
	public List<Announcement> getSabbatical() {
		return sabbatical;
	}

	public List<Announcement> getStaffDevelopment() {
		return staffDevelopment;
	}

	public List<Announcement> getIndividual() {
		return individual;
	}

	public List<Announcement> getInhouseGroup() {
		return inhouseGroup;
	}
	
	@Override
	public void prepare() {
		super.prepare();
	}
	
	@Override
	public String execute() {
		super.execute();
		
		if(this.cdoBioData!=null)
			this.appStarter = this.cdoApplicationService.findAppStarterByKey(this.cdoBioData);
		
		this.groups = this.announcementService.list("Group");
		this.graduates = this.announcementService.list("Graduate");
		this.nonDegrees = this.announcementService.list("Non-degree");
		this.others = this.announcementService.list("Other");
		
		this.inhouseGroup = this.announcementService.list("In-house Group");
		this.individual = this.announcementService.list("Individual");
		this.sabbatical = this.announcementService.list("Sabbatical");
		this.staffDevelopment = this.announcementService.list("Staff Development");
		
		if(this.appStarter!=null){
			if(this.cdoBioData!=null){
				if(this.cdoBioData.getEducationAndTraining().size()==0 && this.cdoBioData.getEmploymentHistory().size()==0 && 
					this.cdoBioData.getLanguageSpoken().size()==0 && this.cdoBioData.getOtherStudiesAndTraining().size()==0)
					return "biodata";		
			}
			if(this.appStarter.getStatus().equals(STATUS.INPROGRESS))
				return "continue";
		}
		return Action.SUCCESS;
	}

}
