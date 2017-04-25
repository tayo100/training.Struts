/**
 * 
 */
package org.iita.trainingunit.applications.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.iita.security.Authorize;
import org.iita.trainingunit.action.BioDataAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Application.APPLICATIONSTATUS;
import org.iita.trainingunit.applications.model.Application.SUBMISSIONSTATUS;
import org.iita.trainingunit.applications.model.ApplicationStarter;
import org.iita.trainingunit.applications.model.ApplicationStarter.STATUS;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InHouseTraining;
import org.iita.trainingunit.applications.model.IndividualTraining;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.NonDegreeTraining;
import org.iita.trainingunit.applications.model.OtherApplicationDetails;
import org.iita.trainingunit.applications.model.OtherTraining;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.model.StaffDevTraining;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author ken
 *
 */
public class CDOApplicationAction extends BioDataAction implements Preparable {
	private static final long serialVersionUID = -2642817088143032173L;
	private AnnouncementService announcementService;
	private ApprovalService approvalService;
	private Long announcementId;
	private Long applicationId;
	private Long graduateId;
	private Long internshipId;
	private Long nondegreeId;
	private Long otherId;
	
	private Long individualId;
	private Long staffDevId;
	private Long inhouseGroupId;
	private Long sabbaticalId;
	
	private Announcement announcement;
	
	private Application application;
	
	protected int startAt = 0, maxResults = 50;
	protected PagedResult<Application> paged;
	
	protected GroupTraining cdoApplication = null;
	protected GraduateResearchTraining cdoGraduateApplication = null;
	protected NonDegreeTraining cdoNonDegreeApplication;
	protected OtherTraining cdoOtherApplication;
	
	protected IndividualTraining cdoIndividualApplication;
	protected InHouseTraining cdoInhouseApplication;
	protected SabbaticalTraining cdoSabbaticalApplication;
	protected StaffDevTraining cdoStaffDevApplication;
	
	protected InternshipTraining cdoInternshipApplication;
	
	private OtherApplicationDetails otherAppDetails;
	private Long otherAppDetailsId;
	private ApplicationStarter appStarter;
	
	private List<Long> selectedLocations =  new ArrayList<Long>();
	private String[] selectedTypeOfSupport;
	private String[] selectedFundingSource;
	
	private String trainingOption;
	
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
	 * @return the otherId
	 */
	public Long getOtherId() {
		return otherId;
	}

	/**
	 * @param otherId the otherId to set
	 */
	public void setOtherId(Long otherId) {
		this.otherId = otherId;
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
	
	public PagedResult<Application> getPaged() {
		return paged;
	}
	
	public ApplicationStarter getAppStarter() {
		return appStarter;
	}
	public void setAppStarter(ApplicationStarter appStarter){
		this.appStarter = appStarter;
	}
	
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
	 * @param graduateId the graduateId to set
	 */
	public void setGraduateId(Long graduateId) {
		this.graduateId = graduateId;
	}

	/**
	 * @return the graduateId
	 */
	public Long getGraduateId() {
		return graduateId;
	}
	
	/**
	 * @param internshipId the internshipId to set
	 */
	public void setInternshipId(Long internshipId) {
		this.internshipId = internshipId;
	}

	/**
	 * @return the internshipId
	 */
	public Long getInternshipId() {
		return internshipId;
	}
	
	/**
	 * @param nondegreeId the nondegreeId to set
	 */
	public void setNondegreeId(Long nondegreeId) {
		this.nondegreeId = nondegreeId;
	}

	/**
	 * @return the nondegreeId
	 */
	public Long getNondegreeId() {
		return nondegreeId;
	}
	
	public Long getIndividualId() {
		return individualId;
	}

	public void setIndividualId(Long individualId) {
		this.individualId = individualId;
	}

	public Long getStaffDevId() {
		return staffDevId;
	}

	public void setStaffDevId(Long staffDevId) {
		this.staffDevId = staffDevId;
	}

	public Long getInhouseGroupId() {
		return inhouseGroupId;
	}

	public void setInhouseGroupId(Long inhouseGroupId) {
		this.inhouseGroupId = inhouseGroupId;
	}

	public Long getSabbaticalId() {
		return sabbaticalId;
	}

	public void setSabbaticalId(Long sabbaticalId) {
		this.sabbaticalId = sabbaticalId;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	public Application getApplication() {
		return application;
	}
	
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}
	
	public void setCdoBioData(ApplicantsBioData cdoBioData) {
		this.cdoBioData = cdoBioData;
	}

	public ApplicantsBioData getCdoBioData() {
		return cdoBioData;
	}
	
	public void setCdoApplication(GroupTraining cdoApplication) {
		this.cdoApplication = cdoApplication;
	}

	public GroupTraining getCdoApplication() {
		return cdoApplication;
	}
	
	public void setCdoOtherApplication(OtherTraining cdoOtherApplication) {
		this.cdoOtherApplication = cdoOtherApplication;
	}

	public OtherTraining getCdoOtherApplication() {
		return cdoOtherApplication;
	}
	
	/*
	public void setCdoGraduateApplication(GraduateResearchTraining cdoGraduateApplication) {
		this.cdoGraduateApplication = cdoGraduateApplication;
	}*/

	public GraduateResearchTraining getCdoGraduateApplication() {
		return cdoGraduateApplication;
	}
	
	public void setCdoNonDegreeApplication(NonDegreeTraining cdoNonDegreeApplication) {
		this.cdoNonDegreeApplication = cdoNonDegreeApplication;
	}

	public NonDegreeTraining getCdoNonDegreeApplication() {
		return cdoNonDegreeApplication;
	}

	public void setOtherAppDetails(OtherApplicationDetails otherAppDetails) {
		this.otherAppDetails = otherAppDetails;
	}

	public OtherApplicationDetails getOtherAppDetails() {
		return otherAppDetails;
	}
	
	public IndividualTraining getCdoIndividualApplication() {
		return cdoIndividualApplication;
	}

	public void setCdoIndividualApplication(IndividualTraining cdoIndividualApplication) {
		this.cdoIndividualApplication = cdoIndividualApplication;
	}
	
	public InternshipTraining getCdoInternshipApplication() {
		return cdoInternshipApplication;
	}

	public void setCdoInternshipApplication(InternshipTraining cdoInternshipApplication) {
		this.cdoInternshipApplication = cdoInternshipApplication;
	}

	public InHouseTraining getCdoInhouseApplication() {
		return cdoInhouseApplication;
	}

	public void setCdoInhouseApplication(InHouseTraining cdoInhouseApplication) {
		this.cdoInhouseApplication = cdoInhouseApplication;
	}

	public SabbaticalTraining getCdoSabbaticalApplication() {
		return cdoSabbaticalApplication;
	}

	public void setCdoSabbaticalApplication(SabbaticalTraining cdoSabbaticalApplication) {
		this.cdoSabbaticalApplication = cdoSabbaticalApplication;
	}

	public StaffDevTraining getCdoStaffDevApplication() {
		return cdoStaffDevApplication;
	}

	public void setCdoStaffDevApplication(StaffDevTraining cdoStaffDevApplication) {
		this.cdoStaffDevApplication = cdoStaffDevApplication;
	}
	
	public String[] getSelectedTypeOfSupport(){
		return selectedTypeOfSupport;
	}
	
	public String[] getSelectedFundingSource(){
		return selectedFundingSource;
	}
	
	/**
	 * @param trainingOption the user to trainingOption
	 */
	public void setTrainingOption(String trainingOption) {
		this.trainingOption = trainingOption;
	}
	
	/**
	 * @param trainingOption the user to trainingOption
	 */
	public String getTrainingOption() {
		return trainingOption;
	}
	
	public CDOApplicationAction(CDOApplicationService cdoApplicationService, AnnouncementService announcementService, ApprovalService approvalService) {
		super(cdoApplicationService);
		this.announcementService = announcementService;
		this.approvalService = approvalService;
	}
	
	@Override
	public void prepare(){
		if(this.announcementId==null && this.applicationId==null){
			super.prepare();
		}else
			if(getUser()!=null)
				this.cdoBioData = this.cdoApplicationService.findByUser(getUser());
		
		
		if(this.announcementId!=null)
			this.announcement =this.announcementService.find(this.announcementId);
		
		if(this.announcement!=null){
			if(this.announcement.getType().equals("Group")){
				if(this.applicationId!=null)
					this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoApplication = this.cdoApplicationService.findApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoApplication==null){
					this.cdoApplication = new GroupTraining();
					this.cdoApplication.setAnnouncement(this.announcement);
					this.cdoApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoApplication = this.cdoApplicationService.save(this.cdoApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.application = (GroupTraining) this.cdoApplication;
				
			}else if(this.announcement.getType().equals("Graduate")){				
				if(this.applicationId!=null && this.cdoGraduateApplication==null)
					this.cdoGraduateApplication = this.cdoApplicationService.findGraduate(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null && this.cdoGraduateApplication==null)
					this.cdoGraduateApplication = this.cdoApplicationService.findGraduateApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				
				if(this.cdoGraduateApplication==null){
					this.cdoGraduateApplication = new GraduateResearchTraining();
					this.cdoGraduateApplication.setAnnouncement(this.announcement);
					this.cdoGraduateApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoGraduateApplication = this.cdoApplicationService.save(this.cdoGraduateApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(this.cdoGraduateApplication.getSupportTypes()!=null){
					if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
						//System.out.println("selectedTypeOfSupport: " + this.selectedTypeOfSupport);
						this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
					}
					if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
						//System.out.println("selectedFundingSource: " + this.selectedFundingSource);
						this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
					}
				}
				this.application = (GraduateResearchTraining) this.cdoGraduateApplication;
				
			}else if(this.announcement.getType().equals("Internship")){
				if(this.applicationId!=null && this.cdoInternshipApplication==null)
					this.cdoInternshipApplication = this.cdoApplicationService.findInternship(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null && this.cdoInternshipApplication==null)
					this.cdoInternshipApplication = this.cdoApplicationService.findInternshipApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoInternshipApplication==null){
					this.cdoInternshipApplication = new InternshipTraining();
					this.cdoInternshipApplication.setAnnouncement(this.announcement);
					this.cdoInternshipApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoInternshipApplication = this.cdoApplicationService.save(this.cdoInternshipApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}		
				this.application = (InternshipTraining) this.cdoInternshipApplication;
			}else if(this.announcement.getType().equals("Sabbatical")){
				if(this.applicationId!=null)
					this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbatical(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbaticalApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoSabbaticalApplication==null){
					this.cdoSabbaticalApplication = new SabbaticalTraining();
					this.cdoSabbaticalApplication.setAnnouncement(this.announcement);
					this.cdoSabbaticalApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoSabbaticalApplication = this.cdoApplicationService.save(this.cdoSabbaticalApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(this.cdoSabbaticalApplication!=null){
					if(this.cdoSabbaticalApplication.getSupportTypes()!=null){
						if(this.cdoSabbaticalApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoSabbaticalApplication.getSupportTypes().getTypeOfSupport().split(", ");
						}
						if(this.cdoSabbaticalApplication.getSupportTypes().getFundingSource()!=null){
							this.selectedFundingSource = (String[]) this.cdoSabbaticalApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
				}
				this.application = (SabbaticalTraining) this.cdoSabbaticalApplication;
				
			}else if(this.announcement.getType().equals("Non-degree")){
				if(this.applicationId!=null)
					this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegree(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegreeApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoNonDegreeApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoNonDegreeApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoNonDegreeApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoNonDegreeApplication==null)
					this.cdoNonDegreeApplication = new NonDegreeTraining();
				
				this.application = (NonDegreeTraining) this.cdoNonDegreeApplication;
				
			}else if(this.announcement.getType().equals("Other")){
				if(this.otherId!=null)
					this.cdoOtherApplication = this.cdoApplicationService.findOther(this.otherId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoOtherApplication = this.cdoApplicationService.findOtherApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoOtherApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoOtherApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoOtherApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoOtherApplication==null)
					this.cdoOtherApplication = new OtherTraining();
				
				this.application = (OtherTraining) this.cdoOtherApplication;
				
			}else if(this.announcement.getType().equals("Individual")){
				if(this.individualId!=null)
					this.cdoIndividualApplication = this.cdoApplicationService.findIndividual(this.individualId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoIndividualApplication = this.cdoApplicationService.findIndividualApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoIndividualApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoIndividualApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoIndividualApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoIndividualApplication==null)
					this.cdoIndividualApplication = new IndividualTraining();
				
				this.application = (IndividualTraining) this.cdoIndividualApplication;
			}
			else if(this.announcement.getType().equals("Staff Development")){
				if(this.staffDevId!=null)
					this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDev(this.staffDevId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDevApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoStaffDevApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoStaffDevApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoStaffDevApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoStaffDevApplication==null)
					this.cdoStaffDevApplication = new StaffDevTraining();
				
				this.application = (StaffDevTraining) this.cdoStaffDevApplication;
				
			}else if(this.announcement.getType().equals("In-house Group")){
				if(this.inhouseGroupId!=null)
					this.cdoInhouseApplication = this.cdoApplicationService.findInHouse(this.inhouseGroupId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoInhouseApplication = this.cdoApplicationService.findInHouseApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoInhouseApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoInhouseApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoInhouseApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoInhouseApplication==null)
					this.cdoInhouseApplication = new InHouseTraining();
			}
			
			this.application = (InHouseTraining) this.cdoInhouseApplication;
		}else if(this.trainingOption!=null && this.announcement==null){
			this.announcement =this.announcementService.lookUp(this.trainingOption, org.iita.trainingunit.announcements.model.Announcement.STATUS.Application);
			
			if(this.announcement.getType().equals("Group")){
				if(this.applicationId!=null)
					this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoApplication = this.cdoApplicationService.findApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoApplication==null && this.cdoBioData!=null && this.announcement!=null){
					this.cdoApplication = new GroupTraining();
					this.cdoApplication.setAnnouncement(this.announcement);
					this.cdoApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoApplication = this.cdoApplicationService.save(this.cdoApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				this.application = (GroupTraining) this.cdoApplication;
				
			}else if(this.announcement.getType().equals("Graduate")){
				if(this.applicationId!=null && this.cdoGraduateApplication==null)
					this.cdoGraduateApplication = this.cdoApplicationService.findGraduate(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null && this.cdoGraduateApplication==null)
					this.cdoGraduateApplication = this.cdoApplicationService.findGraduateApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoGraduateApplication==null && this.cdoBioData!=null && this.announcement!=null){
					this.cdoGraduateApplication = new GraduateResearchTraining();
					this.cdoGraduateApplication.setAnnouncement(this.announcement);
					this.cdoGraduateApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoGraduateApplication = this.cdoApplicationService.save(this.cdoGraduateApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
				if(this.cdoGraduateApplication.getSupportTypes()!=null){
					if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
						System.out.println("selectedTypeOfSupport: " + this.selectedTypeOfSupport);
						this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
					}
					if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
						System.out.println("selectedFundingSource: " + this.selectedFundingSource);
						this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
					}
				}
				
				this.application = (GraduateResearchTraining) this.cdoGraduateApplication;
				
			}else if(this.announcement.getType().equals("Internship")){
				if(this.applicationId!=null && this.cdoInternshipApplication==null)
					this.cdoInternshipApplication = this.cdoApplicationService.findInternship(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null && this.cdoInternshipApplication==null)
					this.cdoInternshipApplication = this.cdoApplicationService.findInternshipApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoInternshipApplication==null && this.cdoBioData!=null && this.announcement!=null){
					this.cdoInternshipApplication = new InternshipTraining();
					this.cdoInternshipApplication.setAnnouncement(this.announcement);
					this.cdoInternshipApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoInternshipApplication = this.cdoApplicationService.save(this.cdoInternshipApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				this.application = (InternshipTraining) this.cdoInternshipApplication;
				
			}else if(this.announcement.getType().equals("Sabbatical")){
				if(this.sabbaticalId!=null)
					this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbatical(this.sabbaticalId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbaticalApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoSabbaticalApplication==null && this.cdoBioData!=null && this.announcement!=null){
					this.cdoSabbaticalApplication = new SabbaticalTraining();
					this.cdoSabbaticalApplication.setAnnouncement(this.announcement);
					this.cdoSabbaticalApplication.setBiodata(this.cdoBioData);
					try {
						this.cdoSabbaticalApplication = this.cdoApplicationService.save(this.cdoSabbaticalApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(this.cdoSabbaticalApplication!=null){
					if(this.cdoSabbaticalApplication.getSupportTypes()!=null){
						if(this.cdoSabbaticalApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoSabbaticalApplication.getSupportTypes().getTypeOfSupport().split(", ");
						}
						if(this.cdoSabbaticalApplication.getSupportTypes().getFundingSource()!=null){
							this.selectedFundingSource = (String[]) this.cdoSabbaticalApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
				}
				
				this.application = (SabbaticalTraining) this.cdoSabbaticalApplication;
			}else if(this.announcement.getType().equals("Non-degree")){
				if(this.applicationId!=null)
					this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegree(this.applicationId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegreeApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoNonDegreeApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoNonDegreeApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoNonDegreeApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoNonDegreeApplication==null)
					this.cdoNonDegreeApplication = new NonDegreeTraining();
				
				this.application = (NonDegreeTraining) this.cdoNonDegreeApplication;
			}else if(this.announcement.getType().equals("Other")){
				if(this.otherId!=null)
					this.cdoOtherApplication = this.cdoApplicationService.findOther(this.otherId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoOtherApplication = this.cdoApplicationService.findOtherApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoOtherApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoOtherApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoOtherApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoOtherApplication==null)
					this.cdoOtherApplication = new OtherTraining();
				
				this.application = (OtherTraining) this.cdoOtherApplication;
			}else if(this.announcement.getType().equals("Individual")){
				if(this.individualId!=null)
					this.cdoIndividualApplication = this.cdoApplicationService.findIndividual(this.individualId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoIndividualApplication = this.cdoApplicationService.findIndividualApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoIndividualApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoIndividualApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoIndividualApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoIndividualApplication==null)
					this.cdoIndividualApplication = new IndividualTraining();
				
				this.application = (IndividualTraining) this.cdoIndividualApplication;
			}
			else if(this.announcement.getType().equals("Staff Development")){
				if(this.staffDevId!=null)
					this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDev(this.staffDevId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDevApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoStaffDevApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoStaffDevApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoStaffDevApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoStaffDevApplication==null)
					this.cdoStaffDevApplication = new StaffDevTraining();
				
				this.application = (StaffDevTraining) this.cdoStaffDevApplication;
			}else if(this.announcement.getType().equals("In-house Group")){
				if(this.inhouseGroupId!=null)
					this.cdoInhouseApplication = this.cdoApplicationService.findInHouse(this.inhouseGroupId);
				else if(this.cdoBioData!=null && this.announcement!=null)
					this.cdoInhouseApplication = this.cdoApplicationService.findInHouseApplication(this.announcement,this.cdoBioData, SUBMISSIONSTATUS.Draft);
				
				if(this.cdoInhouseApplication!=null){
						this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.cdoInhouseApplication);
						
						//for(ApplicantTrainingLocation apploc : this.cdoInhouseApplication.getLocations()){
						//	selectedLocations.add(apploc.getTrainingLocation().getId());
						//}
				}else if(this.otherAppDetailsId!=null)
					this.otherAppDetails = this.cdoApplicationService.findOtherAppDetails(this.otherAppDetailsId);	
				
				if(this.cdoInhouseApplication==null)
					this.cdoInhouseApplication = new InHouseTraining();
				
				this.application = (InHouseTraining) this.cdoInhouseApplication;
			}
		}

		if(this.cdoBioData!=null)
			if(this.cdoBioData.getApplication().size()<=0)
				this.appStarter = this.cdoApplicationService.findAppStarterByKey(this.cdoBioData);
		
	}
	
	@Override
	public String execute() {
		super.execute();
		return Action.SUCCESS;
	}
		
	public String proceedRegister(){			
		if(this.announcement!=null){
			if(this.announcement!=null){
				if(this.announcement.getType().equals("Group"))
					return "group";
				else if(this.announcement.getType().equals("Graduate"))
					return "graduate";
				else if(this.announcement.getType().equals("Internship"))
					return "internship";
				else if(this.announcement.getType().equals("Non-degree"))
					return "nongraduate";
				else if(this.announcement.getType().equals("Individual"))
					return "individual";
				else if(this.announcement.getType().equals("In-house Group"))
					return "inhousegroup";
				else if(this.announcement.getType().equals("Staff Development"))
					return "staffdevelopment";
				else if(this.announcement.getType().equals("Sabbatical"))
					return "sabbatical";
				else if(this.announcement.getType().equals("Other"))
					return "other";
			}
			return Action.INPUT;
		}else if(this.announcementId!=null){
			this.announcement =this.announcementService.find(this.announcementId);
			if(this.announcement!=null){
				if(this.announcement.getType().equals("Group"))
					return "group";
				else if(this.announcement.getType().equals("Graduate"))
					return "graduate";
				else if(this.announcement.getType().equals("Internship"))
					return "internship";
				else if(this.announcement.getType().equals("Non-degree"))
					return "nongraduate";
				else if(this.announcement.getType().equals("Individual"))
					return "individual";
				else if(this.announcement.getType().equals("In-house Group"))
					return "inhousegroup";
				else if(this.announcement.getType().equals("Staff Development"))
					return "staffdevelopment";
				else if(this.announcement.getType().equals("Sabbatical"))
					return "sabbatical";
				else if(this.announcement.getType().equals("Other"))
					return "other";
			}
			return Action.INPUT;
		}else if(this.applicationId!=null){
			this.application = this.cdoApplicationService.findApplication(this.applicationId);
			
			if(this.application!=null)
				this.announcement = this.application.getAnnouncement();
			
			if(this.announcement!=null){
				if(this.announcement.getType().equals("Group"))
					return "group";
				else if(this.announcement.getType().equals("Graduate"))
					return "graduate";
				else if(this.announcement.getType().equals("Internship"))
					return "internship";
				else if(this.announcement.getType().equals("Non-degree"))
					return "nongraduate";
				else if(this.announcement.getType().equals("Individual"))
					return "individual";
				else if(this.announcement.getType().equals("In-house Group"))
					return "inhousegroup";
				else if(this.announcement.getType().equals("Staff Development"))
					return "staffdevelopment";
				else if(this.announcement.getType().equals("Sabbatical"))
					return "sabbatical";
				else if(this.announcement.getType().equals("Other"))
					return "other";
			}
			return Action.INPUT;
		}else{
			addActionError("Error occurred! There is no announcement selected for this process. Select an announcement to proceed");
			return Action.ERROR;
		}
	}
	
	public String doRegister(){
		try{
			if(this.announcement!=null){
				if(this.cdoApplication!=null){
					if(this.cdoApplication.getSubmissionStatus()!=null){
						if(this.cdoApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){
					if(this.cdoApplication==null)
						this.cdoApplication = new GroupTraining();
					
					this.cdoApplication.setAnnouncement(this.announcement);
					
					this.cdoApplication.setSubmissionStatus(SUBMISSIONSTATUS.Submitted);
					Date date = new Date();
					this.cdoApplication.setSignedOn(date);
					this.cdoApplication.setStatus(APPLICATIONSTATUS.WAITING);

					this.cdoApplication.setBiodata(this.cdoBioData);
						
					//Saving application
					try {
						this.cdoApplication = this.cdoApplicationService.save(this.cdoApplication);//, this.selectedLocations
						//Check and complete appStarter if exists
						if(this.appStarter!=null){
							if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
								this.appStarter.setStatus(STATUS.COMPLETED);
								this.cdoApplicationService.save(this.appStarter);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(this.cdoApplication!=null){
					addActionMessage("Application submitted successfully!");
				}else{
					addActionError("Error saving CDO application! Application is empty.");
				}
				
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	public String doDraft(){
		try{
			if(this.announcement!=null){
				if(this.cdoApplication!=null){
					if(this.cdoApplication.getSubmissionStatus()!=null){
						if(this.cdoApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){
					
					this.cdoApplication.setAnnouncement(this.announcement);
					
					this.cdoApplication.setSubmissionStatus(SUBMISSIONSTATUS.Draft);
					//this.cdoApplication.setBiodata(this.cdoBioData);
						
					//Saving application
					try {
						this.cdoApplication = this.cdoApplicationService.save(this.cdoApplication);//, this.selectedLocations
						
						//Check and complete appStarter if exists
						if(this.appStarter!=null){
							if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
								this.appStarter.setStatus(STATUS.COMPLETED);
								this.cdoApplicationService.save(this.appStarter);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Check if other app details were not null
				if(this.cdoApplication!=null){				
					//Check and complete appStarter if exists
					if(this.appStarter!=null){
						this.appStarter.setStatus(STATUS.COMPLETED);
						this.cdoApplicationService.save(this.appStarter);
					}
				}
					
				if(this.cdoApplication!=null){
					addActionMessage("Application saved successfully! Yet to be submitted for consideration.");
				}else{
					addActionError("Error saving CDO application! Application is empty.");
				}
				
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	/*@Validations(requiredStrings = { 
			@RequiredStringValidator(fieldName = "cdoGraduateApplication.presentUniversity", trim=true, message = "Enter your present university"),
			@RequiredStringValidator(fieldName = "cdoGraduateApplication.proposedResearchTheme", trim=true, message = "Enter proposed research theme"),
			@RequiredStringValidator(fieldName = "cdoGraduateApplication.nameOfUniversitySupervisor", trim=true, message = "Enter name of your university supervisor"),
			@RequiredStringValidator(fieldName = "cdoGraduateApplication.emailOfUniversitySupervisor", trim=true, message = "Enter email of your university supervisor"),
			@RequiredStringValidator(fieldName = "cdoGraduateApplication.nameOfIITASupervisor", trim=true, message = "Enter name of your IITA Supervisor")},
			requiredFields = { @RequiredFieldValidator(fieldName = "cdoGraduateApplication.trainingType", message = "Select training type"), 
			@RequiredFieldValidator(fieldName = "cdoGraduateApplication.degree", message = "Select your degree"), 
			@RequiredFieldValidator(fieldName = "cdoGraduateApplication.degreeSought", message = "Select the degree sought for"), 
			@RequiredFieldValidator(fieldName = "cdoGraduateApplication.typeOfSupport", message = "Select type of support"), 
			@RequiredFieldValidator(fieldName = "cdoGraduateApplication.fundingSource", message = "Select your source of funding")})*/
	public String doGraduateRegister(){
		try{
			if(this.announcement!=null){
				if(this.cdoGraduateApplication!=null){
					if(this.cdoGraduateApplication.getSubmissionStatus()!=null){
						if(this.cdoGraduateApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){
					if(this.cdoGraduateApplication==null)
						this.cdoGraduateApplication = new GraduateResearchTraining();
					
					this.cdoGraduateApplication.setAnnouncement(this.announcement);
					
					this.cdoGraduateApplication.setSubmissionStatus(SUBMISSIONSTATUS.Submitted);
					
					Date date = new Date();
					
					this.cdoGraduateApplication.setSignedOn(date);
					
					this.cdoGraduateApplication.setStatus(APPLICATIONSTATUS.PENDING);
					
					this.cdoGraduateApplication.setBiodata(this.cdoBioData);
					
					//Saving application
					try {
						this.cdoGraduateApplication = this.cdoApplicationService.save(this.cdoGraduateApplication);//, this.selectedLocations
						//Check and complete appStarter if exists
						if(this.appStarter!=null){
							if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
								this.appStarter.setStatus(STATUS.COMPLETED);
								this.cdoApplicationService.save(this.appStarter);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				if(this.cdoGraduateApplication!=null && this.cdoGraduateApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
					addActionMessage("Application submitted successfully!");
					return "submitted";
				}else if(this.cdoGraduateApplication!=null && this.cdoGraduateApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Draft)){
						addActionMessage("Application saved successfully!");
				}else{
					addActionError("Error saving CDO application! Try again.");
				}
				
				if(this.cdoGraduateApplication!=null){
					if(this.cdoGraduateApplication!=null){
						if(this.cdoGraduateApplication.getSupportTypes()!=null){
							if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
								this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
							}
							if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
								this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
							}
						}
					}
				}
				
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				if(this.cdoGraduateApplication!=null){
					if(this.cdoGraduateApplication.getSupportTypes()!=null){
						if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
						}
						if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
							this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
				}
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			if(this.cdoGraduateApplication!=null){
				if(this.cdoGraduateApplication.getSupportTypes()!=null){
					if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
						this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
					}
					if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
						this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
					}
				}
			}	
			return Action.ERROR;
		}
	}
	
	public String doGraduateDraft(){
		try{
			if(this.announcement!=null){
				if(this.cdoGraduateApplication!=null){
					if(this.cdoGraduateApplication.getSubmissionStatus()!=null){
						if(this.cdoGraduateApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){					
					this.cdoGraduateApplication.setAnnouncement(this.announcement);
					
					this.cdoGraduateApplication.setSubmissionStatus(SUBMISSIONSTATUS.Draft);
					this.cdoGraduateApplication.setBiodata(this.cdoBioData);
						
					//Saving application
					try {
						this.cdoGraduateApplication = this.cdoApplicationService.save(this.cdoGraduateApplication);//, this.selectedLocations
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Check if other app details were not null
				if(this.cdoGraduateApplication!=null){
					//Check and complete appStarter if exists
					if(this.appStarter!=null){
						if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
							this.appStarter.setStatus(STATUS.COMPLETED);
							this.cdoApplicationService.save(this.appStarter);
						}
					}
				}
				
				if(this.cdoGraduateApplication.getSupportTypes()!=null){
					if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
						this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
					}
					if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
						this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
					}
				}
					
				if(this.cdoGraduateApplication!=null){
					if(this.cdoGraduateApplication.getSupportTypes()!=null){
						if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
						}
						if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
							this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
					
					addActionMessage("Application saved successfully! Yet to be submitted for consideration.");
				}else{
					addActionError("Error saving CDO application! Application is empty.");
				}
				
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				if(this.cdoGraduateApplication!=null){
					if(this.cdoGraduateApplication.getSupportTypes()!=null){
						if(this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoGraduateApplication.getSupportTypes().getTypeOfSupport().split(", ");
						}
						if(this.cdoGraduateApplication.getSupportTypes().getFundingSource()!=null){
							this.selectedFundingSource = (String[]) this.cdoGraduateApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
				}
				
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	public String doInternshipRegister(){
		try{
			if(this.announcement!=null){
				if(this.cdoInternshipApplication!=null){
					if(this.cdoInternshipApplication.getSubmissionStatus()!=null){
						if(this.cdoInternshipApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){
					if(this.cdoInternshipApplication==null)
						this.cdoInternshipApplication = new InternshipTraining();
					
					this.cdoInternshipApplication.setAnnouncement(this.announcement);
					
					this.cdoInternshipApplication.setSubmissionStatus(SUBMISSIONSTATUS.Submitted);
					Date date = new Date();
					this.cdoInternshipApplication.setSignedOn(date);
					this.cdoInternshipApplication.setStatus(APPLICATIONSTATUS.PENDING);

					this.cdoInternshipApplication.setBiodata(this.cdoBioData);
						
					//Saving application
					try {
						this.cdoInternshipApplication = this.cdoApplicationService.save(this.cdoInternshipApplication);//, this.selectedLocations
						
						//Check and complete appStarter if exists
						if(this.appStarter!=null){
							if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
								this.appStarter.setStatus(STATUS.COMPLETED);
								this.cdoApplicationService.save(this.appStarter);
							}
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				if(this.cdoInternshipApplication!=null && this.cdoInternshipApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
					addActionMessage("Application submitted successfully!");
					return "submitted";
				}else if(this.cdoInternshipApplication!=null && this.cdoInternshipApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Draft)){
						addActionMessage("Application saved successfully!");
				}else{
					addActionError("Error saving CDO application! Try again.");
				}
				
				if(this.cdoInternshipApplication!=null){
					if(this.cdoInternshipApplication.getSupportTypes()!=null){
						if(this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport().split(", ");
							this.selectedFundingSource = (String[]) this.cdoInternshipApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
				}
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				if(this.cdoInternshipApplication!=null){
					if(this.cdoInternshipApplication.getSupportTypes()!=null){
						if(this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport().split(", ");
							this.selectedFundingSource = (String[]) this.cdoInternshipApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
				}
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			if(this.cdoInternshipApplication!=null){
				if(this.cdoInternshipApplication.getSupportTypes()!=null){
					if(this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport()!=null){
						this.selectedTypeOfSupport = (String[]) this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport().split(", ");
						this.selectedFundingSource = (String[]) this.cdoInternshipApplication.getSupportTypes().getFundingSource().split(", ");
					}
				}
			}
			return Action.ERROR;
		}
	}
	
	public String doInternshipDraft(){
		if(this.announcement!=null){
			if(this.cdoInternshipApplication!=null){
				if(this.cdoInternshipApplication.getSubmissionStatus()!=null){
					if(this.cdoInternshipApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
						addActionError("Double registration error! Your application already submitted for this training.");
						return Action.ERROR;
					}
				}
			}
			
			if(this.cdoBioData!=null && this.announcement!=null){					
				this.cdoInternshipApplication.setAnnouncement(this.announcement);
				
				this.cdoInternshipApplication.setSubmissionStatus(SUBMISSIONSTATUS.Draft);
				this.cdoInternshipApplication.setBiodata(this.cdoBioData);
					
				//Saving application
				try {
					System.out.println("this.cdoInternshipApplication: " + this.cdoInternshipApplication);
					this.cdoInternshipApplication = this.cdoApplicationService.save(this.cdoInternshipApplication);//, this.selectedLocations
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			//Check if other app details were not null
			if(this.cdoInternshipApplication!=null){
				//Check and complete appStarter if exists
				if(this.appStarter!=null){
					if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
						this.appStarter.setStatus(STATUS.COMPLETED);
						this.cdoApplicationService.save(this.appStarter);
					}
				}
			}
				
			if(this.cdoInternshipApplication!=null){
				addActionMessage("Application saved successfully! Yet to be submitted for consideration.");
			}else{
				addActionError("Error saving CDO application! Application is empty.");
			}
			
			if(this.cdoInternshipApplication!=null){
				if(this.cdoInternshipApplication.getSupportTypes()!=null){
					if(this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport()!=null){
						this.selectedTypeOfSupport = (String[]) this.cdoInternshipApplication.getSupportTypes().getTypeOfSupport().split(", ");
						this.selectedFundingSource = (String[]) this.cdoInternshipApplication.getSupportTypes().getFundingSource().split(", ");
					}
				}
			}
			
			return Action.SUCCESS;
		}else{
			addActionError("Error saving CDO application! Application is empty.");
			return Action.ERROR;
		}
	}
	
	//@Validations(requiredStrings = { 
	//		@RequiredStringValidator(fieldName = "cdoIndividualApplication.presentUniversity", trim=true, message = "Enter your present university"),
	//		@RequiredStringValidator(fieldName = "cdoIndividualApplication.proposedResearchTheme", trim=true, message = "Enter proposed research theme"),
	//		@RequiredStringValidator(fieldName = "cdoIndividualApplication.nameOfUniversitySupervisor", trim=true, message = "Enter name of your university supervisor"),
	//		@RequiredStringValidator(fieldName = "cdoIndividualApplication.emailOfUniversitySupervisor", trim=true, message = "Enter email of your university supervisor"),
	//		@RequiredStringValidator(fieldName = "cdoIndividualApplication.nameOfIITASupervisor", trim=true, message = "Enter name of your IITA Supervisor")},
	//		requiredFields = { @RequiredFieldValidator(fieldName = "cdoIndividualApplication.trainingType", message = "Select training type"), 
	//		@RequiredFieldValidator(fieldName = "cdoIndividualApplication.degree", message = "Select your degree"), 
	//		@RequiredFieldValidator(fieldName = "cdoIndividualApplication.degreeSought", message = "Select the degree sought for"), 
	//		@RequiredFieldValidator(fieldName = "cdoIndividualApplication.typeOfSupport", message = "Select type of support"), 
	//		@RequiredFieldValidator(fieldName = "cdoIndividualApplication.fundingSource", message = "Select your source of funding")})
	public String doSabbaticalRegister(){
		try{
			if(this.announcement!=null){
				if(this.cdoSabbaticalApplication!=null){
					if(this.cdoSabbaticalApplication.getSubmissionStatus()!=null){
						if(this.cdoSabbaticalApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){
					if(this.cdoSabbaticalApplication==null)
						this.cdoSabbaticalApplication = new SabbaticalTraining();
					
					this.cdoSabbaticalApplication.setAnnouncement(this.announcement);
					
					this.cdoSabbaticalApplication.setSubmissionStatus(SUBMISSIONSTATUS.Submitted);
					Date date = new Date();
					this.cdoSabbaticalApplication.setSignedOn(date);
					this.cdoSabbaticalApplication.setStatus(APPLICATIONSTATUS.PENDING);
					//if(this.cdoSabbaticalApplication.getAnnouncement().getRequester()!=null)
					//	this.cdoSabbaticalApplication.setStatus(APPLICATIONSTATUS.WAITING);
					//else if(this.cdoSabbaticalApplication.getAnnouncement().getProgramDirector()!=null)
					//	this.cdoSabbaticalApplication.setStatus(APPLICATIONSTATUS.WAITINGFORDIRECTOR);
					//else 
					//	this.cdoSabbaticalApplication.setStatus(APPLICATIONSTATUS.WAITINGFORCDO);
					
					this.cdoSabbaticalApplication.setBiodata(this.cdoBioData);
						
					//Saving application
					try {
						this.cdoSabbaticalApplication = this.cdoApplicationService.save(this.cdoSabbaticalApplication);
						
						//Check and complete appStarter if exists
						if(this.appStarter!=null){
							if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
								this.appStarter.setStatus(STATUS.COMPLETED);
								this.cdoApplicationService.save(this.appStarter);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(this.cdoSabbaticalApplication.getStatus().equals(APPLICATIONSTATUS.WAITING) || this.cdoSabbaticalApplication.getStatus().equals(APPLICATIONSTATUS.WAITINGFORDIRECTOR) || 
							this.cdoSabbaticalApplication.getStatus().equals(APPLICATIONSTATUS.WAITINGFORCDO)){
						try {
							this.approvalService.approve(this.cdoSabbaticalApplication, this.getUser(), null);
						} catch (ApprovalException e) {
							addActionError(e.getMessage());
							return Action.ERROR;
						}
					}
				}
					
				if(this.cdoSabbaticalApplication!=null){
					addActionMessage("Application submitted successfully!");
				}else{
					addActionError("Error saving CDO application! Application is empty.");
				}
				
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	public String doSabbaticalDraft(){
		try{
			if(this.announcement!=null){
				if(this.cdoSabbaticalApplication!=null){
					if(this.cdoSabbaticalApplication.getSubmissionStatus()!=null){
						if(this.cdoSabbaticalApplication.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
							addActionError("Double registration error! Your application already submitted for this training.");
							return Action.ERROR;
						}
					}
				}
				
				if(this.cdoBioData!=null && this.announcement!=null){
					if(this.cdoSabbaticalApplication==null)
						this.cdoSabbaticalApplication = new SabbaticalTraining();
					
					this.cdoSabbaticalApplication.setAnnouncement(this.announcement);
					
					this.cdoSabbaticalApplication.setSubmissionStatus(SUBMISSIONSTATUS.Draft);
					this.cdoSabbaticalApplication.setBiodata(this.cdoBioData);
						
					//Saving application
					try {
						this.cdoSabbaticalApplication = this.cdoApplicationService.save(this.cdoSabbaticalApplication);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Check if other app details were not null
				if(this.cdoSabbaticalApplication!=null){				
					//Check and complete appStarter if exists
					if(this.appStarter!=null){
						if(this.appStarter.getStatus().equals(STATUS.INPROGRESS)){
							this.appStarter.setStatus(STATUS.COMPLETED);
							this.cdoApplicationService.save(this.appStarter);
						}
					}
				}
					
				if(this.cdoSabbaticalApplication!=null){
					if(this.cdoSabbaticalApplication.getSupportTypes()!=null){
						if(this.cdoSabbaticalApplication.getSupportTypes().getTypeOfSupport()!=null){
							this.selectedTypeOfSupport = (String[]) this.cdoSabbaticalApplication.getSupportTypes().getTypeOfSupport().split(", ");
						}
						if(this.cdoSabbaticalApplication.getSupportTypes().getFundingSource()!=null){
							this.selectedFundingSource = (String[]) this.cdoSabbaticalApplication.getSupportTypes().getFundingSource().split(", ");
						}
					}
					addActionMessage("Application saved successfully! Yet to be submitted for consideration.");
				}else{
					addActionError("Error saving CDO application! Application is empty.");
				}
				
				return Action.SUCCESS;
			}else{
				addActionError("Error saving CDO application! Application is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String delete() {
		if (this.cdoApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String deleteGraduate() {
		if (this.cdoGraduateApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoGraduateApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	 
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String deleteNonDegree() {
		if (this.cdoNonDegreeApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoNonDegreeApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String deleteInhouse() {
		if (this.cdoInhouseApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoInhouseApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String deleteSabbatical() {
		if (this.cdoSabbaticalApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoSabbaticalApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String deleteIndividual() {
		if (this.cdoIndividualApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoIndividualApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	/**
	 * Delete Application action.
	 * 
	 * @return
	 */
	public String deleteStaffDev() {
		if (this.cdoStaffDevApplication == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoStaffDevApplication);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	public String applicationDetails(){
		String action = Action.SUCCESS;
		
		if(Authorize.hasAny("ROLE_APPLICATION,ROLE_ADMIN,ROLE_CRM,ROLE_REGISTRATION,ROLE_TRAININGUNITHEAD")){
			if(this.applicationId!=null)
				this.application = this.cdoApplicationService.findApplication(this.applicationId);
			
			if(this.application instanceof GroupTraining){
				this.application = (GroupTraining) this.application;
				this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
				action = "group";
			}else if(this.application instanceof GraduateResearchTraining){
				this.application = (GraduateResearchTraining) this.application;
				this.cdoGraduateApplication = this.cdoApplicationService.findGraduate(this.applicationId);
				action = "graduate";
			}else if(this.application instanceof InternshipTraining){
				this.application = (InternshipTraining) this.application;
				this.cdoInternshipApplication = this.cdoApplicationService.findInternship(this.applicationId);
				action = "internship";
			}else if(this.application instanceof SabbaticalTraining){
				this.application = (SabbaticalTraining) this.application;
				this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbatical(this.applicationId);
				action = "sabbatical";
			}else if(this.application instanceof NonDegreeTraining){
				this.application = (NonDegreeTraining) this.application;
				this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegree(this.applicationId);
				action = "nondegree";
			}else if(this.application instanceof InHouseTraining){
				this.application = (InHouseTraining) this.application;
				this.cdoInhouseApplication = this.cdoApplicationService.findInHouse(this.applicationId);
				action = "inhousegroup";
			}else if(this.application instanceof OtherTraining){
				this.application = (OtherTraining) this.application;
				this.cdoOtherApplication = this.cdoApplicationService.findOther(this.applicationId);
				action = "other";
			}else if(this.application instanceof IndividualTraining){
				this.application = (IndividualTraining) this.application;
				this.cdoIndividualApplication = this.cdoApplicationService.findIndividual(this.applicationId);
				action = "individual";
			}else if(this.application instanceof StaffDevTraining){
				this.application = (StaffDevTraining) this.application;
				this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDev(this.applicationId);
				action = "staffdevelopment";
			}
			/*if(this.applicationId!=null){
				this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
				action = "group";
			}else if(this.graduateId!=null){
				this.cdoGraduateApplication = this.cdoApplicationService.findGraduate(this.graduateId);
				action = "graduate";
			}else if(this.internshipId!=null){
				this.cdoInternshipApplication = this.cdoApplicationService.findInternship(this.internshipId);
				action = "internship";
			}else if(this.nondegreeId!=null){
				this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegree(this.nondegreeId);
				action = "nondegree";
			}else if(this.inhouseGroupId!=null){
				this.cdoInhouseApplication = this.cdoApplicationService.findInHouse(this.inhouseGroupId);
				action = "inhousegroup";
			}else if(this.otherId!=null){
				this.cdoOtherApplication = this.cdoApplicationService.findOther(this.otherId);
				action = "other";
			}else if(this.individualId!=null){
				this.cdoIndividualApplication = this.cdoApplicationService.findIndividual(this.individualId);
				action = "individual";
			}else if(this.staffDevId!=null){
				this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDev(this.staffDevId);
				action = "staffdevelopment";
			}else if(this.sabbaticalId!=null){
				this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbatical(this.sabbaticalId);
				action = "sabbatical";
			}*/
		}
		
		if(getCdoBioData()!=null){
			if(this.applicationId!=null)
				this.application = this.cdoApplicationService.findApplication(this.applicationId);
			
			if(this.application instanceof GroupTraining){
				this.application = (GroupTraining) this.application;
				this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
				action = "group";
			}else if(this.application instanceof GraduateResearchTraining){
				this.application = (GraduateResearchTraining) this.application;
				this.cdoGraduateApplication = this.cdoApplicationService.findGraduate(this.applicationId);
				action = "graduate";
			}else if(this.application instanceof InternshipTraining){
				this.application = (InternshipTraining) this.application;
				this.cdoInternshipApplication = this.cdoApplicationService.findInternship(this.applicationId);
				action = "internship";
			}else if(this.application instanceof SabbaticalTraining){
				this.application = (SabbaticalTraining) this.application;
				this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbatical(this.applicationId);
				action = "sabbatical";
			}else if(this.application instanceof NonDegreeTraining){
				this.application = (NonDegreeTraining) this.application;
				this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegree(this.applicationId);
				action = "nondegree";
			}else if(this.application instanceof InHouseTraining){
				this.application = (InHouseTraining) this.application;
				this.cdoInhouseApplication = this.cdoApplicationService.findInHouse(this.applicationId);
				action = "inhousegroup";
			}else if(this.application instanceof OtherTraining){
				this.application = (OtherTraining) this.application;
				this.cdoOtherApplication = this.cdoApplicationService.findOther(this.applicationId);
				action = "other";
			}else if(this.application instanceof IndividualTraining){
				this.application = (IndividualTraining) this.application;
				this.cdoIndividualApplication = this.cdoApplicationService.findIndividual(this.applicationId);
				action = "individual";
			}else if(this.application instanceof StaffDevTraining){
				this.application = (StaffDevTraining) this.application;
				this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDev(this.applicationId);
				action = "staffdevelopment";
			}
			/*if(this.applicationId!=null){
				this.cdoApplication = this.cdoApplicationService.find(this.applicationId);
				action = "group";
			}else if(this.graduateId!=null){
				this.cdoGraduateApplication = this.cdoApplicationService.findGraduate(this.graduateId);
				action = "graduate";
			}else if(this.internshipId!=null){
				this.cdoInternshipApplication = this.cdoApplicationService.findInternship(this.internshipId);
				action = "internship";
			}else if(this.nondegreeId!=null){
				this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegree(this.nondegreeId);
				action = "nondegree";
			}else if(this.otherId!=null){
				this.cdoOtherApplication = this.cdoApplicationService.findOther(this.otherId);
				action = "other";
			}else if(this.individualId!=null){
				this.cdoIndividualApplication = this.cdoApplicationService.findIndividual(this.individualId);
				action = "individual";
			}else if(this.staffDevId!=null){
				this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDev(this.staffDevId);
				action = "staffdevelopment";
			}else if(this.sabbaticalId!=null){
				this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbatical(this.sabbaticalId);
				action = "sabbatical";
			}else if(this.inhouseGroupId!=null){
				this.cdoInhouseApplication = this.cdoApplicationService.findInHouse(this.inhouseGroupId);
				action = "inhousegroup";
			}*/
		}
		
		return action;
	}
	
	public String applicationList() {
		this.paged = this.cdoApplicationService.list(announcementId,startAt,maxResults);
		
		return Action.SUCCESS;
	}

	/**
	 * @param selectedLocations the selectedLocations to set
	 */
	public void setSelectedLocations(List<Long> selectedLocations) {
		this.selectedLocations = selectedLocations;
	}

	/**
	 * @return the selectedLocations
	 */
	public List<Long> getSelectedLocations() {
		return selectedLocations;
	}
}
