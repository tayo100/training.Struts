package org.iita.trainingunit.action;

import org.iita.crm.action.TagBuilderAction;
import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.model.Trainee;

/**
 * @author koraegbunam
 *
 */

@SuppressWarnings("serial")
public class TraineeTagBuilderAction extends TagBuilderAction<Trainee> {
	/**
	 * @param coreCRMService 
	 * 
	 */
	public TraineeTagBuilderAction(CoreCRMService coreCRMService) {
		super(coreCRMService);
	}
	
	/**
	 * @see org.iita.training.action.TagBuilderAction#loadProfile(java.lang.Long)
	 */
	@Override
	protected Trainee loadProfile(Long id) {
		return this.coreCRMService.find(Trainee.class, id);
	}
}
