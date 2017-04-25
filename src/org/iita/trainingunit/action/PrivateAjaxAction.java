/**
 * training.Struts Feb 4, 2010
 */
package org.iita.trainingunit.action;

import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
public class PrivateAjaxAction {
	@SuppressWarnings("unused")
	private TrainingUnitService service;

	/**
	 * @param trainingUnitService
	 * 
	 */
	public PrivateAjaxAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	public String execute() {
		return Action.SUCCESS;
	}
}
