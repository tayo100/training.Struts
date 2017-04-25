package org.iita.trainingunit.applications.action;

import org.iita.trainingunit.applications.service.NonDegreeTrainingService;

import com.opensymphony.xwork2.Action;

public class NonDegreeTrainingAction {
	private NonDegreeTrainingService nonDegreeTrainingService;
	
	public NonDegreeTrainingAction(NonDegreeTrainingService degreeTrainingService) {
		this.nonDegreeTrainingService = degreeTrainingService;
	}
	
	public String execute() {
		return Action.SUCCESS;
	}
}