package org.iita.trainingunit.applications.action;

import java.util.List;

import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class ApprovalAction extends ListApplicationAction {

	public ApprovalAction(TrainingUnitService trainingUnitService) {
		super(trainingUnitService);
	}

	@Override
	public String execute() {
		try {
			//System.out.println("Try it here");
			this.paged = this.trainingUnitService.getAwaitingApproval(getUser(), startAt, maxResults);
		} catch (CDOApplicationException e) {
			//System.out.println("Try it here error");
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		
		if (this.paged.getTotalHits() == 1){
			//System.out.println("Try it here: HIT= " + this.paged.getTotalHits());
			return "single";
		}
		return Action.SUCCESS;
	}
	
	public List<User> waitingFor(Application app) {
		return this.trainingUnitService.getWaitingFor(app);
	}
}