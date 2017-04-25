package org.iita.trainingunit.applications.action;

import org.iita.trainingunit.applications.service.GraduateResearchTrainingService;

import com.opensymphony.xwork2.Action;

public class GraduateResearchTrainingAction {
	private GraduateResearchTrainingService graduateResearchTrainingService;
	
	public GraduateResearchTrainingAction(GraduateResearchTrainingService gRTService){
		this.graduateResearchTrainingService = gRTService;
	}
	
	public String execute() {
		return Action.SUCCESS;
	}
}