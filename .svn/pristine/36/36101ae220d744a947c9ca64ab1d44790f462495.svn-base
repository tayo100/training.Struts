package org.iita.trainingunit.action;

import java.util.Date;

import org.iita.crm.model.Person;
import org.iita.struts.BaseAction;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.service.TrainingUnitDataException;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class TraineeAction extends BaseAction {
	private TrainingUnitService service;
	private Person person;
	private Long personId;
	private String personName;
	private String researchTopic;
	private Date startDate;
	private Date endDate;
	private Trainee trainee;
	private Long id;

	public TraineeAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setResearchTopic(String researchTopic) {
		this.researchTopic = researchTopic;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Trainee getTrainee() {
		return trainee;
	}
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String execute() {
		this.trainee = new Trainee();
		if (this.personId != null) {
			this.person = this.service.loadPerson(personId);
		} else if (this.personName != null) {
			this.person = this.service.createPerson(this.personName);
		}
		
		if(this.person == null){
			addActionError("Person could not be registered due to it is already in existence or blank. Please select Person from the dropdown list if in already in exisitence.");
			return Action.ERROR;
		}
		
		trainee.setResearchTopic(this.researchTopic);
		trainee.setPerson(this.person);
		trainee.setStartDate(startDate);
		trainee.setEndDate(endDate);

		this.service.registerTrainee(trainee);
		return Action.SUCCESS;
	}
	
	public String removeTrainee() throws TrainingUnitDataException {
		this.trainee = this.service.loadTrainee(this.id);
		
		if(this.trainee!=null){
			this.personId = this.trainee.getPerson().getId();
		}
		
		try {
			this.service.removeTrainee(this.trainee);
		}
		catch (javax.persistence.PersistenceException e) {
			addActionError("Trainee could not be removed due to constraints violation.");
			return Action.ERROR;
		}
		
		if(this.personId!=null) return "person";
		return Action.SUCCESS;
	}
}
