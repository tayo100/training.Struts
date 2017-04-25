package org.iita.trainingunit.action;

import java.util.Date;

import org.iita.crm.model.Person;
import org.iita.trainingunit.model.TraineeEducationalInfo;
import org.iita.trainingunit.service.TrainingUnitService;
import org.jfree.util.Log;

import com.opensymphony.xwork2.Action;

public class AddTraineeEducationalInfoAction {
	private TrainingUnitService service;
	private Person person;
	private Long personId;
	private String degree;
	private Date degreeAwardDate;
	private String university;
	private String universityAddress;
	private TraineeEducationalInfo traineeEducationalInfo;

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setDegreeAwardDate(Date degreeAwardDate) {
		this.degreeAwardDate = degreeAwardDate;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public void setUniversityAddress(String universityAddress) {
		this.universityAddress = universityAddress;
	}

	public TraineeEducationalInfo getTraineeEducationalInfo() {
		return traineeEducationalInfo;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public AddTraineeEducationalInfoAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}
	
	public String execute(){
		this.traineeEducationalInfo = new TraineeEducationalInfo();
		this.person = this.service.loadPerson(personId);
		
		Log.debug(this.person.getFirstName());
		
		traineeEducationalInfo.setPerson(this.person);
		traineeEducationalInfo.setDegree(this.degree);
		traineeEducationalInfo.setUniversity(this.university);
		traineeEducationalInfo.setDegreeAwardDate(this.degreeAwardDate);
		traineeEducationalInfo.setUniversityAddress(this.universityAddress);
		
		this.service.update(traineeEducationalInfo);
		return Action.SUCCESS;
	}
}
