/**
 * training.Struts Feb 5, 2010
 */
package org.iita.trainingunit.action;

import org.iita.trainingunit.service.TrainingUnitService;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class PartnerProfileAction extends org.iita.crm.action.PartnerProfileAction {
	private TrainingUnitService service;
	
	/**
	 * @param trainingUnitService
	 * 
	 */
	public PartnerProfileAction(TrainingUnitService trainingUnitService) {
		super(trainingUnitService);
		this.service = trainingUnitService;
	}

	@Override
	public String execute() {
		return super.execute();
	}
}
