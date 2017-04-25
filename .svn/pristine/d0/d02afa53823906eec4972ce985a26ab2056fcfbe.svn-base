/**
 * 
 */
package org.iita.trainingunit.applications.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.iita.security.model.User;
import org.iita.security.model.User.AuthenticationType;
import org.iita.security.model.UserLookup;
import org.iita.security.model.UserRole;
import org.iita.security.model.UserStatus;
import org.iita.security.service.UserLookupService;
import org.iita.security.service.UserRoleService;
import org.iita.struts.FileUploadAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application.SUBMISSIONSTATUS;
import org.iita.trainingunit.applications.model.ApplicationStarter;
import org.iita.trainingunit.applications.model.ApplicationStarter.STATUS;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InHouseTraining;
import org.iita.trainingunit.applications.model.IndividualTraining;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.NonDegreeTraining;
import org.iita.trainingunit.applications.model.OtherTraining;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.model.StaffDevTraining;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.util.StringUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * @author ken
 *
 */
@SuppressWarnings("serial")
public class CDOBiodataProcessAction extends BaseBIOAction implements Preparable, FileUploadAction {//
	private AnnouncementService announcementService;
	private String passportStorage;
	private String applicationUrl;
	private Long announcementId;
	private Long appStarterId;
	private Announcement announcement;
	private ApplicationStarter appStarter;
	private String staffId;
	private String appKey;
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	final java.util.Random rand = new java.util.Random();
	final Set<String> identifiers = new HashSet<String>();
	//private GraduateResearchTraining cdoGraduateApplication;
	private Application application;
	
	private GroupTraining cdoApplication;
	private GraduateResearchTraining cdoGraduateApplication;
	private NonDegreeTraining cdoNonDegreeApplication;
	private OtherTraining cdoOtherApplication;
	
	private IndividualTraining cdoIndividualApplication;
	private InHouseTraining cdoInhouseApplication;
	private SabbaticalTraining cdoSabbaticalApplication;
	private StaffDevTraining cdoStaffDevApplication;
	
	private InternshipTraining cdoInternshipApplication;

	private List<File> uploads;
	private List<String> uploadFileNames;

	private String email;
	private Long bioId;
	
	private String[] selectedTypeOfSupport;
	private String[] selectedFundingSource;
	
	private String trainingOption;

	//USER
	private UserLookupService lookupService;
	private UserRoleService roleService;
	/** Model object to be accessed on top of the Value Stack */
	private User user;
	private String userPassword;
	/** Model object to be accessed on top of the Value Stack */
	private List<String> roles = new ArrayList<String>();
	/** Model object to be accessed on top of the Value Stack */
	private List<String> lookups = new ArrayList<String>();
	private boolean userExists = false;

	/**
	 * @param lookupService the lookupService to set
	 */
	public void setLookupService(UserLookupService lookupService) {
		this.lookupService = lookupService;
	}

	/**
	 * @return the lookupService
	 */
	public UserLookupService getLookupService() {
		return lookupService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(UserRoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @return the roleService
	 */
	public UserRoleService getRoleService() {
		return roleService;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param role the role to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/**
	 * @param lookup the lookup to set
	 */
	public void setLookups(List<String> lookups) {
		this.lookups = lookups;
	}

	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public Application getApplication() {
		return application;
	}

	/**
	 * @param staffId the user to staffId
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * @param staffId the user to staffId
	 */
	public String getStaffId() {
		return staffId;
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
	
	/**
	 * @param appKey the user to appKey
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	
	/**
	 * @param appKey the user to appKey
	 */
	public String getAppKey() {
		return appKey;
	}
	
	/**
	 * @param email the user to email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @param email the user to email
	 */
	public String getEmail() {
		return email;
	}
	
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	public String getApplicationUrl() {
		return applicationUrl;
	}

	/**
	 * @return the announcementId
	 */
	public Long getAnnouncementId() {
		return announcementId;
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

	//public void setAnnouncement(Announcement announcement) {
	//	this.announcement = announcement;
	//}
	private String distinctName() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++)
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			if (identifiers.contains(builder.toString()))
				builder = new StringBuilder();
		}
		return builder.toString() + StringUtil.getRandomAlphaNumericString(5);
	}
	
	private String getExtension(final String filename) {
		  if (filename == null) return null;
		  final String afterLastSlash = filename.substring(filename.lastIndexOf('/') + 1);
		  final int _slash = afterLastSlash.lastIndexOf('\\') + 1;
		  final int _index = afterLastSlash.indexOf('.', _slash);
		  return (_index == -1) ? "" : afterLastSlash.substring(_index + 1);
	}
	
	private String thePath(){
		String[] bits = this.applicationUrl.split("/");						
		return "/" + bits[bits.length-1] + "/WebContent/passports/";
	}
	

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}

	public boolean isUserExists() {
		return userExists;
	}

	public CDOBiodataProcessAction(CDOApplicationService cdoApplicationService, AnnouncementService announcementService) {
		super(cdoApplicationService);
		this.announcementService = announcementService;
	}

	@Override
	public void prepare(){
		super.prepare();
		if(this.announcementId!=null)
			this.announcement =this.announcementService.find(this.announcementId);

		if(this.appStarterId!=null)
			this.appStarter = this.cdoApplicationService.findAppStarter(this.appStarterId);
		
		if(this.trainingOption!=null && this.announcement==null){
			//System.out.println("PREPARED METHOD - ANNOUNCEMENT LOOKUP ACTION");
			this.announcement =this.announcementService.lookUp(this.trainingOption, org.iita.trainingunit.announcements.model.Announcement.STATUS.Application);
			//System.out.println("PREPARED METHOD - CHECK ANNOUNCEMENT: " + this.announcement);
		}
		if (getCdoBioData() == null)
			createBlankBIO();
	}

	@Override
	public String execute() {
		return super.execute();
	}

	private boolean isValidEmailAddress(String email) {
	   java.util.regex.Pattern p = java.util.regex.Pattern.compile(".+@.+\\.[a-z]+");
	   java.util.regex.Matcher m = p.matcher(email);
	   return m.matches();
	}

	public String proceedRegister(){
		if(this.announcementId!=null){
			this.announcement =this.announcementService.find(this.announcementId);

			return Action.INPUT;
		}else if(this.trainingOption!=null && !this.trainingOption.isEmpty()){
			this.announcement = null;
			return Action.INPUT;
		}else if((this.trainingOption!=null && this.trainingOption.isEmpty()) || (this.trainingOption==null)){
			addActionError("Error occurred! Select a training type to proceed");
			return "errorGoBack";
		}else{
			addActionError("Error occurred! There is no announcement selected for this process. Select an announcement to proceed");
			return Action.ERROR;
		}
	}
	
	public String staffRegistration(){
		if(this.staffId!=null)
			this.cdoBioData = this.cdoApplicationService.findStaff(this.staffId,this.email);
		
		if(this.cdoBioData!=null){
			//if(this.cdoBioData.getOwner()!=null){
			this.user = this.cdoBioData.getOwner();
			
			//checkRoles();// this ensures that 'false' value is removed from roles should no role is checked in the view checkboxes
			
			this.roles.add("ROLE_APPLICANT");
			this.roles.add("ROLE_STAFF");
			addLookups();
			addRoles();
			this.user = this.cdoApplicationService.save(this.user);
			
			if(this.appStarterId==null){
				if(this.cdoBioData!=null && this.announcement!=null){
					ApplicationStarter appStarter = new ApplicationStarter();
					appStarter.setBiodata(this.cdoBioData);
					appStarter.setAnnouncement(this.announcement);
					appStarter.setAppKey(StringUtil.getRandomAlphaNumericString(10).toUpperCase());
					appStarter.setEmail(this.cdoBioData.getCorrespondenceEmailAddress());
					this.appStarter = this.cdoApplicationService.save(appStarter);
				}
			}
			
			if(this.cdoBioData!=null && this.user!=null){
				addActionMessage("Personal information successfully saved! Proceed to registration if you are done with your editing.");
				addActionMessage("Your Application Key is: " + this.appStarter.getAppKey() + ".");
				addActionMessage("This key in combination with your email will enable you continue with editing of your bio-data until you complete your registration. Please keep it safe if you would need it.");
				return Action.SUCCESS;
			}else if(this.cdoBioData==null && this.user!=null){
				addActionError("Error saving CDO personal information! Biodata was not submitted.");
				return Action.ERROR;
			}else if(this.cdoBioData!=null && this.user==null){
				addActionError("Error saving CDO personal information! User account was not created.");
				return Action.ERROR;
			}else
				return Action.INPUT;
			
			//addActionMessage("Finalize your registration by filling the form below.");
			//return Action.INPUT;
		}else{
			addActionError("Error occurred! No record matched the Username & official Email you supplied. Enter a valid Username and official Email to proceed");
			return Action.ERROR;
		}
	}
	
	public String continueRegistration(){
		if(this.appKey!=null)
			this.appStarter = this.cdoApplicationService.findAppStarterByKey(this.appKey);
		
		if(this.appStarter!=null){
			if(this.appStarter.getStatus().equals(STATUS.COMPLETED)){
				addActionError("Error occurred! Your personal information entry has been completed");
				addActionError("Please login to proceed with your training registration.");
				return Action.ERROR;
			}else{
				this.cdoBioData = this.appStarter.getBiodata();
				this.announcement = this.appStarter.getAnnouncement();
				
				if(this.announcement!=null){
					if(this.announcement.getType().equals("Group")){
						this.cdoApplication = this.cdoApplicationService.findApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
						return "group";
					}else if(this.announcement.getType().equals("Graduate")){
						this.cdoGraduateApplication = this.cdoApplicationService.findGraduateApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
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
						return "graduate";
					}else if(this.announcement.getType().equals("Non-graduate")){
						this.cdoNonDegreeApplication = this.cdoApplicationService.findNonDegreeApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
						return "nongraduate";
					}else if(this.announcement.getType().equals("Individual")){
						this.cdoIndividualApplication = this.cdoApplicationService.findIndividualApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
						return "individual";
					}else if(this.announcement.getType().equals("In-house Group")){
						this.cdoInhouseApplication = this.cdoApplicationService.findInHouseApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
						return "inhousegroup";
					}else if(this.announcement.getType().equals("Staff Development")){
						this.cdoStaffDevApplication = this.cdoApplicationService.findStaffDevApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
						return "staffdevelopment";
					}else if(this.announcement.getType().equals("Other")){
						this.cdoGraduateApplication = this.cdoApplicationService.findGraduateApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
						return "other";
					}else if(this.announcement.getType().equals("Sabbatical")){
						this.cdoSabbaticalApplication = this.cdoApplicationService.findSabbaticalApplication(this.announcement, this.cdoBioData, SUBMISSIONSTATUS.Draft);
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
						return "sabbatical";
					}
				}
			}
			addActionMessage("Finalize your application by filling the form below.");
			return Action.INPUT;
		}else{
			addActionError("Error occurred! No record matched the application key you supplied. Enter a valid application key to proceed");
			return Action.ERROR;
		}
	}
	
	public String incompleteRegistration(){
		if(this.appKey!=null && this.email!=null){
			this.appStarter = this.cdoApplicationService.findByAppKeyAndEmail(this.appKey, this.email);
		
			if(this.appStarter!=null){
				if(this.appStarter.getStatus().equals(STATUS.COMPLETED)){
					addActionError("Error occurred! Your personal information entry has been completed");
					addActionError("Please login to proceed with your training registration.");
					return Action.ERROR;
				}else{
					this.cdoBioData = this.appStarter.getBiodata();
					this.announcement = this.appStarter.getAnnouncement();
					this.user = this.appStarter.getBiodata().getOwner();
				}
				addActionMessage("Finalize your application by filling the form below.");
				return Action.SUCCESS;
			}else{
				addActionError("Error occurred! No record matched the application key & email you supplied.");
				addActionError("Enter a valid application key & email to proceed");
				return Action.ERROR;
			}
		}else{
			if(this.appKey==null)
				addActionError("Your application key field should not be empty.");
			if(this.email==null)
				addActionError("Your email field should not be empty.");
			
			return Action.ERROR;
		}
	}
	
	public String myPassport() {
		//Uploading of applicants passports getCdoBioData()
		ApplicantsBioData bio = null;
		if(this.bioId!=null)
			bio = this.cdoApplicationService.findBioData(this.bioId);
		
		try {
			if (this.uploads != null) {
				if (this.uploads.size() > 0) {
					for (File file : this.uploads) {
						String newName = distinctName() + "." + getExtension(this.uploadFileNames.get(this.uploads.indexOf(file)).toString().replace(" ", "_"));
						File fileToCreate = new File(getPath() + "WebContent/passports/", newName);
						FileUtils.copyFile(file, fileToCreate);						
						bio.setFileName(thePath() + newName);
						this.cdoApplicationService.save(bio);
						System.out.println("this.cdoBioData: " + bio);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("File upload error. " + e.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	@Validations(requiredStrings = { 
			@RequiredStringValidator(fieldName = "cdoBioData.firstName", trim=true, message = "Enter your first name"),
			@RequiredStringValidator(fieldName = "cdoBioData.lastName", trim=true, message = "Enter your last name"),
			//@RequiredStringValidator(fieldName = "cdoBioData.dateOfBirth", trim=true, message = "Enter your date of birth"),
			@RequiredStringValidator(fieldName = "cdoBioData.nationality", trim=true, message = "Select your current nationality"),
			//@RequiredStringValidator(fieldName = "cdoBioData.nationality", trim=true, message = "Enter your nationality"),
			@RequiredStringValidator(fieldName = "cdoBioData.permanentAddress", trim=true, message = "Enter your permanent address"),
			@RequiredStringValidator(fieldName = "cdoBioData.correspondenceEmailAddress", trim=true, message = "Enter your email address")},
			requiredFields = { @RequiredFieldValidator(fieldName = "cdoBioData.title", message = "Select your title"), 
			@RequiredFieldValidator(fieldName = "cdoBioData.gender", message = "Select your gender")//, 
			//@RequiredFieldValidator(fieldName = "cdoBioData.english", message = "Select your understanding level of english") 
			})
	public String doRegister(){              
		try{
			if(this.announcementId!=null)
				this.announcement =this.announcementService.find(this.announcementId);
				
			if(this.announcement!=null){
				if(this.cdoBioData!=null){
					if(this.cdoBioData.getDateOfBirth()==null){
						addActionError("Error occurred! Enter your valid date of birth.");
						return Action.ERROR;
					}
					
					if(!isValidEmailAddress(this.cdoBioData.getCorrespondenceEmailAddress())){
						addActionError("Error occurred! Enter a valid email address.");
						return Action.ERROR;
					}
				}
				
				if(this.cdoBioData.getStatus().equals(org.iita.trainingunit.applications.model.ApplicantsBioData.STATUS.REGISTERED)){
					addActionError("Error occurred! Your personal information entry has been completed");
					addActionError("Please login to proceed with your training registration.");
					return Action.ERROR;
				}
				
				//Check if user exists and Save User
				userProperties();
					
				//Checking if biodata exists and Saving BioData
				this.cdoBioData.setStatus(org.iita.trainingunit.applications.model.ApplicantsBioData.STATUS.REGISTERED);
				this.cdoApplicationService.save(this.cdoBioData, this.appStarter);
				
				if(this.cdoBioData!=null && this.user!=null){
					addActionMessage("You are almost done! Login and complete your application.");
					return Action.SUCCESS;
				}else if(this.cdoBioData==null && this.user!=null){
					addActionError("Error saving CDO personal information! Biodata was not submitted.");
					return Action.ERROR;
				}else if(this.cdoBioData!=null && this.user==null){
					addActionError("Error saving CDO personal information! User account was not created.");
					return Action.ERROR;
				}else
					return Action.INPUT;
			}else{
				addActionError("Error saving CDO personal information! Training announcement is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO personal information! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	@Validations(requiredStrings = { 
			@RequiredStringValidator(fieldName = "cdoBioData.firstName", trim=true, message = "Enter your first name"),
			@RequiredStringValidator(fieldName = "cdoBioData.lastName", trim=true, message = "Enter your last name"),
			//@RequiredStringValidator(fieldName = "cdoBioData.dateOfBirth", trim=true, message = "Enter your date of birth"),
			@RequiredStringValidator(fieldName = "cdoBioData.nationality", trim=true, message = "Select your nationality"),
			@RequiredStringValidator(fieldName = "cdoBioData.permanentAddress", trim=true, message = "Enter your permanent address"),
			@RequiredStringValidator(fieldName = "cdoBioData.correspondenceEmailAddress", trim=true, message = "Enter your email address")},
			requiredFields = { @RequiredFieldValidator(fieldName = "cdoBioData.title", message = "Select your title"), 
			@RequiredFieldValidator(fieldName = "cdoBioData.gender", message = "Select your gender")//, 
			//@RequiredFieldValidator(fieldName = "cdoBioData.english", message = "Select your understanding level of english") 
			})
	public String saveDraft(){
		try {
			if (this.announcementId!=null)
				this.announcement =this.announcementService.find(this.announcementId);
			
			if(this.cdoBioData!=null && this.cdoBioData.getId()==null){
				this.user  = this.cdoApplicationService.findUserByEmail(this.cdoBioData.getCorrespondenceEmailAddress());
				
				if(this.user!=null && this.user.getId()!=null){
					addActionError("Error occurred! Email address already exists.");
					return Action.ERROR;
				}
			}
			/*if(this.trainingOption!=null && this.announcement==null){
				System.out.println("SAVEDRAFT METHOD - ANNOUNCEMENT LOOKUP ACTION");
				this.announcement =this.announcementService.lookUp(this.trainingOption, org.iita.trainingunit.announcements.model.Announcement.STATUS.Application);
				System.out.println("SAVEDRAFT METHOD - CHECK ANNOUNCEMENT: " + this.announcement);
			}*/
			
			if (this.announcement!=null){
				if (this.cdoBioData!=null){
					if (this.cdoBioData.getDateOfBirth()==null){
						addActionError("Error occurred! Enter your valid date of birth.");
						return Action.ERROR;
					}
					
					if(!isValidEmailAddress(this.cdoBioData.getCorrespondenceEmailAddress())){
						addActionError("Error occurred! Enter a valid email address.");
						return Action.ERROR;
					}
				}
				
				if(this.cdoBioData.getStatus().equals(org.iita.trainingunit.applications.model.ApplicantsBioData.STATUS.REGISTERED)){
					addActionError("Error occurred! Your personal information entry has been completed");
					addActionError("Please login to proceed with your training registration.");
					return Action.ERROR;
				}
				
				//Check if user exists and Save User
				ApplicantsBioData bio = null;
				if(this.cdoBioData!=null)
					if(this.cdoBioData.getId()==null)
						bio = this.cdoApplicationService.getBioDataByRefNumber(this.cdoBioData.getCorrespondenceEmailAddress());
				
				if(bio==null){
					userProperties();
				}else{
					addActionError("Error saving CDO personal information! Biodata with supplied email already exists.");
					return Action.ERROR;
				}
				//Checking if biodata exists and Saving BioData
				//if(this.userExists==false)
					this.cdoApplicationService.save(this.cdoBioData, null);
				//else{
				//	addActionError("Error saving CDO personal information! User account already exists in the system.");
				//	return Action.ERROR;
				//}
					
					
				if(this.appStarterId==null){
					if(this.cdoBioData!=null && this.announcement!=null){
						ApplicationStarter appStarter = new ApplicationStarter();
						appStarter.setBiodata(this.cdoBioData);
						appStarter.setAnnouncement(this.announcement);
						appStarter.setAppKey(StringUtil.getRandomAlphaNumericString(10).toUpperCase());
						appStarter.setEmail(this.cdoBioData.getCorrespondenceEmailAddress());
						this.appStarter = this.cdoApplicationService.save(appStarter);
					}
				}
				
				if(this.cdoBioData!=null && this.user!=null){
					addActionMessage("Personal information successfully saved! Proceed to registration if you are done with your editing.");
					addActionMessage("Your Application Key is: " + this.appStarter.getAppKey() + ".");
					addActionMessage("This key in combination with your email will enable you continue with editing of your bio-data until you complete your registration. Please keep it safe if you would need it.");
					return Action.SUCCESS;
				}else if(this.cdoBioData==null && this.user!=null){
					addActionError("Error saving CDO personal information! Biodata was not submitted.");
					return Action.ERROR;
				}else if(this.cdoBioData!=null && this.user==null){
					addActionError("Error saving CDO personal information! User account was not created.");
					return Action.ERROR;
				}else
					return Action.INPUT;
			}else{
				addActionError("Error saving CDO personal information! Training announcement is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error saving CDO application! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	//private void appBiodataProperties(){
		//Checking if biodata exists
		//if(this.cdoBioData!=null){
			//System.out.println("BIO ID: " + this.cdoBioData.getId());
			//ApplicantsBioData bio = this.cdoApplicationService.getBioDataByRefNumber(this.cdoBioData.getEmailAddress());
			//if(bio==null){	
				//Saving BioData
				//if(this.uploads!=null)
				//	if(this.uploads.size()!=0)
				//		this.cdoBioData.setFileName(this.uploadFileNames.get(0).toString().replace(" ", "_"));
					
				//if(this.user!=null)
				//	this.cdoBioData.setOwner(this.user);
				
				//this.cdoApplicationService.save(this.cdoBioData);
			//}else{
				//this.cdoBioData = this.cdoApplicationService.getBioDataByRefNumber(this.cdoBioData.getEmailAddress());
				//if(this.uploads!=null && this.cdoBioData.getFileName()==null)
				//	if(this.uploads.size()!=0)
				//		this.cdoBioData.setFileName(this.uploadFileNames.get(0).toString());
			
				//if(this.user!=null && this.cdoBioData.getOwner()==null)
				//	this.cdoBioData.setOwner(this.user);
				
				//this.cdoApplicationService.save(this.cdoBioData);
			//}
	//	}
	//}
	
	private void userProperties(){
		
		if(this.cdoBioData!=null)
			this.user  = this.cdoApplicationService.findUserByEmail(this.cdoBioData.getCorrespondenceEmailAddress());
			
		if(this.user==null){
			//Supply lookups, roles and save user
			if(this.cdoBioData!=null){
				this.lookups.add(this.cdoBioData.getCorrespondenceEmailAddress());
				this.roles.add("ROLE_APPLICANT");
				this.user = new User();
				
				checkRoles();// this ensures that 'false' value is removed from roles should no role is checked in the view checkboxes
				
				this.user.setAuthenticationType(AuthenticationType.PASSWORD);
				this.user.setDisplayName(this.cdoBioData.getLastName() + ", " + this.cdoBioData.getFirstName());
				this.user.setFirstName(this.cdoBioData.getFirstName());
				this.user.setLastName(this.cdoBioData.getLastName());
				this.user.setUserName(this.cdoBioData.getFirstName().toLowerCase().substring(0, 3) + this.cdoBioData.getLastName().toLowerCase());
				this.user.setMail(this.cdoBioData.getCorrespondenceEmailAddress());
				this.userPassword = StringUtil.getRandomAlphaNumericString(7);
				this.user.setPassword(org.springframework.security.util.Sha512DigestUtils.shaHex(this.userPassword));
				this.user.setDescription(this.userPassword);
				this.user.setStatus(UserStatus.ENABLED);
				this.user = this.cdoApplicationService.save(this.user);
					
				addLookups();
				addRoles();
				this.user = this.cdoApplicationService.save(this.user);
				this.cdoBioData.setOwner(this.user);
			}
		}else if(this.cdoBioData!=null)
			this.cdoBioData.setOwner(this.user);
		
	}
	
	@Override
	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	@Override
	public void setUploadsFileName(List<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	@Override
	public void setUploadsContentType(List<String> uploadContentTypes) {
		// TODO Auto-generated method stub
	}

	public void setPassportStorage(String passportStorage) {
		this.passportStorage = passportStorage;
	}

	public String getPassportStorage() {
		return passportStorage;
	}

	private void checkRoles() {
		if (roles.size() == 1) {
			if (roles.get(0).equals("false")) {
				roles.remove(0);
			}
		}
	}

	private void addLookups() {
		// remove initial lookup values for this user
		List<UserLookup> userLookup;
		if (this.user != null) {
			userLookup = this.user.getLookups();
			if (userLookup.size() > 0) {
				for (UserLookup lookup : userLookup) {
					lookupService.remove(lookup);
				}
			}
		}

		// create new lookup values for user based on the submitted form
		userLookup = new ArrayList<UserLookup>();
		for (String newLookup : lookups) {
			System.out.println("OUTER USER SAVE New lookup: " + newLookup);
			UserLookup lookup = new UserLookup();
			lookup.setIdentifier(newLookup);
			lookup.setUser(this.user);
			userLookup.add(lookup);
		}
		this.user.setLookups(userLookup);
	}

	private void addRoles() {
		// remove initial role values for this user
		List<UserRole> userRoles = this.user.getRoles();
		if (userRoles.size() > 0) {
			for (UserRole role : userRoles) {
				roleService.remove(role);
			}
		}
		// create new role values for user based on the submitted form
		userRoles = new ArrayList<UserRole>();
		for (String newRole : roles) {
			System.out.println("OUTER USER SAVE New role: " + newRole);
			UserRole role = new UserRole();
			role.setApplication("training");
			role.setRole(newRole);
			role.setUser(this.user);
			userRoles.add(role);
		}
		this.user.setRoles(userRoles);
	}

	/**
	 * Delete biodata action.
	 * 
	 * @return
	 */
	public String delete() {
		if (this.cdoBioData == null) {
			addActionError("No Application record provided.");
			return Action.ERROR;
		}

		try {
			this.cdoApplicationService.delete(getPrincipal(), getUser(), this.cdoBioData);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	public void setAppStarterId(Long appStarterId) {
		this.appStarterId = appStarterId;
	}

	//public Long getAppStarterId() {
	//	return appStarterId;
	//}

	//public void setAppStarter(ApplicationStarter appStarter) {
	//	this.appStarter = appStarter;
	//}

	public ApplicationStarter getAppStarter() {
		return appStarter;
	}

	public void setBioId(Long bioId) {
		this.bioId = bioId;
	}

	public Long getBioId() {
		return bioId;
	}
}
