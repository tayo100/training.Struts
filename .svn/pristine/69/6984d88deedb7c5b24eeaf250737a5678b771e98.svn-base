package org.iita.trainingunit.action;

import java.util.List;

import org.iita.crm.action.BaseProfileAction;
import org.iita.crm.model.Contact;
import org.iita.crm.model.Organization;
import org.iita.crm.service.CRMException;
import org.iita.struts.webfile.ServerFile;
import org.iita.trainingunit.model.Alumni;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.service.AlumniService;
import org.iita.trainingunit.service.SelectionService;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class TraineeProfileAction extends BaseProfileAction<Trainee> {
	private TrainingUnitService service;
	private SelectionService selectionService;
	private AlumniService alumniService;
	private Trainee trainee;

	private List<Contact> contacts;
	private String universityName;
	private boolean selectedTrainee;
	private Alumni alumni;
	
	private String[] selectedCrps;
	private String[] selectedHubs;
	private String[] selectedCoreCompetencies;
	private String[] selectedSubPrograms;

	public TraineeProfileAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	public void setSelectionService(SelectionService selectionService) {
		this.selectionService = selectionService;
	}
	
	/**
	 * @param alumniService the alumniService to set
	 */
	public void setAlumniService(AlumniService alumniService) {
		this.alumniService = alumniService;
	}
	
	/**
	 * @return the selectedTrainee
	 */
	public boolean isSelectedTrainee() {
		return selectedTrainee;
	}

	/**
	 * @param selectedTrainee the selectedTrainee to set
	 */
	public void setSelectedTrainee(boolean selectedTrainee) {
		this.selectedTrainee = selectedTrainee;
	}
	

	/**
	 * @param universityName the universityName to set
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	/**
	 * @return the alumni
	 */
	public Alumni getAlumni() {
		return alumni;
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
	
	@Override
	protected Trainee loadProfile() {
		this.trainee = this.service.loadTrainee(this.id);
		return trainee;
	}
	
	public List<ServerFile> getTraineeFiles() {
		return this.service.getTraineeFiles(this.profile, null);
	}
	
	@Override
	public String execute() {
		this.contacts = this.service.loadContacts(trainee.getPerson());
		if (super.id != null){
			isSelected();
			LOG.debug(selectedTrainee + " Trainee is selected!");
		}
		this.alumni = this.alumniService.getAlumniInfo(this.trainee.getPerson());
		
		this.selectedCrps = this.service.getSelectedCrps(this.trainee);
		this.selectedHubs = this.service.getSelectedHubs(this.trainee);
		this.selectedCoreCompetencies = this.service.getSelectedCoreCompetencies(this.trainee);
		this.selectedSubPrograms = this.service.getSelectedSubPrograms(this.trainee);
		
		return Action.SUCCESS;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public String update() {
		if ((this.profile.getUniversity()==null || this.profile.getUniversity().getId()==null) && this.universityName!=null && this.universityName.length()>0) {
			Organization university;
			try {
				university = this.service.registerOrganization(this.universityName);
			} catch (CRMException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
			this.profile.setUniversity(university);
		}
		
		this.service.update(this.profile, this.selectedCrps, this.selectedHubs, this.selectedCoreCompetencies, this.selectedSubPrograms);
		return "reload";
	}
	
	public void isSelected() {
		this.selectedTrainee = this.selectionService.getSelectedList().getSelectedTrainees().contains(super.id);
	}
}
