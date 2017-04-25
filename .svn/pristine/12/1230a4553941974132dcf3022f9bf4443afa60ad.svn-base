/**
 * training.Struts Feb 5, 2010
 */
package org.iita.trainingunit.action;

import java.util.List;

import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.service.TrainingUnitService;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class OrganizationProfileAction extends org.iita.crm.action.OrganizationProfileAction {
	private TrainingUnitService service;
	private List<Trainee> trainees;
	
	/**
	 * @param trainingUnitService
	 * 
	 */
	public OrganizationProfileAction(TrainingUnitService trainingUnitService) {
		super(trainingUnitService);
		this.service = trainingUnitService;
	}
	
	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	@Override
	public String execute() {
		this.trainees = this.service.listTrainees(this.organization);
		return super.execute();
	}
}
