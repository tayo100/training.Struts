package org.iita.trainingunit.announcements.action;

import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.announcements.service.TrainingProposalService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class PublicProjectAnnouncementAction extends BaseAction implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1417523288661425735L;
	private TrainingProposalService trainTheTrainerService;

	
	private List<TrainingProposal> projects;
	private Long id;
	private TrainingProposal project; 
	
	public PublicProjectAnnouncementAction(TrainingProposalService trainTheTrainerService) {
		this.trainTheTrainerService = trainTheTrainerService;
	}
	
	public List<TrainingProposal> getProjects() {
		return projects;
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
	
	public void prepare(){
		if(this.id!=null)
			this.project =this.trainTheTrainerService.find(this.id);

		this.projects = this.trainTheTrainerService.list();
	}
	
	public String execute() {
		return Action.SUCCESS;
	}
	
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "announcement.type", trim=true, message = "Select announcement type"),
			@RequiredStringValidator(fieldName = "announcement.title", trim=true, message = "Enter announcement title"),
			@RequiredStringValidator(fieldName = "announcement.introduction", trim=true, message = "Enter announcement introduction")})
	public String save(){
		try{
			if(this.project!=null){
				
				this.trainTheTrainerService.save(this.project);//, null, null);
				
				if(this.project.getId()!=null)
					addActionMessage("Announcement updated successfully!");
				else
					addActionMessage("Announcement filed successfully!");
							
				return Action.SUCCESS;
			}else{
				addActionError("Error adding CDO announcement! Announcement entity is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error adding CDO announcement! " + e.getMessage());
			return Action.ERROR;
		}
	}
	
	public void setProject(TrainingProposal project) {
		this.project = project;
	}

	public TrainingProposal getProject() {
		return project;
	}
}