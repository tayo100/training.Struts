/**
 * training.Struts Feb 5, 2010
 */
package org.iita.trainingunit.action;

import java.util.List;

import org.iita.crm.action.BaseProfileAction;
import org.iita.struts.webfile.ServerFile;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.LiferayService;
import org.iita.trainingunit.service.SelectionService;
import org.iita.trainingunit.service.TrainingUnitDataException;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class TrainingProgramProfileAction extends BaseProfileAction<TrainingProgram> {

	private TrainingUnitService service;
	private LiferayService liferayService;
	private SelectionService selectionService;
	private TrainingProgram group;
	private boolean selectedTrainingProgram;

	private String[] selectedCrps;
	private String[] selectedHubs;
	private String[] selectedCoreCompetencies;
	private String[] selectedSubPrograms;

	
	/**
	 * @param trainingUnitService
	 * 
	 */
	public TrainingProgramProfileAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	public void setGroup(TrainingProgram group) {
		this.group = group;
	}

	public TrainingProgram getGroup() {
		return group;
	}

	public void setSelectionService(SelectionService selectionService) {
		this.selectionService = selectionService;
	}

	/**
	 * @return the selectedTrainee
	 */
	public boolean isSelectedTrainingProgram() {
		return selectedTrainingProgram;
	}

	/**
	 * @param selectedTrainee the selectedTrain<property name="journalArticleService" ref="journalArticleServiceSoap" />ee to set
	 */
	public void setSelectedTrainingProgram(boolean selectedTrainingProgram) {
		this.selectedTrainingProgram = selectedTrainingProgram;
	}

	public List<ServerFile> getGroupFiles() {
		return this.service.getTrainingProgramFiles(this.profile, null);
	}

	public String[] getSelectedCrps() {
		return this.selectedCrps;
	}

	public void setCrps(String[] selectedCrps) {
		this.selectedCrps = selectedCrps;
	}
	
	public String[] getSelectedHubs() {
		return this.selectedHubs;
	}

	public void setHubs(String[] selectedHubs) {
		this.selectedHubs = selectedHubs;
	}
	
	public String[] getSelectedCoreCompetencies() {
		return this.selectedCoreCompetencies;
	}

	public void setCoreCompetencies(String[] selectedCoreCompetencies) {
		this.selectedCoreCompetencies = selectedCoreCompetencies;
	}
	
	public String[] getSelectedSubPrograms() {
		return this.selectedSubPrograms;
	}

	public void setSubPrograms(String[] selectedSubPrograms) {
		this.selectedSubPrograms = selectedSubPrograms;
	}
	
	/**
	 * @see org.iita.trainingunit.action.BaseProfileAction#loadProfile()
	 */
	@Override
	protected TrainingProgram loadProfile() {
		this.group = this.service.loadTrainingProgram(this.id);
		return group;
	}

	@Override
	public String execute() {
		if (super.id != null) {
			isSelected();
			LOG.debug(selectedTrainingProgram + " Group training is selected!");
		}
		
		this.selectedCrps = this.service.getSelectedCrps(this.group);
		this.selectedHubs = this.service.getSelectedHubs(this.group);
		this.selectedCoreCompetencies = this.service.getSelectedCoreCompetencies(this.group);
		this.selectedSubPrograms = this.service.getSelectedSubPrograms(this.group);
		
		return Action.SUCCESS;
	}

	public String update() {
		System.out.println("profile is: " + profile);
		this.service.update(this.profile, this.selectedCrps, this.selectedHubs, this.selectedCoreCompetencies, this.selectedSubPrograms);		
		return "reload";
	}

	public String postToLiferay() {
		try {
			this.liferayService.addArticle(this.profile);
			addActionMessage("Posting done successfully!");
		} catch (TrainingUnitDataException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String remove() throws TrainingUnitDataException {
		this.group = this.service.loadTrainingProgram(this.id);

		try {
			this.service.removeGroupTraining(this.group);
		} catch (javax.persistence.PersistenceException e) {
			addActionError("Group Training could not be removed due to constraints violation.");
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	/**
	 * @param liferayService the liferayService to set
	 */

	public void setLiferayService(LiferayService liferayService) {
		this.liferayService = liferayService;
	}

	public void isSelected() {
		this.selectedTrainingProgram = this.selectionService.getSelectedList().getSelectedTrainingPrograms().contains(super.id);
	}

	public String removeAttendance() throws TrainingUnitDataException {
		this.group = this.service.loadTrainingProgram(this.id);

		try {
			this.service.removeAttendance(this.group);
		} catch (javax.persistence.PersistenceException e) {
			addActionError("Group Training could not be removed due to constraints violation.");
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}
	
	public String updateFiles(){
		System.out.println("Testing file updates!");
		this.service.updateAllTrainingProgramFiles();
		return Action.SUCCESS;
	}
}
