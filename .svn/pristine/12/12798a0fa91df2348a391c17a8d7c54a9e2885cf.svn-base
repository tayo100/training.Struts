package org.iita.trainingunit.announcements.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.announcements.model.TrainTheTrainer;
import org.iita.trainingunit.announcements.service.TrainTheTrainerException;
import org.iita.trainingunit.announcements.service.TrainTheTrainerService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class TrainTheTrainerAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = -112952152973730337L;
	private TrainTheTrainerService trainTheTrainerService;
	private PagedResult<TrainTheTrainer> paged;
	private Long id;
	protected int startAt = 0, maxResults = 50;
	private TrainTheTrainer trainTheTrainer;

	public TrainTheTrainerAction(TrainTheTrainerService trainTheTrainerService) {
		this.trainTheTrainerService = trainTheTrainerService;
	}

	public PagedResult<TrainTheTrainer> getPaged() {
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

	public String delete() throws TrainTheTrainerException {
		if (this.trainTheTrainer != null) {
			//necessary because someone might remove the id
			this.trainTheTrainerService.delete(this.trainTheTrainer);
			addActionMessage("Announcement record deleted!");
		} else {
			addActionError("No record found for deletion!");
		}
		return Action.SUCCESS;
	}

	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "trainTheTrainer.country", trim = true, message = "Select country"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.requestor", trim = true, message = "Select requestor"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.projectInformation", trim = true, message = "Enter project information"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.crp", trim = true, message = "Enter crp"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.activity", trim = true, message = "Enter activity"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.trainingBudget", trim = true, message = "Enter training budget"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.background", trim = true, message = "Enter background"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.trainingMaterials", trim = true, message = "Enter training materials"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.targetParticipants", trim = true, message = "Enter target participants"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.resourcePersons", trim = true, message = "Enter resource persons"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.trainingObjectives", trim = true, message = "Enter training objectives"),
			@RequiredStringValidator(fieldName = "trainTheTrainer.expectedTrainingOutcome", trim = true, message = "Enter expected training outcome"), })
	public String save() {
		try {
			if (this.trainTheTrainer != null) {
				this.trainTheTrainerService.save(this.trainTheTrainer);
				addActionMessage("Training successfully entered!");
				return Action.SUCCESS;
			} else {
				addActionError("Error adding the training");
				return Action.ERROR;
			}
		} catch (Exception e) {
			addActionError("Error adding the training");
			return Action.ERROR;
		}
	}

	public void prepare() {
		if (this.id != null)
			this.trainTheTrainer = this.trainTheTrainerService.find(this.id);

		this.paged = this.trainTheTrainerService.list(startAt, maxResults);
	}

	public String execute() {
		return Action.SUCCESS;
	}

	public void setTrainTheTrainer(TrainTheTrainer trainTheTrainer) {
		this.trainTheTrainer = trainTheTrainer;
	}

	public TrainTheTrainer getTrainTheTrainer() {
		return trainTheTrainer;
	}
}