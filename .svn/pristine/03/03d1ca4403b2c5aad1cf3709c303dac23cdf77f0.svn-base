package org.iita.trainingunit.applications.action;

import org.iita.struts.BaseAction;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

/**
 * Base class for actions that list TAs
 * 
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public abstract class ListApplicationAction extends BaseAction {
	protected TrainingUnitService trainingUnitService;
	protected int startAt = 0, maxResults = 50;
	protected PagedResult<Application> paged;

	public ListApplicationAction(TrainingUnitService trainingUnitService) {
		this.trainingUnitService = trainingUnitService;
	}

	public PagedResult<Application> getPaged() {
		return paged;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
}
