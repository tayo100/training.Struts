package org.iita.trainingunit.announcements.action;

import org.iita.crm.action.BaseAction;
import org.iita.security.model.User;
import org.iita.struts.AllowedParameters;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.announcements.model.TrainingProposal.STATUS;
import org.iita.trainingunit.announcements.service.TrainingProposalException;
import org.iita.trainingunit.announcements.service.TrainingProposalService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class TrainingProposalAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = -112952152973730337L;
	private TrainingProposalService trainingProposalService;
	private TrainingUnitService trainingUnitService;
	private PagedResult<TrainingProposal> paged;
	private Long id;
	protected int startAt = 0, maxResults = 50;
	private TrainingProposal trainingProposal;
	
	private User requester;
	private User director;
	
	private Long requesterId;
	private Long directorId;
	private String comments;

	public TrainingProposalAction(TrainingProposalService trainingProposalService, TrainingUnitService trainingUnitService) {
		this.trainingProposalService = trainingProposalService;
		this.trainingUnitService = trainingUnitService;
	}

	public PagedResult<TrainingProposal> getPaged() {
		return paged;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}

	public TrainingProposal getTrainingProposal() {
		return trainingProposal;
	}
	
	public void setRequester(User requester) {
		this.requester = requester;
	}

	public void setDirector(User director) {
		this.director = director;
	}

	public void setRequesterId(Long requesterId) {
		this.requesterId = requesterId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments() {
		return comments;
	}

	public void prepare() {
		if (this.id != null)
			this.trainingProposal = this.trainingProposalService.find(this.id);

		if(getUser().hasRole("ROLE_CRM"))
			this.paged = this.trainingProposalService.list(startAt, maxResults);
		else
			this.paged = this.trainingProposalService.list(startAt, maxResults, getUser());

	}

	public String execute() {
		return Action.SUCCESS;
	}
	
	public String delete() throws TrainingProposalException {
		if (this.trainingProposal != null) {
			//necessary because someone might remove the id
			if(!this.trainingProposal.getStatus().equals(STATUS.SUBMITTED) || (this.trainingProposal.getStatus().equals(STATUS.SUBMITTED) && getUser().hasRole("ROLE_CRM"))){
				this.trainingProposalService.delete(this.trainingProposal);
				addActionMessage("Training proposal deleted successfully");
			}else
				addActionMessage("Training proposal cannot be deleted under status - " + this.trainingProposal.getStatus().toString());
		} else {
			addActionError("No record found for deletion!");
		}
		return Action.SUCCESS;
	}
	
	public String newTrainingProposal() throws TrainingProposalException {
		this.trainingProposal = this.trainingProposalService.createNew(getUser());
		return Action.SUCCESS;
	}
	
	@Validations(requiredStrings = { 
			//@RequiredStringValidator(fieldName = "trainingProposal.country", trim = true, message = "Select country"),
			@RequiredStringValidator(fieldName = "trainingProposal.type", trim = true, message = "Select training type"),
			//@RequiredStringValidator(fieldName = "trainingProposal.introduction", trim = true, message = "Enter training introduction"),
			@RequiredStringValidator(fieldName = "trainingProposal.title", trim = true, message = "Enter training title")
			//@RequiredStringValidator(fieldName = "trainingProposal.requester", trim = true, message = "Select training requester"),
			//@RequiredStringValidator(fieldName = "trainingProposal.director", trim = true, message = "Select training program director"),
			//@RequiredStringValidator(fieldName = "trainingProposal.projectInformation", trim = true, message = "Enter project information"),
			//@RequiredStringValidator(fieldName = "trainingProposal.crp", trim = true, message = "Enter crp"),
			//@RequiredStringValidator(fieldName = "trainingProposal.activity", trim = true, message = "Enter activity"),
			//@RequiredStringValidator(fieldName = "trainingProposal.costCenter", trim = true, message = "Enter training cost center to charge"),
			//@RequiredStringValidator(fieldName = "trainingProposal.deadline", trim = true, message = "Enter training deadline")
			//@RequiredStringValidator(fieldName = "trainingProposal.trainingBudget", trim = true, message = "Enter training budget"),
			//@RequiredStringValidator(fieldName = "trainingProposal.background", trim = true, message = "Enter background"),
			//@RequiredStringValidator(fieldName = "trainingProposal.trainingMaterials", trim = true, message = "Enter training materials"),
			//@RequiredStringValidator(fieldName = "trainingProposal.targetParticipants", trim = true, message = "Enter target participants"),
			//@RequiredStringValidator(fieldName = "trainingProposal.resourcePersons", trim = true, message = "Enter resource persons"),
			//@RequiredStringValidator(fieldName = "trainingProposal.objectives", trim = true, message = "Enter training objectives"),
			//@RequiredStringValidator(fieldName = "trainingProposal.expectedOutcome", trim = true, message = "Enter expected training outcome")
			})
	public String save() {
		//try {
			//System.out.println("ENTERED SAVE METHOD ...");
			if (this.requesterId != null) {
				User user = this.trainingUnitService.loadUser(this.requesterId);
				this.requester = user;
			}
			if(this.requester == null){
				addActionError("Requester could not be located in the system user list. Please select requester from the dropdown list if in already in exisitence.");
				return Action.ERROR;
			}
			
			//System.out.println("DIRECTOR ...");
			if (this.directorId != null) {
				User user = this.trainingUnitService.loadUser(this.directorId);
				this.director = user;
			}
			
			if(this.director == null){
				addActionError("Program director could not be located in the system user list. Please select program director from the dropdown list if in already in exisitence.");
				return Action.ERROR;
			}
			
			//System.out.println("TP NOT NULL ...");
			if (this.trainingProposal != null) {
				//if(this.trainingProposal.getStatus()==STATUS.DRAFT){
					
					if(this.trainingProposal.getOwner()==null){
						this.trainingProposal.setOwner(getUser());
					}
					
					this.trainingProposal.setProgramDirector(this.director);
					this.trainingProposal.setRequester(this.requester);
					this.trainingProposal.setStatus(STATUS.DRAFT);
					//System.out.println("ABOUT TO SAVING ...");
					this.trainingProposalService.save(this.trainingProposal);
					//System.out.println("FINISHED SAVING ...");
					addActionMessage("Training proposal successfully saved!");
				//}else{
				//	addActionError("Training proposal cannot be resubmitted with status at " + this.trainingProposal.getStatus().toString());
				//	return Action.ERROR;
				//}
				return Action.SUCCESS;
			} else {
				addActionError("Error submitting training proposal");
				return Action.ERROR;
			}
		//} catch (Exception e) {
		//	addActionError("Error submitting training proposal " + e.getMessage());
		//	return Action.ERROR;
		//}
	}
	
	@Validations(requiredStrings = { 
			//@RequiredStringValidator(fieldName = "trainingProposal.country", trim = true, message = "Select country"),
			@RequiredStringValidator(fieldName = "trainingProposal.type", trim = true, message = "Select training type"),
			@RequiredStringValidator(fieldName = "trainingProposal.introduction", trim = true, message = "Enter training introduction"),
			@RequiredStringValidator(fieldName = "trainingProposal.title", trim = true, message = "Enter training title"),
			@RequiredStringValidator(fieldName = "trainingProposal.type", trim = true, message = "Select training type"),
			//@RequiredStringValidator(fieldName = "trainingProposal.requester", trim = true, message = "Select training requester"),
			//@RequiredStringValidator(fieldName = "trainingProposal.director", trim = true, message = "Select training program director"),
			@RequiredStringValidator(fieldName = "trainingProposal.projectInformation", trim = true, message = "Enter project information"),
			@RequiredStringValidator(fieldName = "trainingProposal.crp", trim = true, message = "Enter crp"),
			@RequiredStringValidator(fieldName = "trainingProposal.activity", trim = true, message = "Enter activity"),
			@RequiredStringValidator(fieldName = "trainingProposal.costCenter", trim = true, message = "Enter training cost center to charge")//,
			//@RequiredStringValidator(fieldName = "trainingProposal.deadline", trim = true, message = "Enter training deadline")
			//@RequiredStringValidator(fieldName = "trainingProposal.trainingBudget", trim = true, message = "Enter training budget"),
			//@RequiredStringValidator(fieldName = "trainingProposal.background", trim = true, message = "Enter background"),
			//@RequiredStringValidator(fieldName = "trainingProposal.trainingMaterials", trim = true, message = "Enter training materials"),
			//@RequiredStringValidator(fieldName = "trainingProposal.targetParticipants", trim = true, message = "Enter target participants"),
			//@RequiredStringValidator(fieldName = "trainingProposal.resourcePersons", trim = true, message = "Enter resource persons"),
			//@RequiredStringValidator(fieldName = "trainingProposal.objectives", trim = true, message = "Enter training objectives"),
			//@RequiredStringValidator(fieldName = "trainingProposal.expectedOutcome", trim = true, message = "Enter expected training outcome")
			})
	public String submit() {
		try {
		if(this.trainingProposal.getStatus()==STATUS.DRAFT){
			if (this.requesterId != null) {
				User user = this.trainingUnitService.loadUser(this.requesterId);
				this.requester = user;
			}
			if(this.requester == null){
				addActionError("Requester could not be located in the system user list. Please select requester from the dropdown list if in already in exisitence.");
				return Action.ERROR;
			}
			
			if (this.directorId != null) {
				User user = this.trainingUnitService.loadUser(this.directorId);
				this.director = user;
			}
			
			if(this.director == null){
				addActionError("Program director could not be located in the system user list. Please select program director from the dropdown list if in already in exisitence.");
				return Action.ERROR;
			}
			
			if(this.trainingProposal.getDeadline() == null){
				addActionError("Deadline should not be empty.");
				return Action.ERROR;
			}
			
			if(this.trainingProposal.getOwner()==null){
				this.trainingProposal.setOwner(getUser());
			}
			
			this.trainingProposal.setStatus(STATUS.SUBMITTED);
			
			this.trainingProposalService.save(this.trainingProposal);
			addActionMessage("Training proposal successfully submitted!");
		}else{
			addActionError("Training proposal cannot be resubmitted with status at " + this.trainingProposal.getStatus().toString());
			return Action.ERROR;
		}
		}catch(Exception e){
			addActionError("Error occurred saving training proposal " + e.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	@AllowedParameters({"id", "comments"})
	public String makeAnnouncement(){
		//System.out.println("MAKE ANNOUNCEMENT");
		try{
			this.trainingProposalService.convertTrainingProposal(this.trainingProposal, this.comments);
			return Action.SUCCESS;
		}catch(Exception e){
			addActionError("ERROR: " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	@AllowedParameters({"id", "comments"})
	public String rejectTrainingProposal(){
		//System.out.println("REJECT TRAINING PROPOSAL");
		this.trainingProposalService.rejectTrainingProposal(this.trainingProposal, getUser(), this.comments);
		return Action.SUCCESS;
	}
	
	@AllowedParameters({"id"})
	public String copy(){
		try{
			this.trainingProposal = this.trainingProposalService.copy(this.trainingProposal, getUser());
			return Action.SUCCESS;
		}catch(Exception e){
			addActionError("ERROR: " + e.getMessage());
			return Action.ERROR;
		}
	}
}