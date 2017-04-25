package org.iita.trainingunit.applications.action;

import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

/**
 * Displays all application records for current user
 * 
 * @author KOraegbunam
 */
@SuppressWarnings("serial")
public class BudgetCodeApplicationAction extends ListApplicationAction {

	public BudgetCodeApplicationAction(TrainingUnitService trainingUnitService) {
		super(trainingUnitService);
	}

	@Override
	public String execute() {
		try {
			super.paged = super.trainingUnitService.getMyBcApplications(getUser(), startAt, maxResults);
		} catch (Exception e) {
			LOG.error(e);
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return SUCCESS;
	}
}
