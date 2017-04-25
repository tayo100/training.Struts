package org.iita.trainingunit.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.crm.model.Organization;
import org.iita.service.ExportService;
import org.iita.struts.DownloadableStream;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.AdvancedTrainingSearchException;
import org.iita.trainingunit.service.AdvancedTrainingSearchService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class AdvancedSearchAction extends BaseAction implements Preparable, DownloadableStream {
	private static final long serialVersionUID = 2150901888934942348L;
	protected AdvancedTrainingSearchService advancedTrainingSearchService;
	private ExportService exportService;
	private TrainingUnitService trainingUnitService;
	private String table;
	private String text;
	private Date startDate;
	private Date endDate;
	private String sDate;
	private String eDate;
	private String operands;
	private String origin;
	private String loc;
	private String grade;
	private boolean fullText;
	private boolean groupYearly;
	private String cc;
	private PagedResult<Trainee> pagedTrainee;
	private PagedResult<Trainee> listTrainees;
	
	private PagedResult<TrainingProgram> pagedPrograms;
	private PagedResult<TrainingProgram> listPrograms;
	
	private PagedResult<TrainingLocation> listProposals;
	private PagedResult<TrainingLocation> listAnnouncements;
	private PagedResult<Organization> listOrganizations;
	
	private PagedResult<TrainingProposal> pagedProposals;
	private PagedResult<Organization> pagedOrg;
	private PagedResult<Trainer> pagedTrainer;
	private List<Trainer> usersList;
	private List<Organization> sponsorsList;
	
	private String[] selectedCrps;
	private String[] selectedHubs;
	private String[] selectedCoreCompetencies;
	private String[] selectedTrainers;
	private String[] selectedSponsors;
	
	private String parse2Hubslink;
	private String parse2Crpslink;
	private String parse2Trainerslink;
	private String parse2Coreslink;
	private String parse2Sponsorslink;
	
	
	private List<Integer> traineeYears;
	private List<Integer> trainingProgramYears;
	private List<Integer> activityYears;
	
	private String traineeType;
	private String tpType;
	private String selectedType;
	
	private String scope;
	private int year;
	
	protected int startAt = 0, maxResults = 50;
	private InputStream inputStream;

	public AdvancedSearchAction(AdvancedTrainingSearchService advancedTrainingSearchService, ExportService exportService, TrainingUnitService trainingUnitService) {
		this.advancedTrainingSearchService = advancedTrainingSearchService;
		this.exportService = exportService;
		this.trainingUnitService = trainingUnitService;
	}
	
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getsDate() {
		return sDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void setOperands(String operands) {
		this.operands = operands;
	}

	public String getOperands() {
		return operands;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}
	
	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLoc() {
		return loc;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}
	
	public boolean getFullText() {
		return fullText;
	}

	public void setFullText(boolean fullText) {
		this.fullText = fullText;
	}
	
	public boolean getGroupYearly() {
		return groupYearly;
	}

	public void setGroupYearly(boolean groupYearly) {
		this.groupYearly = groupYearly;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public PagedResult<Trainee> getPagedTrainee() {
		return pagedTrainee;
	}
	
	public PagedResult<Trainer> getPagedTrainer() {
		return pagedTrainer;
	}

	public PagedResult<TrainingProgram> getPagedPrograms() {
		return pagedPrograms;
	}
	
	public PagedResult<TrainingProposal> getPagedProposals() {
		return pagedProposals;
	}

	public PagedResult<Organization> getPagedOrg() {
		return pagedOrg;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	/**
	 * @param traineeType the traineeType to set
	 */
	public void setTraineeType(String traineeType) {
		this.traineeType = traineeType;
	}

	/**
	 * @return the traineeType
	 */
	public String getTraineeType() {
		return traineeType;
	}

	/**
	 * @param tpType the tpType to set
	 */
	public void setTpType(String tpType) {
		this.tpType = tpType;
	}

	/**
	 * @return the tpType
	 */
	public String getTpType() {
		return tpType;
	}
	
	/**
	 * @param selectedType the selectedType to set
	 */
	public void setSelectedType(String selectedType) {
		this.selectedType = selectedType;
	}

	/**
	 * @return the selectedType
	 */
	public String getSelectedType() {
		return selectedType;
	}
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCc() {
		return cc;
	}
	
	/**
	 * @return the traineeYears
	 */
	public List<Integer> getTraineeYears() {
		return this.traineeYears;
	}
	
	/**
	 * @return the trainingProgramYears
	 */
	public List<Integer> getTrainingProgramYears() {
		return this.trainingProgramYears;
	}
	
	/**
	 * @return the activityYears
	 */
	public List<Integer> getActivityYears() {
		return this.activityYears;
	}
	
	public String getParse2Crpslink(){
		return this.parse2Crpslink;
	}
	
	public PagedResult<Trainee> getListTrainees() {
		return listTrainees;
	}
	
	public PagedResult<TrainingProgram> getListPrograms() {
		return listPrograms;
	}
	
	public PagedResult<TrainingLocation> getListProposals() {
		return listProposals;
	}
	
	public PagedResult<TrainingLocation> getListAnnouncements() {
		return listAnnouncements;
	}
	
	public PagedResult<Organization> getListOrganizations() {
		return listOrganizations;
	}
	
	public String[] getSelectedCrps() {
		if(this.selectedCrps!=null){
			StringBuilder crps = new StringBuilder("");
			if(this.selectedCrps.length>0){
				for(String crp : this.selectedCrps){
					if(!"".equals(crp)){
						if(crps.length()==0)
							crps.append("crps=").append(crp);
						else
							crps.append("&crps=").append(crp);
					}
				}
			}
			if(crps.length()>0) {
				this.parse2Crpslink = crps.toString();
				return this.selectedCrps; 
			} 
		}
		return null;
	}

	public void setCrps(String[] selectedCrps) {
		this.selectedCrps = selectedCrps;
	}
	
	public String getParse2Hubslink(){
			return this.parse2Hubslink;
	}
	
	public String[] getSelectedHubs() {
		if(this.selectedHubs!=null){
			StringBuilder hubs = new StringBuilder("");
			if(this.selectedHubs.length>0){
				for(String hub : this.selectedHubs){
					if(!"".equals(hub)){
						if(hubs.length()==0)
							hubs.append("hubs=").append(hub);
						else
							hubs.append("&hubs=").append(hub);
					}
				}
			}
			if(hubs.length()>0) {
				this.parse2Hubslink = hubs.toString();
				return this.selectedHubs; 
			} 
		}
		return null;
	}

	public void setHubs(String[] selectedHubs) {
		this.selectedHubs = selectedHubs;
	}
	
	public String getParse2Coreslink(){
		return this.parse2Coreslink;
	}
	
	public String[] getSelectedCoreCompetencies() {
		if(this.selectedCoreCompetencies!=null){
			StringBuilder cores = new StringBuilder("");
			if(this.selectedCoreCompetencies.length>0){
				for(String core : this.selectedCoreCompetencies){
					if(!"".equals(core)){
						if(cores.length()==0)
							cores.append("coreCompetencies=").append(core);
						else
							cores.append("&coreCompetencies=").append(core);
					}
				}
			}
			if(cores.length()>0) {
				this.parse2Coreslink = cores.toString();
				return this.selectedCoreCompetencies; 
			} 
		}
		return null;
	}

	public void setCoreCompetencies(String[] selectedCoreCompetencies) {
		this.selectedCoreCompetencies = selectedCoreCompetencies;
	}
	
	public String getParse2Trainerslink(){
		return this.parse2Trainerslink;
	}
	
	public String[] getSelectedTrainers() {
		if(this.selectedTrainers!=null){
			StringBuilder trainers = new StringBuilder("");
			if(this.selectedTrainers.length>0){
				for(String trainer : this.selectedTrainers){
					if(!"".equals(trainer)){
						if(trainers.length()==0)
							trainers.append("trainers=").append(trainer);
						else
							trainers.append("&trainers=").append(trainer);
					}
				}
			}
			if(trainers.length()>0) {
				this.parse2Trainerslink = trainers.toString();
				return this.selectedTrainers; 
			} 
		}
		return null;
	}

	public void setTrainers(String[] selectedTrainers) {
		this.selectedTrainers = selectedTrainers;
	}
	
	/**
	 * @return the usersList
	 */
	public List<Trainer> getUsersList() {
		return this.usersList;
	}
	
	
	public String getParse2Sponsorslink(){
		return this.parse2Sponsorslink;
	}
	
	public String[] getSelectedSponsors() {
		if(this.selectedSponsors!=null){
			StringBuilder sponsors = new StringBuilder("");
			if(this.selectedSponsors.length>0){
				for(String sponsor : this.selectedSponsors){
					if(!"".equals(sponsor)){
						if(sponsors.length()==0)
							sponsors.append("sponsors=").append(sponsor);
						else
							sponsors.append("&sponsors=").append(sponsor);
					}
				}
			}
			if(sponsors.length()>0) {
				this.parse2Sponsorslink = sponsors.toString();
				return this.selectedSponsors; 
			} 
		}
		return null;
	}

	public void setSponsors(String[] selectedSponsors) {
		this.selectedSponsors = selectedSponsors;
	}
	
	/**
	 * @return the usersList
	 */
	public List<Organization> getSponsorsList() {
		return this.sponsorsList;
	}
	
	@Override
	public void prepare(){
		if(this.selectedType!=null && this.selectedType.length()>0) {
			if(this.table.equals("Trainee")) this.traineeType=this.selectedType;
			else if(this.table.equals("TrainingProposal")) this.tpType=this.selectedType;
		}
		
		this.usersList = (List<Trainer>) this.trainingUnitService.findAllTrainers();
		
		this.listTrainees = this.trainingUnitService.listTrainees(this.year);
		
		this.listPrograms = this.trainingUnitService.listPrograms(this.year);
		this.listProposals = this.trainingUnitService.listProposals(this.year);
		this.listAnnouncements = this.trainingUnitService.listAnnouncements(this.year);
		this.listOrganizations = this.trainingUnitService.listOrganizations(this.year);
		
		this.sponsorsList = (List<Organization>) this.trainingUnitService.findAllOrganizations();
	}

	public String query() {		
		if(this.table!=null){
			if(this.traineeType!=null && this.traineeType.length()>0) 
				this.selectedType = this.traineeType;
			else if(this.tpType!=null && this.tpType.length()>0) 
				this.selectedType = this.tpType;
			
			//if(this.selectedType!=null && this.selectedType.length()>0) this.traineeType=this.selectedType;
			
			if (this.table.equals("Organization")){
				try {
					this.pagedOrg = this.advancedTrainingSearchService.searchOrg(this.sDate, this.eDate, this.operands, this.loc, this.text, this.startDate, this.endDate, this.startAt, this.maxResults, this.fullText);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}				
	
			if (this.table.equals("Trainee")){
				try {
					this.pagedTrainee = this.advancedTrainingSearchService.searchTrainee(this.sDate, this.eDate, this.operands, this.origin, this.text, this.startDate, this.endDate, this.startAt, this.maxResults, this.fullText, this.selectedType, this.selectedCrps, this.selectedHubs, this.selectedCoreCompetencies, this.selectedTrainers, this.selectedSponsors, this.loc, this.groupYearly, this.cc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			if (this.table.equals("TrainingProgram")){
				try {
					this.pagedPrograms = this.advancedTrainingSearchService.searchPrograms(this.sDate, this.eDate, this.operands, this.loc, this.text, this.startDate, this.endDate, this.startAt, this.maxResults, this.fullText, this.selectedCrps, this.selectedHubs, this.selectedCoreCompetencies, this.selectedTrainers, this.selectedSponsors, this.groupYearly, this.cc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			if (this.table.equals("TrainingProposal")){
				try {
					this.pagedProposals = this.advancedTrainingSearchService.searchTrainingProposal(this.sDate, this.eDate, this.operands, this.loc, this.text, this.startDate, this.endDate, this.startAt, this.maxResults, this.fullText, this.selectedType, this.groupYearly, this.cc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
	
			if (this.table.equals("Trainer")){
				try {
					this.pagedTrainer = this.advancedTrainingSearchService.searchTrainer(this.sDate, this.eDate, this.operands, this.origin, this.text, this.startDate, this.endDate, this.startAt, this.maxResults, this.fullText, this.loc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}				
		}
		return Action.SUCCESS;
	}
	
	/**
	 * Action method to export all Trainee data in XLS file
	 * 
	 * @return
	 */
	public String export() {
		// Export data
		List<Trainee> trainees = null;
		List<TrainingProgram> groups = null;
		List<TrainingProposal> proposals = null;
		List<Organization> orgs = null;
		List<Trainer> trainers = null;
		
		//this.query();
		if(this.table!=null){
			if(this.traineeType!=null && this.traineeType.length()>0) 
				this.selectedType = this.traineeType;
			else if(this.tpType!=null && this.tpType.length()>0) 
				this.selectedType = this.tpType;
			
			if (this.table.equals("Trainee")){
				try {
					trainees = this.advancedTrainingSearchService.searchTrainee(this.sDate, this.eDate, this.operands, this.origin, this.text, this.startDate, this.endDate, this.fullText, this.selectedType, this.selectedCrps, this.selectedHubs, this.selectedCoreCompetencies, this.selectedTrainers, this.selectedSponsors, this.loc, this.groupYearly, this.cc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			if (this.table.equals("TrainingProgram")){
				try {
					groups = this.advancedTrainingSearchService.searchPrograms(this.sDate, this.eDate, this.operands, this.loc, this.text, this.startDate, this.endDate, this.fullText, this.selectedCrps, this.selectedHubs, this.selectedCoreCompetencies, this.selectedTrainers, this.selectedSponsors, this.groupYearly, this.cc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			if (this.table.equals("TrainingProposal")){
				try {
					proposals = this.advancedTrainingSearchService.searchTrainingProposal(this.sDate, this.eDate, this.operands, this.loc, this.text, this.startDate, this.endDate, this.fullText, this.selectedType, this.groupYearly, this.cc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			if (this.table.equals("Organization")){
				try {
					orgs = this.advancedTrainingSearchService.searchOrg(this.sDate, this.eDate, this.operands, this.loc, this.text, this.startDate, this.endDate, this.fullText);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			if (this.table.equals("Trainer")){
				try {
					trainers = this.advancedTrainingSearchService.searchTrainer(this.sDate, this.eDate, this.operands, this.origin, this.text, this.startDate, this.endDate, this.fullText, this.loc);
				} catch (AdvancedTrainingSearchException e) {
					e.printStackTrace();
					addActionError("ERROR: " + e.getMessage());
				}
			}
			
			try {
				if(trainees!=null){
					this.inputStream = this.exportService.exportToStream(
						new String[] { "Full name", "Nationality", "Gender", "DoB", "Start Date", "End Date", "Extension Date", "Duration", "Degree", 
								"Research Location", "University Name", "Univ Supervisor", "Univ Supervisor Email", "Sponsor", 
								"Program", "Sub Programs", "Cost Center", "Keywords", "Research Topic", "IITA Supervisor", "Hubs", "Core Competencies", "CRPs" },
								 
						new String[] { "person.fullName", "person.country", "person.gender", "person.dob", "startDate", "EndDate", "extensionDate", "duration", 
								"degree", "location", "university.title", "univSupervisors", "univSupervisorsEmail", "sponsor", "program", "exportSubPrograms", "costCenters", "keywords", "researchTopic", "iitaSupervisors", "exportHubs", "exportCoreCompetencies", "exportCrps" }, 
						trainees);
				}
				if(groups!=null){
					this.inputStream = this.exportService.exportToStream(
							new String[] {"Title", "Program", "Purpose", "Research Location", "Research Country", "Start date", "End date", "Duration", 
									 "Training Description", "Outcome of Training", "No. of Male Participants", "No. of Female Participants", 
									 "Keywords", "Iita Trainer", "External Trainer", "Cost Center", "Hubs", "Core Competencies", "CRPs" },
							new String[] {"title", "program", "purpose", "location", "country", "startDate", "endDate", "duration", 
									"description", "outcomes", "maleParticipants", "femaleParticipants",
									"keywords", "iitaTrainers", "externalTrainers", "costCenters", "exportHubs", "exportCoreCompetencies", "exportCrps" }, 
								groups);
				}

				if(proposals!=null){
					this.inputStream = this.exportService.exportToStream(
							new String[] {"SubmittedBy", "RequestedBy", "ProgramDirector", "Type", "Unit", "CRP", "CostCenter",
									"Title", "LearningMethod", "CourseContents", "Duration", "TrainingFee($)", 
									 "Accommodation", "Payment", "Keywords", "Trainers", "Locations", "Documents", "Status" },
							new String[] {"owner.fullName", "requester.fullName", "programDirector.fullName", "type", "Unit", "crp", "costCenter",
									"title", "learningMethod", "courseContents", "duration", "trainingFee", 
									 "accommodation", "payment", "keywords", "proposalTrainers", "proposalLocations", "proposalDocuments", "status" }, 
								proposals);
				}
				if(orgs!=null){
					this.inputStream = this.exportService.exportToStream(
						new String[] { "Organization", "Type", "Phone", "Email", "Address", "City", "State", "Country" },
								 
						new String[] { "legalName", "type", "phoneContacts", "emailContacts", "address", "addressCity", 
								"addressState", "addressCountry" }, 
						orgs);
				}
				if(trainers!=null){
					this.inputStream = this.exportService.exportToStream(
						new String[] { "Full name", "Gender", "Training type", "Trainer type", "Notes", "Affiliation", "Country", "Email", "Address", "Phone" },
								 
						new String[] { "person.fullName", "person.gender", "trainingType", "type", "notes", "person.lastAffiliation.organization.shortName", "person.country", "person.lastEmail.email", "person.lastAddress.address", "person.lastPhone.phone" }, 
						trainers);
				}
			} catch (IOException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
			return "download";
		}
		//addActionError(e.getMessage());
		return Action.ERROR;
	}
	/*
	public List<String> getTraineeTypes() {
		return this.advancedTrainingSearchService.getTraineeTypes();
	}
	
	public List<String> getGroupTypes() {
		return this.advancedTrainingSearchService.getGroupTypes();
	}
	*/
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.par.action.training.DownloadableStream#getDownloadFilename()
	 */
	public String getDownloadFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (this.table.equals("Trainee"))
			return "Trainees-" + df.format(new Date()) + ".xls";
		else if (this.table.equals("Organization"))
			return "Organizations-" + df.format(new Date()) + ".xls";
		else if (this.table.equals("TrainingProgram"))
			return "TrainingPrograms-" + df.format(new Date()) + ".xls";
		else if (this.table.equals("TrainingProposal"))
			return "TrainingProposal-" + df.format(new Date()) + ".xls";
		else if (this.table.equals("Trainer"))
			return "Trainers-" + df.format(new Date()) + ".xls";
		else
			return "download-list-" + df.format(new Date()) + ".xls";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.par.action.training.DownloadableStream#getDownloadStream()
	 */
	public InputStream getDownloadStream() {
		return inputStream;
	}
	
	public String yearlyActivities(){
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.activityYears = this.trainingUnitService.getActivityYears(null);
		else
			this.activityYears = this.trainingUnitService.getActivityYears(getUser());
		
		return Action.SUCCESS;
	}
	
	public String yearPickerSearch(){
		if (this.scope.equals("trainee"))
			if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
				this.pagedTrainee = this.advancedTrainingSearchService.searchTrainee(null, this.year, this.startAt, this.maxResults);
			else
				this.pagedTrainee = this.advancedTrainingSearchService.searchTrainee(getUser(), this.year, this.startAt, this.maxResults);
		
		
		if (this.scope.equals("trainingprogram"))
			if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
				this.pagedPrograms = this.advancedTrainingSearchService.searchPrograms(null, this.year, this.startAt, this.maxResults);
			else
				this.pagedPrograms = this.advancedTrainingSearchService.searchPrograms(getUser(), this.year, this.startAt, this.maxResults);

		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.traineeYears = this.trainingUnitService.getTraineeYears(null);
		else
			this.traineeYears = this.trainingUnitService.getTraineeYears(getUser());
		
		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.trainingProgramYears = this.trainingUnitService.getTrainingProgramYears(null);
		else
			this.trainingProgramYears = this.trainingUnitService.getTrainingProgramYears(getUser());
		
		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.activityYears = this.trainingUnitService.getActivityYears(null);
		else
			this.activityYears = this.trainingUnitService.getActivityYears(getUser());
		
		return Action.SUCCESS;
	}
	
}